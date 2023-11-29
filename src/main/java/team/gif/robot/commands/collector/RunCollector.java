package team.gif.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;

public class RunCollector extends CommandBase {

    public RunCollector() {
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
        //TODO: This needs to be tuned
        double eject = Robot.oi.aux.getLeftTriggerAxis();
        double collect = Robot.oi.driver.getLeftTriggerAxis();
        double speed;
        /*
        This is how we will be determining which direction to run.
        If eject is greater that collect we run that, otherwise its always
        collect.
        */
        if (Math.abs(eject) > Math.abs(collect)) {
            speed = eject;
        } else if (Math.abs(collect) > Math.abs(eject)) {
            speed = collect;
        } else {
            speed = collect;
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
    public void end(boolean interrupted) {
        Robot.collector.runCollector(0);
    }
}

