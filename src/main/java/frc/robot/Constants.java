package frc.robot;

import java.util.List;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.controller.DifferentialDriveFeedforward;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.numbers.N2;
import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.util.Units;

//Have to add mirrored trajectories if alliance is switched

    public static final class VisionConstants {

        private static final double fieldLength = Units.inchesToMeters((54*12) + 3.25);
        private static final double fieldWidth = Units.inchesToMeters((26*12) + 3.5);
        
        static double wallY = Units.inchesToMeters(351);
        static double wallY2 = Units.inchesToMeters(97);
        public static final AprilTagFieldLayout tagLayout = new AprilTagFieldLayout(
            List.of(

                new AprilTag(1, new Pose3d(Units.inchesToMeters(120.25+300), wallY, Units.inchesToMeters(23.75), new Rotation3d(VecBuilder.fill(0, 0, 1), Units.degreesToRadians(270)))),
                new AprilTag(2, new Pose3d(0, 0, Units.inchesToMeters(51.5),    new Rotation3d(VecBuilder.fill(0, 0, 1), Units.degreesToRadians(90)))),
                new AprilTag(3, new Pose3d(Units.inchesToMeters(214.375+300), Units.inchesToMeters(29.25), Units.inchesToMeters(26.25), new Rotation3d(VecBuilder.fill(0, 0, 1), Units.degreesToRadians(180)))),
                new AprilTag(5, new Pose3d(Units.inchesToMeters(208.125), wallY, Units.inchesToMeters(44), new Rotation3d(VecBuilder.fill(0, 0, 1), Units.degreesToRadians(270)))),
                new AprilTag(6, new Pose3d(0, 0, Units.inchesToMeters(57.0625), new Rotation3d(VecBuilder.fill(0, 0, 1), Units.degreesToRadians(90)))),
                new AprilTag(7, new Pose3d(Units.inchesToMeters(30.5), wallY, Units.inchesToMeters(43), new Rotation3d(VecBuilder.fill(0, 0, 1), Units.degreesToRadians(270))))
            ), VisionConstants.fieldLength, VisionConstants.fieldWidth
        );

        public static final Transform3d robotToCamera = new Transform3d(
            new Translation3d(Units.inchesToMeters(13.125), 0, Units.inchesToMeters(6.125)), 
            new Rotation3d(0, 0, 0)
        );
        
        public static final double camDiagFOV = 95.0;
        public static final double camPitch = robotToCamera.getRotation().getX();
        public static final double camHeight = robotToCamera.getTranslation().getZ();
        public static final double maxLEDRange = 0;
        public static final int camResolutionWidth = 1280;
        public static final int camResolutionHeight = 720;
        public static final double minTargetArea = 10;
    }
