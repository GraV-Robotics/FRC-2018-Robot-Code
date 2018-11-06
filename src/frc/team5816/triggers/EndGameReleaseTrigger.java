package frc.team5816.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.team5816.Robot;


public class EndGameReleaseTrigger extends Trigger {

	public boolean get() {
		return (Robot.getInstance().getControllerB().getRawButton(4) && Robot.getInstance().getRemainingTeleopTime() < 30000) || (Robot.getInstance().getControllerB().getRawButton(4) && Robot.getInstance().getControllerB().getRawButton(3));
	}
}
