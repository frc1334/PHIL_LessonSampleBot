/*----------------------------------------------------------------------------

PID Arm Subsystems using CTRE Talon Libraries, 2018-19 Off-season Dependencies

This subsystem class uses the CTRE TalonSRX Library's PID control for
positional control.

-----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.robot.RobotMap;
import frc.robot.utils.Constants;

public class ArmSubsystem extends Subsystem {

  // This public enumerator is used to keep track of the Arm's destination position for PID
  public enum ArmPosition {
    DEFAULT,
    LOWGOAL,
    MEDGOAL,
    CARGO,
    INTAKE,
    CLIMB2,
    CLIMB3,
    PICKUP
  }
  
  // Initialize the Arm Talon with only RobotMap map values
  TalonSRX Arm = new TalonSRX(RobotMap.Arm);

  // This void method acts as a constructor which initializes the Arm PID configurations
  public void initDefaultCommand() {
    // Default configuration for an Analog Potentiometer on the Arm TalonSRX
    Arm.configSelectedFeedbackSensor(FeedbackDevice.Analog, 0, 0);

    Arm.config_kP(0, Constants.kArmP, 0);
    Arm.config_kI(0, Constants.kArmI, 0);
    Arm.config_kD(0, Constants.kArmD, 0);
    Arm.config_kF(0, Constants.kArmF, 0);

    Arm.configPeakOutputForward(1);
    Arm.configPeakOutputReverse(-1);
  }

  // This void method sets the position of the Arm TalonSRX to a certain potentiometer tick position value (Note: NOT ANGLE)
  public void setPIDPosition (double setpoint) {
    Arm.set(ControlMode.Position, setpoint);
  }

  // This double method returns the current position of the Arm; used for shuffleboard (Note: Returns potentiometer tick value, not angle)
  public double getArmPosition () {
    return Arm.getSelectedSensorPosition(0);
  }

  // This boolean method returns to check if the PID position is within a designated tolerance level (variable stored in Constants.java)
  public boolean inRange (double setpoint) {
    // Check to see if the absolute value between the difference of the current Arm position and the setpoint is within the tolerance range
    if (Math.abs(setpoint - getArmPosition()) <= Constants.kArmTolerance) {
      return true;
    }
    return false;
  }

}
