package frc.team5816.subsystems;


import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Platform extends Subsystem {

	private final VictorSP victorSP = new VictorSP(0);

	private static final Platform INSTANCE = new Platform();

	public static Platform getInstance(){
		return INSTANCE;
	}

	private Platform(){
		
	}

	public void setPlatformSpeed(double speed){
		this.victorSP.set(speed);
	}

	public void initDefaultCommand() {
		// TODO: Set the default command, if any, for a subsystem here. Example:
		//    setDefaultCommand(new MySpecialCommand());
	}
}

