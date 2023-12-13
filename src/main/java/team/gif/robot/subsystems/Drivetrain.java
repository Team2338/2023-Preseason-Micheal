// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Drivetrain extends SubsystemBase {
  private DifferentialDrive drive;
  private WPI_TalonSRX rMotor;
  private WPI_TalonSRX lMotor;
  public Drivetrain() {
    lMotor = new WPI_TalonSRX(RobotMap.LEFT_MOTOR_ID);
    rMotor = new WPI_TalonSRX(RobotMap.RIGHT_MOTOR_ID);
    lMotor.configFactoryDefault();
    rMotor.configFactoryDefault();
    lMotor.setNeutralMode(NeutralMode.Brake);
    rMotor.setNeutralMode(NeutralMode.Brake);

    drive = new DifferentialDrive(lMotor, rMotor);
    drive.setDeadband(0.05);
  }

  /**
   * @param rot Turn angle
   * @param spd Robot speed
   */
  public void driveArcade(double rot, double spd) {
    drive.arcadeDrive(spd, rot);
  }



}
