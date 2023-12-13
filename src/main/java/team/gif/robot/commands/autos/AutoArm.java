package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Robot;

public class AutoArm extends CommandBase {

    private double target = 10405;
    public AutoArm() {
        super();
       addRequirements(Robot.arm);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("auto arm");
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Robot.arm.moveArm(0.5);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return Robot.arm.getEncoder() > target;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

        System.out.println("end auto arm");
        Robot.arm.moveArm(0);
    }
}
