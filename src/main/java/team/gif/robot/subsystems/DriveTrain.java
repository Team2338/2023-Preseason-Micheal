// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private WPI_TalonSRX LeftCIM = new WPI_TalonSRX(RobotMap.LEFT_CIM);
  private  WPI_TalonSRX RightCIM = new WPI_TalonSRX(RobotMap.Right_CIM);

  private DifferentialDrive drive = new DifferentialDrive(LeftCIM, RightCIM);
  public DriveTrain() {
    LeftCIM.configFactoryDefault();
    RightCIM.configFactoryDefault();
  }

  public void driveArcade(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }
}
