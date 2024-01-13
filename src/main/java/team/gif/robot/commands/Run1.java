package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;

public class Run1 extends CommandBase {

    public Run1() {
        super();
        addRequirements(Robot.motors);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.motors.run1(Robot.ui.motor1.getDouble(1.0));
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.motors.run1(0);
    }
}
