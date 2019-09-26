/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.commands.*;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.HIDType;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

public class OI {

    // Driver XBox Controller
    public static final XboxController Driver = new XboxController(0);
    // Operator XBox Controller
    public static final XboxController Operator = new XboxController(1);

    // The following lines create individual objects for each interactable control with either the Driver or Operator

    public static JoystickButton OperatorAButton;
    public static JoystickButton OperatorBButton;
    public static JoystickButton OperatorXButton;
    public static JoystickButton OperatorYButton;

    public static JoystickButton OperatorLTrigger;
    public static JoystickButton OperatorRTrigger;

    // Default constructor which initializes and maps the controls (initialized above, e.g., OperatoraButton) to the correct ports on the XBox controller and the right command
    public OI () {

        // Initialize the controls as new objects and map them to the correct XBOx ports
        OperatorAButton = new JoystickButton(Operator, 1);
        OperatorBButton = new JoystickButton(Operator, 2);
        OperatorXButton = new JoystickButton(Operator, 3);
        OperatorYButton = new JoystickButton(Operator, 4);

        OperatorLTrigger = new JoystickButton(Operator, 5);
        OperatorRTrigger = new JoystickButton(Operator, 6);

        // Map them to individual actions/Commands/Command Groups
        

    }

}
