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
    collector.setInverted(true);
    //collector.configFactoryDefault();
  }

  public void runCollector(double speed) {

//    System.out.println("good one" + speed);
    collector.set(TalonSRXControlMode.PercentOutput, speed);
  }
}
