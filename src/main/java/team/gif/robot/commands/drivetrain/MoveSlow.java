package team.gif.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;


public class MoveSlow extends CommandBase {

    private double moveDirection;

    /**
     *
     * @param direction 1 - forward 2 - rotate right 3 - backward 4 - rotate left
     */
    public MoveSlow(int direction) {
        super();
        addRequirements(Robot.drivetrain);
        moveDirection = direction;
        //addRequirements(Robot.climber); // uncomment
    }



    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double speed = 0.1; //10% power
        double rotation = 0;

        if (moveDirection == 1) {
            // Direction Rotate Right
            rotation = 0.1;
        } else if (moveDirection == 2) {
            //Direction Backwards
            speed = -0.1;
        } else if (moveDirection == 3) {
            //Direction Rotate Left
            rotation = -0.1;
        }

        Robot.drivetrain.driveArcade(speed, rotation);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.drivetrain.driveArcade(0, 0);
    }
}
