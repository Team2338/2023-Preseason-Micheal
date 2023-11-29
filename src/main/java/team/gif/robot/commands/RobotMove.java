package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;
import team.gif.robot.OI;

public class RobotMove extends CommandBase {

    public RobotMove() {
        super();
        addRequirements(Robot.driveTrain);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        double xPosition = Robot.oi.driver.getLeftX();
        double yPosition = Robot.oi.driver.getLeftY();
        Robot.driveTrain.driveArcade(yPosition,xPosition);
    }



    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
