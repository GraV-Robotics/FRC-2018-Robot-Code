
package frc.team5816.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team5816.commands.DriveStoppedCommand;


public class Drive extends Subsystem
{
    private static final Drive INSTANCE = new Drive();

    private static final int ENCODER_AVERAGE_PERIOD = 63;
    private static final double WHEEL_DIAMETER = 6.0d;

    private final TalonSRX leftDriveMotorMaster = new TalonSRX(1);
    private final TalonSRX leftDriveMotorFollowerA = new TalonSRX(2);
    private final TalonSRX leftDriveMotorFollowerB = new TalonSRX(3);
    private final TalonSRX rightDriveMotorMaster = new TalonSRX(6);
    private final TalonSRX rightDriveMotorFollowerA = new TalonSRX(7);
    private final TalonSRX rightDriveMotorFollowerB = new TalonSRX(8);

    private final Encoder leftDriveEncoder = new Encoder(0,1);
    private final Encoder rightDriveEncoder = new Encoder(2, 3);
    private final ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    private Drive(){
        this.leftDriveMotorFollowerA.set(ControlMode.Follower, leftDriveMotorMaster.getDeviceID());
        this.leftDriveMotorFollowerB.set(ControlMode.Follower, leftDriveMotorMaster.getDeviceID());
        this.rightDriveMotorFollowerA.set(ControlMode.Follower, rightDriveMotorMaster.getDeviceID());
        this.rightDriveMotorFollowerB.set(ControlMode.Follower, rightDriveMotorMaster.getDeviceID());

        this.leftDriveMotorMaster.setInverted(false);
        this.leftDriveMotorFollowerA.setInverted(false);
        this.leftDriveMotorFollowerB.setInverted(false);
        this.rightDriveMotorMaster.setInverted(true);
        this.rightDriveMotorFollowerA.setInverted(true);
        this.rightDriveMotorFollowerB.setInverted(true);

        this.leftDriveMotorMaster.enableVoltageCompensation(true);
        this.leftDriveMotorFollowerA.enableVoltageCompensation(true);
        this.leftDriveMotorFollowerB.enableVoltageCompensation(true);
        this.rightDriveMotorMaster.enableVoltageCompensation(true);
        this.rightDriveMotorFollowerA.enableVoltageCompensation(true);
        this.rightDriveMotorFollowerB.enableVoltageCompensation(true);


        this.leftDriveEncoder.setSamplesToAverage(ENCODER_AVERAGE_PERIOD);
        this.rightDriveEncoder.setSamplesToAverage(ENCODER_AVERAGE_PERIOD);
        this.leftDriveEncoder.setDistancePerPulse(WHEEL_DIAMETER * (Math.PI/360.0d));
        this.rightDriveEncoder.setDistancePerPulse(WHEEL_DIAMETER * (Math.PI/360.0d));
        this.leftDriveEncoder.setReverseDirection(true);
        this.rightDriveEncoder.setReverseDirection(false);
    }

    public static Drive getInstance(){
        return INSTANCE;
    }

    public void drive(double left, double right){
        this.drive(ControlMode.PercentOutput, left, right);
    }

    public void drive(ControlMode controlMode, double left, double right){
        this.leftDriveMotorMaster.set(controlMode, left);
        this.rightDriveMotorMaster.set(controlMode, right);
    }

    public void setBreaking(boolean state){
        this.leftDriveMotorMaster.setNeutralMode(state ? NeutralMode.Brake : NeutralMode.Coast);
        this.leftDriveMotorFollowerA.setNeutralMode(state ? NeutralMode.Brake : NeutralMode.Coast);
        this.leftDriveMotorFollowerB.setNeutralMode(state ? NeutralMode.Brake : NeutralMode.Coast);
        this.rightDriveMotorMaster.setNeutralMode(state ? NeutralMode.Brake : NeutralMode.Coast);
        this.rightDriveMotorFollowerA.setNeutralMode(state ? NeutralMode.Brake : NeutralMode.Coast);
        this.rightDriveMotorFollowerB.setNeutralMode(state ? NeutralMode.Brake : NeutralMode.Coast);
    }

    public double getLeftDriveDistance(){
        return this.leftDriveEncoder.getDistance();
    }

    public double getRightDriveDistance(){
        return this.rightDriveEncoder.getDistance();
    }

    public double getLeftDriveRate(){
        return this.leftDriveEncoder.getRate();
    }

    public double getRightDriveRate(){
        return this.rightDriveEncoder.getRate();
    }

    public double getAngel(){
        return this.gyro.getAngle();
    }

    public double getAngularRate(){
        return this.gyro.getRate();
    }


    public void initDefaultCommand() 
    {
        setDefaultCommand(new DriveStoppedCommand());
    }
}
