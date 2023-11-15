package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;

public class CollectorMotor extends CommandBase {

    public CollectorMotor() {
        super();
        addRequirements(Robot.collector);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double collect = Robot.oi.driver.getLeftTriggerAxis();
        double eject = Robot.oi.driver.getRightTriggerAxis();
        double speed = 0;
        if (collect> eject) {
            speed = collect;
        }
        if (eject> collect) {
            speed = eject;
        }
        Robot.collector.runCollector(speed);

    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
