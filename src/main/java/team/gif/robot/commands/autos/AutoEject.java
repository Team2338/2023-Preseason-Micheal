package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;

public class AutoEject extends CommandBase {

    public AutoEject() {
        super();
        addRequirements(Robot.collector);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {

        System.out.println("ejecting");
        Robot.collector.runCollector(-0.5);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        //TODO: Set seconds
        return (Timer.getMatchTime()) < 10;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

        System.out.println("done eject");
        Robot.collector.runCollector(0);
    }
}


