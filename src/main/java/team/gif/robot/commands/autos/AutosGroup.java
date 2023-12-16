package team.gif.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import team.gif.robot.commands.AutoRotate;
import team.gif.robot.commands.AutoTurnBack;


public class AutosGroup extends SequentialCommandGroup {
    public AutosGroup () {
        addCommands(
                new ParallelCommandGroup(new AutoForward())
//                new AutoRotate(),
//                new AutoEject(),
//                new AutoTurnBack(),
//                new AutoDriveBack()
        );
    }
}
