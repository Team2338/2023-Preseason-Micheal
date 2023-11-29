package team.gif.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;

public class MoveArm extends CommandBase {

    public MoveArm() {
        super();
        addRequirements(Robot.arm);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        //TODO: This needs values
        double commandSpeed = Robot.oi.aux.getRightY();
        double winchSpeed = commandSpeed;

        double armAngle = Robot.arm.getEncoder();
        double[] angles = Robot.arm.getCurrentLimits();
        if (armAngle < angles[0]) {
            if (commandSpeed < 0) {
                winchSpeed = 0;
            }
        } else if (armAngle > angles[1]) {
            if (commandSpeed > 0) {
                winchSpeed = 0;
            }
        }



        Robot.arm.moveArm(winchSpeed);
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
