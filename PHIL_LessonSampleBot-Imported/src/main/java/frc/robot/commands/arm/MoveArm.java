/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class MoveArm extends Command {

  double setpoint;

  // Default constructor,checks for dependencies (Robot's static ArmSubsystem) and update instance variables
  public MoveArm(double setpoint) {
    requires(Robot.ArmSubsystem);
    this.setpoint = setpoint;
  }

  // Called just before this Command runs the first time
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    // Set the PID position of the Robot's ArmSubsystem to the setpoint
    Robot.ArmSubsystem.setPIDPosition(setpoint);
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    // Checks to see if the Robot's Arm is within the tolerated range, if so, end the command call
    if (Robot.ArmSubsystem.inRange(setpoint)) {
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }

}
