// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.configuration;

/** 
 * <h3>Main Robot Constants</h3>
 * 
*/
public class Constants {

    public static final class Drivetrain {

        /**
         * <h3>Mecanum Drive Constants</h3>
         */
        public static final class Mecanum {
            public static final boolean kUseFieldCentric = false;

            public static final class Chassis {

            }

            public static final class Motors {

                // Network Port(s)
                public static final int kFrontLeftPortID = 10;
                public static final int kFrontRightPortID = 11;
                public static final int kBackLeftPortID = 12;
                public static final int kBackRightPortID = 13;

                public static final boolean kFrontLeftReversed = true;
                public static final boolean kFrontRightReversed = false;
                public static final boolean kBackLeftReversed = true;
                public static final boolean kBackRightReversed = false;

                public static final double kOutputModDefault = 0.50;
                public static final double kOutputModHigh = 0.75;
                public static final double kOutputModLow = 0.35;

            }

            public static final class Autonomous {

                public static final class Path {

                }

            }
            
        }

    }

    /**
     * <h3>Input Controls / Devices</h3>
     * <p>Input controls are defined using the generic joystick library
     * which can then relate to any joystick type
     * 
     * <p>Buttons are defined using the action or function name making it easier
     * to re-assign the action to the correct input id when determined
     * 
     * <p>Sub classes created for human elements that will be interacting
     * with defined input devices
     * 
     * <p>A primary and secondary control device is defined for each human element.
     * more can be added if the custom control schema requires
     */
    public static final class InputControl {

        public static final class DriverOne {

            public static final class Primary {
                public static final int kPortID = 0;
                public static final double kDeadband = 0.02;

                public static final class Axis {
                    public static final int kDriveXInputID = 1;
                    public static final int kDriveYInputID = 0;
                    public static final int kDriveRotationXInputID = 4;
                    public static final int kDriveRotationYInputID = 5;

                }

                public static final class Button {
                    public static final int kGyroResetInputID = 1;

                }

            }

        }

        public static final class DriverTwo {

            public static final class Primary {
                public static final int kPortID = 1;
                public static final double kDeadband = 0.02;

                public static final class Axis {

                }

                public static final class Button {

                }

            }

        }

    }

}
