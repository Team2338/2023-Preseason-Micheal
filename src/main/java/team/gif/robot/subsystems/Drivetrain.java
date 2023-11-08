// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Drivetrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private static WPI_TalonSRX lMotor;
  private static WPI_TalonSRX rMotor;
  private DifferentialDrive drive;
  public Drivetrain() {
    lMotor = new WPI_TalonSRX(RobotMap.LEFT_MOTOR_ID);
    rMotor = new WPI_TalonSRX(RobotMap.RIGHT_MOTOR_ID);

    drive = new DifferentialDrive(lMotor, rMotor);
  }

  public void driveArcade(double pos, double rot) {
    drive.arcadeDrive(pos, rot);
  }



}
