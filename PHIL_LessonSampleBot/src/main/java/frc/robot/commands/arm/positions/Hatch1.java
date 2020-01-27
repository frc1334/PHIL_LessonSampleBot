/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.arm.positions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.arm.*;

public class Hatch1 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Hatch1() {
    addSequential(new MoveArm(100));
  }
}
