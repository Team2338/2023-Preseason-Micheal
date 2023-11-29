// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
    public static WPI_TalonSRX rightMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_ID);


    public static WPI_TalonSRX leftMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_ID);
    public static DifferentialDrive drive;

    /** Creates a new ExampleSubsystem. */
    public DriveTrain() {
        rightMotor.configFactoryDefault();
        rightMotor.setNeutralMode(NeutralMode.Brake);

        leftMotor.configFactoryDefault();
        leftMotor.setNeutralMode(NeutralMode.Brake);

        drive = new DifferentialDrive(leftMotor,rightMotor);
    }

    public void driveArcade(double speed, double rotation){
        drive.arcadeDrive(speed,rotation);

    }

    /**
     * Example command factory method.
     *
     * @return a command
     */
    public CommandBase exampleMethodCommand() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
                () -> {
                    /* one-time action goes here */
                });
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
