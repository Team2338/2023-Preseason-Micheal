// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Arm extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public TalonSRX arm = new TalonSRX(RobotMap.WINCH_ID);
  private double encoder;
  private double min = 0;
  private double max1 = 0;
  private double max2 = 0;
  private double curmax = max1;
  public Arm() {
    arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    encoder = arm.getSelectedSensorPosition();
    arm.configFactoryDefault();
  }

  public void changeMax(){
    curmax = max2;
  }
  public void moveArm(double winchSpeed){
    if (min > encoder) {
    if(winchSpeed < 0) {
      winchSpeed = 0;
    }
    } else if (curmax < encoder) {
      if(winchSpeed > 0) {
      winchSpeed = 0;
      }
    }

  arm.set(ControlMode.PercentOutput, winchSpeed);

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
