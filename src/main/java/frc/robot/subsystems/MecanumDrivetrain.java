// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.configuration.Constants;

public class MecanumDrivetrain extends SubsystemBase {

  // Drive Motor(s)
  private WPI_TalonFX driveFrontLeft;
  private WPI_TalonFX driveFrontRight;
  private WPI_TalonFX driveBackLeft;
  private WPI_TalonFX driveBackRight;

  // Drive Style
  private MecanumDrive driveMecanum;

  // IMU
  private AHRS driveIMU;


  /**
   * <h3>Define Mecanum Drivetrain Subsystem</h3>
   * 
   */
  public MecanumDrivetrain() {

    // Initialize Drive Motor(s)
    driveFrontLeft = new WPI_TalonFX(Constants.Drivetrains.Mecanum.Motors.kFrontLeftPortID);
    driveFrontRight = new WPI_TalonFX(Constants.Drivetrains.Mecanum.Motors.kFrontRightPortID);
    driveBackLeft = new WPI_TalonFX(Constants.Drivetrains.Mecanum.Motors.kBackLeftPortID);
    driveBackRight = new WPI_TalonFX(Constants.Drivetrains.Mecanum.Motors.kBackRightPortID);

    // Motor Configuration(s)
    driveFrontLeft.setInverted(Constants.Drivetrains.Mecanum.Motors.kFrontLeftReversed);
    driveFrontRight.setInverted(Constants.Drivetrains.Mecanum.Motors.kFrontRightReversed);
    driveBackLeft.setInverted(Constants.Drivetrains.Mecanum.Motors.kBackLeftReversed);
    driveBackRight.setInverted(Constants.Drivetrains.Mecanum.Motors.kBackRightReversed);

    // Initialize Macanum Drive
    driveMecanum = new MecanumDrive(driveFrontLeft, driveBackLeft, driveFrontRight, driveBackRight);

    // Initialize IMU
    try {
      driveIMU = new AHRS(SPI.Port.kMXP);
    } 
    catch(RuntimeException ex) {
      DriverStation.reportError("Error Initializing NavX (Field Centric Disabled): " + ex.getMessage(), true);
    }

  }

  public void driveCartesian(double speedX, double speedY, double speedRotation) {

    // Send input speeds to drivetrain method to drive the robot
    // Direct Input (non-field centric)
    driveMecanum.driveCartesian(speedX, speedY, speedRotation);

  }  

  public void driveCartesian(double speedX, double speedY, double speedRotation, Rotation2d angleRotation) {

    // Send input speeds to drivetrain method to drive the robot
    // Field Centric Drive (uses Gyro)
    driveMecanum.driveCartesian(speedX, speedY, speedRotation, getAngle());
  }

  public Rotation2d getAngle() {
    return new Rotation2d(driveIMU.getAngle()) ;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }



}
