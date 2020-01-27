/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.arm.positions.*;
import frc.robot.commands.intake.*;

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

    public static JoystickButton DriverAButton;

    public static JoystickButton OperatorAButton;
    public static JoystickButton OperatorBButton;
    public static JoystickButton OperatorXButton;
    //public static JoystickButton OperatorYButton;

    public static JoystickButton OperatorLTrigger;
    public static JoystickButton OperatorRTrigger;

    // Default constructor which initializes and maps the controls (initialized above, e.g., OperatoraButton) to the correct ports on the XBox controller and the right command
    public OI () {
        
        DriverAButton = new JoystickButton(Driver, 1);

        // Initialize the controls as new objects and map them to the correct XBOx ports
        OperatorAButton = new JoystickButton(Operator, 1);
        OperatorBButton = new JoystickButton(Operator, 2);
        OperatorXButton = new JoystickButton(Operator, 3);
        //OperatorYButton = new JoystickButton(Operator, 4);

        OperatorLTrigger = new JoystickButton(Operator, 5);
        OperatorRTrigger = new JoystickButton(Operator, 6);

        // Map them to individual actions/Commands/Command Groups (Operator only)

        DriverAButton.whenPressed(new StartingPosition());

        // Operator Buttons
        OperatorAButton.whenPressed(new ArmDefault());
        OperatorBButton.whenPressed(new ArmCargo());
        OperatorXButton.whenPressed(new OutHab());
        
        // Operator Triggers (Intake, Outtake - Intake Flipped)
        OperatorLTrigger.whenPressed(new Intake());
        OperatorRTrigger.whenPressed(new Outtake());

    }

    // This double (decimal number) method returns the difference between the left and right Driver triggers (How much to move forwards/backwards)
    public double getDriverSpeed () {
        return Driver.getTriggerAxis(Hand.kLeft) - Driver.getTriggerAxis(Hand.kRight);
    }

    // This double method returns the x-axis of the Driver top/turn joystick. The value returned would determine how much to turn to the left or right
    public double getDriverTurn () {
        return Driver.getRawAxis(0);
    }

    public boolean getHatchSol () {
        return Operator.getYButton();
    }

}
