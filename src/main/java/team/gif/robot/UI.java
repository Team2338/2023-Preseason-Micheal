package team.gif.robot;

/**
 *   Initialize the shuffleboard here.
 *   Shuffleboard is a modern looking driveteam focused dashboard. It displays network
 *    tables data using a variety of widgets that can be positioned and controlled with robot code.
 *   Helpful link: https://docs.wpilib.org/en/stable/docs/software/dashboards/shuffleboard/index.html

 *   Use the variable(shuffleboardTab) to add it to your shuffleboard.
 *   Example: shuffleboardTab.addBoolean("title of widget", Robot.arm::getPos());
 *   There is many more functions that you can use, example addString, addNumber, etc.
 */

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import java.util.Map;

public class UI {
    public GenericEntry motor1;
    public GenericEntry motor2;
    public GenericEntry motor3;

    public UI() {
        ShuffleboardTab shuffleboardTab = Shuffleboard.getTab("TEAM DOMINIC");

        motor1 = shuffleboardTab.add("Motor 1", .5)
                .withWidget(BuiltInWidgets.kNumberSlider)
                .withProperties(Map.of("min", 0, "max", 1))
                        .getEntry();
        motor2 = shuffleboardTab.add("Motor 2", .5)
                .withWidget(BuiltInWidgets.kNumberSlider)
                .withProperties(Map.of("min", 0, "max", 1))
                .getEntry();
        motor3 = shuffleboardTab.add("Motor 3", .5)
                .withWidget(BuiltInWidgets.kNumberSlider)
                .withProperties(Map.of("min", 0, "max", 1))
                .getEntry();

    }
}
