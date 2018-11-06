package frc.team5816.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5816.subsystems.Drive;
import frc.team5816.subsystems.Gripper;
import frc.team5816.subsystems.Platform;


public class Auto5050 extends Command {
	public Auto5050() {
		requires(Drive.getInstance());
		requires(Gripper.getInstance());
		requires(Platform.getInstance());
	}



	@Override
	protected void initialize() {
		Gripper.getInstance().setGraspPressure(1.0d);
		Drive.getInstance().drive(0.35d, 0.35d);
	}

	@Override
	protected void execute() {
//		if(DriverStation.getInstance().getGameSpecificMessage().substring(0, 1).equals("l") && this.timeSinceInitialized() > 10){
//			Gripper.getInstance().setGraspPressure(0);
//			Platform.getInstance().setPlatformSpeed(1);
//		}
	}

	@Override
	protected boolean isFinished() {
		return Drive.getInstance().getLeftDriveDistance() > 160;
	}


	@Override
	protected void end() {
		Drive.getInstance().drive(0.0d, 0.0d);
	}

	@Override
	protected void interrupted() {
		this.end();
	}
}
