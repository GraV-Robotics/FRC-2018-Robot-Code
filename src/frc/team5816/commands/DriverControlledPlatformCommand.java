package frc.team5816.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5816.Robot;
import frc.team5816.subsystems.Platform;


public class DriverControlledPlatformCommand extends Command {
	public DriverControlledPlatformCommand() {
		requires(Platform.getInstance());
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Platform.getInstance().setPlatformSpeed(getPlatformRaiseButton() ? 1.0d : 0.005d);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Platform.getInstance().setPlatformSpeed(0.0d);
	}

	@Override
	protected void interrupted() {
		this.end();
	}

	public boolean getPlatformRaiseButton(){
		return Robot.getInstance().getControllerB().getRawButton(3);
	}




}
