/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

public class PneumaticSubsystem extends Subsystem {
  
  // Instantiate a new Compressor with the mapping for the PCM (Pneumatics Control Module) port
  public Compressor Compressor = new Compressor(RobotMap.Compressor);

  public void initDefaultCommand() {
    // Start the Compressor
    Compressor.setClosedLoopControl(true);
  }

  // This void method (no returns) turns the Compressor on
  public void startCompressor () {
    Compressor.setClosedLoopControl(true);
  }

  // This void method turns the Compressor off
  public void stopCompressor () {
    Compressor.setClosedLoopControl(false);
  }
  
}
