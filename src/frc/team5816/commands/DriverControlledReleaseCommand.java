package frc.team5816.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5816.subsystems.EndGame;
import frc.team5816.subsystems.Gripper;


public class DriverControlledReleaseCommand extends Command {
	public DriverControlledReleaseCommand() {
		requires(Gripper.getInstance());
		requires(EndGame.getInstance());
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		EndGame.getInstance().release(true);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {
		this.end();
	}
}
