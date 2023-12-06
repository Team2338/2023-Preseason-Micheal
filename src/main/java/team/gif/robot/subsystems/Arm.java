// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

@SuppressWarnings("FieldMayBeFinal")
public class Arm extends SubsystemBase {

  public TalonSRX winch;
  private final double armMin = 13875;
  private final double[] armMax = {2500, 0, 0};
  private int currentLimitIndex = 0;
  private double currentWinchSpeed;

  public Arm() {
    winch = new TalonSRX(RobotMap.WINCH_MOTOR_ID);

    winch.configFactoryDefault();

    winch.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    winch.setNeutralMode(NeutralMode.Brake);

    winch.setSelectedSensorPosition(0);
    winch.setSensorPhase(true);

    winch.configForwardSoftLimitThreshold(armMin, 10);
    winch.configReverseSoftLimitThreshold(armMax[0], 10);

    winch.configReverseSoftLimitEnable(true, 10);
    winch.configForwardSoftLimitEnable(true, 10);
  }

  /**
   * @param winchPercent Value from -1 to 1 for the winch speed
   */
  public void moveArm(double winchPercent) {
    currentWinchSpeed = winchPercent;
    winch.set(TalonSRXControlMode.PercentOutput, winchPercent);
  }

  public void zeroEncoder() {
    winch.setSelectedSensorPosition(0);
  }

  /**
   *
   * @return double: the current value of the arm encoder
   */
  public double getEncoder() {
    return winch.getSelectedSensorPosition();
  }
  public double getWinchSpeed() {
    return currentWinchSpeed;
  }

  /**
   *
   * @param index = index of the max to extend the arm to. 0 = default, smallest rotation 1 = bigger than 0
   */
  public void advanceArmLimit(int index) {
    if (currentLimitIndex < index) {
      currentLimitIndex = index;
    }

    winch.configReverseSoftLimitThreshold(armMax[1], 10);
  }
}
