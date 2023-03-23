// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.configuration;

/** 
 * <h3>Main Robot Constants</h3>
 * 
*/
public class Constants {

    public static final class Drivetrains {


        /**
         * <h3>Mecanum Drive Constants</h3>
         */
        public static final class Mecanum {

            public static final class Chassis {

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
    public static final class InputControls {

        public static final class DriverOne {

            public static final class Primary {

                public static final class Axis {

                }

                public static final class Buttons {

                }

            }

            public static final class Secondary {

                public static final class Axis {

                }

                public static final class Buttons {
                    
                }

            }


        }

        public static final class DriverTwo {

            public static final class Primary {

                public static final class Axis {

                }

                public static final class Buttons {

                }

            }

            public static final class Secondary {

                public static final class Axis {

                }

                public static final class Buttons {
                    
                }
                
            }


        }



    }





}
