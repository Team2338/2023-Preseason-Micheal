package team.gif.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;

/**
 * Command to automatically drive arcade based on the drivers left joystick.
 */
public class DriveArcade extends CommandBase {

    public DriveArcade() {
        super();
        addRequirements(Robot.drivetrain);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double speed = Robot.oi.driver.getLeftY();
        double rot = Robot.oi.driver.getRightX();
        Robot.drivetrain.driveArcade(rot, speed);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
//        Robot.drivetrain.driveArcade(0,0);
    }
}
