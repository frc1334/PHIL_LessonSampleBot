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
  
  // Initialize the Arm Talon with only RobotMap map values
  TalonSRX Arm = new TalonSRX(RobotMap.Arm);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
