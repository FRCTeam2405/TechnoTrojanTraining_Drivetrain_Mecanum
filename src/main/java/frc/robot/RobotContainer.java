// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.DriveMecanumFieldCentric;
import frc.robot.commands.DriveMecanumRobotCentric;
import frc.robot.configuration.Constants;
import frc.robot.subsystems.MecanumDrivetrain;

public class RobotContainer {

  // Subsystem(s)
  private final MecanumDrivetrain sysMecanumDrivetrain = new MecanumDrivetrain();

  // Teleop Command(s)


  // Input Device(s)
  private final Joystick inputDriverOnePrimary = new Joystick(Constants.InputControls.DriverOne.Primary.kPortID);
  private final Joystick inputDriverOneSecondary = new Joystick(Constants.InputControls.DriverOne.Secondary.kPortID);

  // Input Button(s)


  public RobotContainer() {

    configureBindings();

    // Drive Command(s)
    DriveMecanumFieldCentric cmdDriveMecanumFieldCentric = new DriveMecanumFieldCentric(
      sysMecanumDrivetrain, 
      () -> (Math.abs(inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedX)) > 0)
              ? inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedX) : 0, 
      () -> (Math.abs(inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedY)) > 0)
              ? inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedY) : 0, 
      () -> (Math.abs(inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedRotational)) > 0)
              ? inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedRotational) : 0);

    DriveMecanumRobotCentric cmdDriveMecanumRobotCentric = new DriveMecanumRobotCentric(
      sysMecanumDrivetrain, 
      () -> (Math.abs(inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedX)) > 0)
              ? inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedX) : 0, 
      () -> (Math.abs(inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedY)) > 0)
              ? inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedY) : 0, 
      () -> (Math.abs(inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedRotational)) > 0)
              ? inputDriverOnePrimary.getRawAxis(Constants.InputControls.DriverOne.Primary.Axis.kSpeedRotational) : 0);

    // Set Default Drivetrain Command - (Field or Robot Centric)
    sysMecanumDrivetrain.setDefaultCommand(
        Constants.Drivetrains.Mecanum.kUseFieldCentric
        ? cmdDriveMecanumFieldCentric : cmdDriveMecanumRobotCentric
    );

  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
