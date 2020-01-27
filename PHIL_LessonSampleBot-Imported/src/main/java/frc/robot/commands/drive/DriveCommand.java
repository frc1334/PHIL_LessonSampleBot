/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;
import frc.robot.OI;

public class DriveCommand extends Command {

  boolean hatch;
  int period;

  public DriveCommand() {
    requires(Robot.DriveSubsystem);
    requires(Robot.PneumaticSubsystem);
    requires(Robot.HatchSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    hatch = false;
    period = 0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      // Drive based on the response of the Driver's speed and turn
      Robot.DriveSubsystem.ArcadeDrive(Robot.OI.getDriverSpeed(), Robot.OI.getDriverTurn());
      if (Robot.OI.getHatchSol() && period >= 10) {
          hatch = !hatch;
          period = 0;
          Robot.HatchSubsystem.toggleSol(hatch);
      }
      period++;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
