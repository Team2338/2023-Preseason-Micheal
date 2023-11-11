// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

@SuppressWarnings("FieldMayBeFinal")
public class Arm extends SubsystemBase {

  private CANSparkMax winch;
  private TalonSRX arm;
  private Encoder encoder;
  private final double armMin = 0;
  private final double[] armMax = {0, 0, 0};
  private int currentLimitIndex = 0;
  public Arm() {
    arm = new TalonSRX(RobotMap.ARM_MOTOR_ID);
    winch = new CANSparkMax(RobotMap.WINCH_MOTOR_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
    encoder = new Encoder(RobotMap.ENCODER_ID_A, RobotMap.ENCODER_ID_B, false, CounterBase.EncodingType.k2X);
  }

  /**
   * @param armPercent Value from -1 to 1 for the arm speed
   * @param winchPercent Value from -1 to 1 for the winch speed
   */
  public void moveArm(double armPercent, double winchPercent) {
    arm.set(TalonSRXControlMode.PercentOutput, armPercent);
    winch.set(winchPercent);
  }

  /**
   *
   * @return double: the current value of the arm encoder
   */
  public double getEncorder() {
    return encoder.get();
  }

  /**
   * Returns the current limits on the arm movement
   * @return array of doubles in this format [arm min, arm max]
   */
  public double[] getCurrentLimits() {
    return new double[]{armMin, armMax[currentLimitIndex]};
  }

  public void advanceArmLimit(int index) {
    if (currentLimitIndex < index) {
      currentLimitIndex = index;
    }
  }
}
