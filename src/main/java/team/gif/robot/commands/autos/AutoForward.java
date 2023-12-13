package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;

public class AutoForward extends CommandBase {

    public AutoForward() {
        super();
        addRequirements(Robot.drivetrain);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

        System.out.println("runnging drivetrain");
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.drivetrain.driveArcade(-0.8, -0.1); //TODO: keep straight using pigeon
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        //TODO: Stop after X seconds
        return (Timer.getMatchTime()) < 13.3; //Two seconds
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

        System.out.println("drivetrain done");
        Robot.drivetrain.driveArcade(0, 0);
    }
}
