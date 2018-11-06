package frc.team5816.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team5816.Robot;
import frc.team5816.subsystems.Gripper;


public class DriverControlledGripperCommand extends Command {

	DigitalInput elevatorLimit = new DigitalInput(4);

	public DriverControlledGripperCommand() {

	}

	@Override
	protected void initialize() {

	}


	@Override
	protected void execute() {
		System.out.println(this.elevatorLimit.get());
		Gripper.getInstance().setElevatorSpeed(this.elevatorLimit.get() ? this.getElevatorInput() : -0.15);
		Gripper.getInstance().setGraspPressure(this.getGripperInput() ? 1.0d : -0.005d);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Gripper.getInstance().setElevatorSpeed(0);
		Gripper.getInstance().setGraspPressure(0.0d);
	}

	@Override
	protected void interrupted() {
		this.end();
	}

	public boolean getGripperInput(){
		return Robot.getInstance().getControllerB().getRawButton(1);
	}

	public double getElevatorInput(){
		return -Robot.getInstance().getControllerB().getRawAxis(5);
	}
}
