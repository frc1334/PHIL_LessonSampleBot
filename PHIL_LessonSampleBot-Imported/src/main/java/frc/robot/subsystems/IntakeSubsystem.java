/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.robot.RobotMap;
import frc.robot.utils.Constants;

public class IntakeSubsystem extends Subsystem {
  
  // Initialize a new TalonSRX for the actions for intake and output
  TalonSRX Intake = new TalonSRX(RobotMap.Intake);  

  public void initDefaultCommand() {
  }

  // This void method takes in or shoots out a piece of cargo, depending on the direction of Talon spin given
  public void intake (boolean in, boolean out) {
    if (in) {
      // Set the 2 intake talons to rotate inwards (negative power at 50%)
      Intake.set(ControlMode.PercentOutput, -0.60);
    } else if (out) {
      Intake.set(ControlMode.PercentOutput, 0.60);
    } else {
      Intake.set(ControlMode.PercentOutput, 0);
    }
  }

}
