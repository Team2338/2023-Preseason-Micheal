// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

@SuppressWarnings("FieldMayBeFinal")
public class Arm extends SubsystemBase {

  private CANSparkMax winch;
  private TalonSRX arm;
  public Arm() {
    arm = new TalonSRX(RobotMap.ARM_MOTOR_ID);
    winch = new CANSparkMax(RobotMap.WINCH_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
  }

  /**
   * @param armPercent Value from -1 to 1 for the arm speed
   * @param winchPercent Value from -1 to 1 for the winch speed
   */
  public void moveArm(double armPercent, double winchPercent) {
    arm.set(TalonSRXControlMode.PercentOutput, armPercent);
    winch.set(winchPercent);
  }
}
