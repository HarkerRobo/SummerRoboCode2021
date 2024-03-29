package frc.robot;

import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.auto.MoveToTargetLocation;
import frc.robot.commands.drivetrain.HSSwerveDriveController;
import frc.robot.commands.drivetrain.RotateInPlace;
import frc.robot.commands.drivetrain.SwerveTranslationAlign;
import frc.robot.commands.intake.MoveBallsToShooter;
import frc.robot.commands.shooter.ShootWithLimelight;
import frc.robot.commands.shooter.Rev;
import frc.robot.commands.shooter.RevHighHood;
import frc.robot.commands.shooter.ShootWithHighHood;
import frc.robot.commands.shooter.ShooterVelocityManual;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;


public class OI {
    private static OI oi;
    private HSGamepad driverGamepad;
    private HSGamepad operatorGamepad;
    public static final double DEADBAND = 0.1;
    public static final int DRIVER_PORT = 0;
    public static final int OPERATOR_PORT = 1;
    
    private OI() {
        driverGamepad = new XboxGamepad(DRIVER_PORT);
        operatorGamepad = new XboxGamepad(OPERATOR_PORT);

        initBindings();
    }

    private void initBindings() {
        // https://docs.google.com/drawings/d/1dSrsltlSsIqcEyNErSiSdRW-P8vYl1y5DzKc4hMTjqs/edit

        // Op
        // A Invert intake
        // B Rev
        // X Align
        // Y Rev hig
        


        driverGamepad.getButtonA().whilePressed(new SwerveTranslationAlign());
        driverGamepad.getButtonB().whilePressed(new ParallelCommandGroup(
            new ShootWithHighHood(),
            new MoveBallsToShooter()
        ));
        driverGamepad.getButtonX().whilePressed(new ParallelCommandGroup(
            new ShootWithLimelight(),
            new MoveBallsToShooter()
        ));
        driverGamepad.getButtonY().whilePressed(new ShooterVelocityManual(70));

        operatorGamepad.getButtonA().whenPressed(new InstantCommand(() -> {
            Intake.getInstance().invertSolenoid();
        }, Intake.getInstance()));
        operatorGamepad.getButtonB().whilePressed(
            new Rev(70)
        );
        operatorGamepad.getButtonY().whilePressed(
            new RevHighHood()
        );
        operatorGamepad.getButtonBumperLeft().whilePressed(new ParallelCommandGroup(
            new ShootWithHighHood(),
            new MoveBallsToShooter()
        ));
        operatorGamepad.getButtonBumperRight().whilePressed(new ParallelCommandGroup(
            new ShootWithLimelight(),
            new MoveBallsToShooter()
        ));
        
        operatorGamepad.getButtonSelect().whenPressed(new InstantCommand(() -> {
            Drivetrain drivetrain = Drivetrain.getInstance();
            drivetrain.getTopLeft().getRotationMotor().setSelectedSensorPosition((Drivetrain.getInstance().getTopLeft().getRotationMotor().getSensorCollection().getPulseWidthRiseToFallUs() - Drivetrain.TL_OFFSET));
            drivetrain.getTopRight().getRotationMotor().setSelectedSensorPosition((Drivetrain.getInstance().getTopRight().getRotationMotor().getSensorCollection().getPulseWidthRiseToFallUs() - Drivetrain.TR_OFFSET));
            drivetrain.getBottomLeft().getRotationMotor().setSelectedSensorPosition((Drivetrain.getInstance().getBottomLeft().getRotationMotor().getSensorCollection().getPulseWidthRiseToFallUs() - Drivetrain.BL_OFFSET));
            drivetrain.getBottomRight().getRotationMotor().setSelectedSensorPosition((Drivetrain.getInstance().getBottomRight().getRotationMotor().getSensorCollection().getPulseWidthRiseToFallUs() - Drivetrain.BR_OFFSET));
        
        }));
        operatorGamepad.getButtonStart().whenPressed(new InstantCommand(() -> {
            Drivetrain.getInstance().getPigeon().addFusedHeading(-Drivetrain.getInstance().getPigeon().getFusedHeading()*63.9886111111111);
            // System.out.println("hfueirryfhiuajknc980qehweo  ");
        }));
        
        // operatorGamepad.getDownDPadButton().whenPressed(new InstantCommand(() -> {
        //     Shooter.getInstance().velAdjustment -= 0.2;
        // }));
        // operatorGamepad.getUpDPadButton().whenPressed(new InstantCommand(() -> {
        //     Shooter.getInstance().velAdjustment += 0.2;
        // }));
        // operatorGamepad.getLeftDPadButton().whenPressed(new InstantCommand(() -> {
        //     Shooter.getInstance().highVelAdjustment -= 0.2;
        // }));
        // operatorGamepad.getRightDPadButton().whenPressed(new InstantCommand(() -> {
        //     Shooter.getInstance().highVelAdjustment += 0.2;
        // }));


        // operatorGamepad.getDownDPadButton().whenPressed(new SequentialCommandGroup(
        //     new HSSwerveDriveController(MoveToTargetLocation.getToTargetTrajectory(), new Rotation2d(0)),
            
        //     new ParallelDeadlineGroup(
        //         new WaitCommand(0.5),
        //         new RotateInPlace()
        //     )
        // ));

    }
    
    public HSGamepad getDriverGamepad(){
        return driverGamepad;
    }
    public HSGamepad getOperatorGamepad(){
        return operatorGamepad;
    }

    public static OI getInstance(){
        if(oi==null)
            oi=new OI();
        return oi;
    }
}
