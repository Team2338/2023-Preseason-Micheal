// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Collector extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private TalonSRX collector;
  public Collector() {
    collector = new TalonSRX(RobotMap.COLLECTOR_ID);
    collector.configFactoryDefault();
    collector.setInverted(true);
  }

  public void runCollector(double speed) {

    collector.set(TalonSRXControlMode.PercentOutput, speed);
  }
}
