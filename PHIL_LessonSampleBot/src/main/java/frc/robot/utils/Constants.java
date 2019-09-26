/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utils;

public class Constants {

    // Arm PID tune values (Jamie's trick: double the p value until everytime until its approximate)
    public static final double kArmP = 1.9;
    public static final double kArmI = 0.00125;
    public static final double kArmD = 0.0;
    public static final double kArmF = 0.0;

    // The PID tolerance levels (how much/aproximate the acceptable range is)
    public static final double kArmTolerance = 5.0;

}
