/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.robot.RobotMap;
import frc.robot.utils.Constants;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  
  // Initialize 2 TalonSRX motor controllers and 2 VictorSPX followers
  TalonSRX Left1 = new TalonSRX(RobotMap.Left1);
  VictorSPX Left2 = new VictorSPX(RobotMap.Left2);
  TalonSRX Right1 = new TalonSRX(RobotMap.Right1);
  VictorSPX Right2 = new VictorSPX(RobotMap.Right2);

  // This void method acts as a constructor, called every initializatino of DriveSubsystem (called in Robot.java)
  public void initDefaultCommand() {
    // Set the VictorSPXs (Left2 and Right2) so that they will follow the movements of the Left1 and Right1 Talons
    Left2.set(ControlMode.Follower, RobotMap.Left1);
    Right2.set(ControlMode.Follower, RobotMap.Right1);
  }

  // Basic Tank Drive Method
  public void TankDrive(double left, double right){
    Left1.set(ControlMode.PercentOutput, left * 0.8);
    Left2.set(ControlMode.PercentOutput, -left * 0.8);
    Right1.set(ControlMode.PercentOutput, -right * 0.8);
    Right2.set(ControlMode.PercentOutput, right * 0.8);
  }

  // Basic Arcade Drive Method
  public void ArcadeDrive (double speed, double turn) {
    TankDrive(speed - turn, - speed - turn);
  }

}
