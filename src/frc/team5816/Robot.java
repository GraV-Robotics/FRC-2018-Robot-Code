
package frc.team5816;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team5816.commands.*;
import frc.team5816.subsystems.Drive;
import frc.team5816.subsystems.Gripper;
import frc.team5816.triggers.EndGameReleaseTrigger;


public class Robot extends TimedRobot
{

    public static final double ROBOT_PERIOD = 0.01d;

    private final Joystick controllerA = new Joystick(0);
    private final Joystick controllerB = new Joystick(1);

    private static Robot instance;

    private static long teleopStartTime;

    public static Robot getInstance(){
        return instance;
    }


    @Override
    public void robotInit() {
        instance = this;
        setPeriod(ROBOT_PERIOD);
        teleopStartTime = -1;
        CameraServer.getInstance().startAutomaticCapture();

        //todo add current limits (CIM: 22.5A, mini-CIM: 15A)
    }

    @Override
    public void robotPeriodic() {
//        System.out.println(Gripper.getInstance().getElevatorCurrent());
    }

    @Override
    public void disabledInit() {
        
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }


    @Override
    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().add(new Auto5050());
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().add(new DriverControlledDriveCommand());
        Scheduler.getInstance().add(new DriverControlledGripperCommand());
        Scheduler.getInstance().add(new DriverControlledPlatformCommand());
        new EndGameReleaseTrigger().whenActive(new DriverControlledReleaseCommand());

        teleopStartTime = System.currentTimeMillis();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testInit(){

    }

    @Override
    public void testPeriodic() {
        Scheduler.getInstance().run();
    }

    public Joystick getControllerA(){
        return this.controllerA;
    }

    public Joystick getControllerB(){
        return this.controllerB;
    }

    public long getRemainingTeleopTime(){
        return teleopStartTime > -1 ? 135000L - (System.currentTimeMillis() - teleopStartTime) : 135000L;

    }
}
