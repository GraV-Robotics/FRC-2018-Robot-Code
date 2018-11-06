package frc.team5816.subsystems;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class EndGame extends Subsystem {

	private final Solenoid endGameRelease = new Solenoid(9, 0);

	private static final EndGame INSTANCE = new EndGame();

	public static EndGame getInstance(){
		return INSTANCE;
	}

	private EndGame(){

	}

	public void release(boolean state){
		this.endGameRelease.set(state);
	}

	public void initDefaultCommand() {
		// TODO: Set the default command, if any, for a subsystem here. Example:
		//    setDefaultCommand(new MySpecialCommand());
	}
}

