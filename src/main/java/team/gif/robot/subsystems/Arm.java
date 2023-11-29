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

  private TalonSRX winch;
  private double encoder;
  private final double armMin = 0;
  private final double[] armMax = {0, 0, 0};
  private int currentLimitIndex = 0;
  private double currentWinchSpeed;

  public Arm() {
    winch = new TalonSRX(RobotMap.WINCH_MOTOR_ID);


    winch.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    encoder = winch.getSelectedSensorPosition();

    winch.configFactoryDefault();

    winch.setNeutralMode(NeutralMode.Brake);

    winch.setSelectedSensorPosition(0, 0, 10);
    winch.setSensorPhase(false);

    winch.configReverseSoftLimitThreshold(degreesToEncoder(armMin), 10); //TODO: Numbers here
    winch.configForwardSoftLimitThreshold(degreesToEncoder(armMax[0]), 10); //TODO: Numbers Here

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

  /**
   *
   * @return double: the current value of the arm encoder
   */
  public double getEncoder() {
    return encoder;
  }
  public double getWinchSpeed() {
    return currentWinchSpeed;
  }

  public double degreesToEncoder(double encoderValue) {
    return encoderValue;
    //TODO: MATH
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

    winch.configForwardSoftLimitThreshold((double) degreesToEncoder(armMax[1]), 10);
  }
}
