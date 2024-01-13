// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Motors extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private TalonSRX collector;
  private TalonSRX motor1;
  private TalonSRX motor2;
  private CANSparkMax motor3;
  public Motors() {
    collector = new TalonSRX(RobotMap.COLLECTOR_ID);
    collector.configFactoryDefault();
    collector.setInverted(true);

    motor1 = new TalonSRX(9);
    motor2 = new TalonSRX(6);
    motor3 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  }

  public void runCollector(double speed) {

    collector.set(TalonSRXControlMode.PercentOutput, speed);
  }

  public void run1(double speed) {
    motor1.set(TalonSRXControlMode.PercentOutput, speed);
  }

  public void run2(double speed) {
    motor2.set(TalonSRXControlMode.PercentOutput, speed);
  }

  public void run3(double speed) {
    motor3.set(speed);
  }
}
