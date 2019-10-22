/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm.positions;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.arm.*;

public class OutHab extends CommandGroup {

  // This is the Hab outtake position

  public OutHab() {
     // Add a new sequential command called MoveArm to the potentiometer tick position 393
    addSequential(new MoveArm(393));
  }

}
