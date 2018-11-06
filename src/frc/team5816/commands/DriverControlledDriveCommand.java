package frc.team5816.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team5816.Robot;
import frc.team5816.subsystems.Drive;


public class DriverControlledDriveCommand extends Command {
	public DriverControlledDriveCommand() {
		requires(Drive.getInstance());
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Drive.getInstance().setBreaking(true);
		Drive.getInstance().drive(this.getStraightInput() + this.getTurningInput(), this.getStraightInput() - this.getTurningInput());
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

	private double getStraightInput(){
		return -Robot.getInstance().getControllerA().getRawAxis(1);
	}

	private double getTurningInput(){
		return Robot.getInstance().getControllerA().getRawAxis(4) * 0.75;
	}
}
