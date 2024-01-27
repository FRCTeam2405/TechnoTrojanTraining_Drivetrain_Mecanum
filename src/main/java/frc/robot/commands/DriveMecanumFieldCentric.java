// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MecanumDrivetrain;

public class DriveMecanumFieldCentric extends Command {

  // Subsystem(s)
  private final MecanumDrivetrain sysMecanumDrivetrain;

  // Input Value(s)
  private final DoubleSupplier speedX, speedY, speedRotation;

  /** Creates a new DriveMecanumFieldCentric. */
  public DriveMecanumFieldCentric(MecanumDrivetrain sysMecanumDrivetrain,
                                  DoubleSupplier speedX, DoubleSupplier speedY, DoubleSupplier speedRotation) {

    this.sysMecanumDrivetrain = sysMecanumDrivetrain;
    this.speedX = speedX;
    this.speedY = speedY;
    this.speedRotation = speedRotation;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sysMecanumDrivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    // Call Drive Method for Mecanum Field Centric
    sysMecanumDrivetrain.driveCartesian(speedX.getAsDouble(), 
                                        - speedY.getAsDouble(), 
                                        - speedRotation.getAsDouble(), 
                                        sysMecanumDrivetrain.getAngle());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    // Stop Drive Action for Mecanum Field Centric
    sysMecanumDrivetrain.driveCartesian(0, 
                                        0, 
                                        0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
