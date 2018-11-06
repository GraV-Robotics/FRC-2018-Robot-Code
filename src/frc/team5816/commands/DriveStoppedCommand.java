package frc.team5816.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5816.subsystems.Drive;


public class DriveStoppedCommand extends Command {
	public DriveStoppedCommand() {
		this.setRunWhenDisabled(true);
		this.requires(Drive.getInstance());
	}

	@Override
	protected void initialize() {

	}


	@Override
	protected void execute() {
		Drive.getInstance().drive(0,0);
		Drive.getInstance().setBreaking(false);
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
		super.interrupted();
	}
}
