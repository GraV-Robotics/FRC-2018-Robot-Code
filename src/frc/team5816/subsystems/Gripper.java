package frc.team5816.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {

	private static final Gripper INSTANCE = new Gripper();

	private final VictorSP gripperMotor = new VictorSP(1);
	private final TalonSRX elevatorMotor = new TalonSRX(5);

	private Gripper(){

	}

	public static Gripper getInstance(){
		return INSTANCE;
	}


	public void setElevatorSpeed(double speed){
		this.elevatorMotor.set(ControlMode.PercentOutput, speed);
	}

	public void setGraspPressure(double value){
		this.gripperMotor.set(value);
	}

	public double getElevatorCurrent(){
		return this.elevatorMotor.getOutputCurrent();
	}


	public void initDefaultCommand() {

	}
}

