package frc.robot.auto;

import java.util.List;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.SwerveDriveKinematicsConstraint;
import frc.robot.subsystems.Drivetrain;

public class Trajectories {
    static TrajectoryConfig config = new TrajectoryConfig(Drivetrain.AUTO_MAX_SPEED, Drivetrain.AUTO_MAX_SPEED_ACCELERATION)
                                                         .addConstraint(new SwerveDriveKinematicsConstraint(Drivetrain.getInstance().getKinematics(), Drivetrain.AUTO_MAX_SPEED));
    static TrajectoryConfig slowerconfig = new TrajectoryConfig(Drivetrain.AUTO_MAX_SPEED / 1.5, Drivetrain.AUTO_MAX_SPEED_ACCELERATION / 1.5)
                                                         .addConstraint(new SwerveDriveKinematicsConstraint(Drivetrain.getInstance().getKinematics(), Drivetrain.AUTO_MAX_SPEED));

//     public static Trajectory moveForward = TrajectoryGenerator.generateTrajectory(
//             List.of(new Pose2d(3, 0, Rotation2d.fromDegrees(180)), 
//                     new Pose2d(0, 0, Rotation2d.fromDegrees(180))),
//             config);

//     public static Trajectory rightAndForward = TrajectoryGenerator.generateTrajectory(
//             List.of(new Pose2d(0, 0, Rotation2d.fromDegrees(0)), 
//                     new Pose2d(2, 0, Rotation2d.fromDegrees(0)), 
//                     new Pose2d(4, 2, Rotation2d.fromDegrees(90))),
//             config);
//      public static Trajectory sShaped = TrajectoryGenerator.generateTrajectory(
//             List.of(new Pose2d(0, 0, Rotation2d.fromDegrees(-90)), 
//                     new Pose2d(2, 0, Rotation2d.fromDegrees(90)), 
//                     new Pose2d(4, 0, Rotation2d.fromDegrees(-90))),
//             config);
        // public static Trajectory goToTrench = TrajectoryGenerator.generateTrajectory(
        //         List.of(new Pose2d(4,0, Rotation2d.fromDegrees(180)),
        //                 new Pose2d(0, 1, Rotation2d.fromDegrees(90)),
        //                 new Pose2d(0, 5, Rotation2d.fromDegrees(90))),
        //         config);

        //         public static Trajectory returnFromTrench = TrajectoryGenerator.generateTrajectory(
        //         List.of(new Pose2d(0,5, Rotation2d.fromDegrees(270)),
        //                 new Pose2d(0, 2, Rotation2d.fromDegrees(270)),
        //                 new Pose2d(2, 0, Rotation2d.fromDegrees(0))),
        //         config);


                public static Trajectory chezy_moveToBalls = TrajectoryGenerator.generateTrajectory(
                List.of(new Pose2d(7.7599, 2.5692, Rotation2d.fromDegrees(90)),
                        new Pose2d(7.6535, 6.1576, Rotation2d.fromDegrees(90))),
                        slowerconfig);

                public static Trajectory chezy_moveToShootingLocation = TrajectoryGenerator.generateTrajectory(
                List.of(new Pose2d(7.6535, 6.1576, Rotation2d.fromDegrees(270)),
                        new Pose2d(3.8766, 4.6575, Rotation2d.fromDegrees(180))),
                config);

                public static Trajectory chezy_leftInitiationToScoringZone = TrajectoryGenerator.generateTrajectory(
                List.of(new Pose2d(7.4423, 2.5692, Rotation2d.fromDegrees(90)),
                        new Pose2d(2.4656, 0.6633, Rotation2d.fromDegrees(270))),
                config);

                public static Trajectory chezy_leftScoringBackToStarting = TrajectoryGenerator.generateTrajectory(
                List.of(new Pose2d(2.4656, 0.6633, Rotation2d.fromDegrees(270)),
                         new Pose2d(2.3144, 3.0835, Rotation2d.fromDegrees(180))),
                config);

                public static Trajectory chezy_centerInitiationToScoringZone = TrajectoryGenerator.generateTrajectory(
                List.of(new Pose2d(2.43548, 3.0987, Rotation2d.fromDegrees(270)),
                new Pose2d(2.4354, 0.5423, Rotation2d.fromDegrees(270))),
                config);

                public static Trajectory chezy_rightInitiationToScoringZone = TrajectoryGenerator.generateTrajectory(
                List.of(new Pose2d(0.484, 2.539, Rotation2d.fromDegrees(270)),
                        new Pose2d(2.4354, 0.5423, Rotation2d.fromDegrees(0))),
                config);



                public static Trajectory chezy_outoftheway = TrajectoryGenerator.generateTrajectory(
                List.of(new Pose2d(2.4384, 3.048, Rotation2d.fromDegrees(270)),
                        new Pose2d(2.4384, 1.5348, Rotation2d.fromDegrees(270))),
                config);
                
                // public static Trajectory chezy_moveAway = TrajectoryGenerator.generateTrajectory(
                // List.of(new Pose2d(2.3295, 2.5995, Rotation2d.fromDegrees(90)),
                //         new Pose2d(2.3295, 4.6567, Rotation2d.fromDegrees(0))),
                // config);


                // // public static Trajectory chezy_setUpLeftTrench = TrajectoryGenerator.generateTrajectory(
                // //         List.of(
                // //         new Pose2d(0.832, 4.1122, Rotation2d.fromDegrees(180))),
                // //         config);
                // public static Trajectory chezy_moveThroughTrench = TrajectoryGenerator.generateTrajectory(
                // List.of(
                //         new Pose2d(3.0382, 2.4354, Rotation2d.fromDegrees(90)),
                //         new Pose2d(0.832, 4.1122, Rotation2d.fromDegrees(180)),
                //         new Pose2d(0.832, 9.5728, Rotation2d.fromDegrees(90))),
                // config);

                // public static Trajectory chezy_moveBackThroughTrench = TrajectoryGenerator.generateTrajectory(
                // List.of(new Pose2d(0.832, 9.5728, Rotation2d.fromDegrees(270)),
                //         new Pose2d(0.832, 4.1122, Rotation2d.fromDegrees(270))),
                // config);

                // public static Trajectory chezy_shootTrenchBalls = TrajectoryGenerator.generateTrajectory(
                // List.of(
                //         new Pose2d(0.832, 4.1122, Rotation2d.fromDegrees(0)),
                //         new Pose2d(2.4354, 0.7087, Rotation2d.fromDegrees(270))
                //         ),
                // config);
}
