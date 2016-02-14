package org.usfirst.frc.team670.robot.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team670.robot.RobotMap;

public class DriveTrain extends Subsystem {
	public static final double gearRatio = 10.71;
	public static final double diameterInInches = 6;
	public static final double circumferenceInInches = diameterInInches * Math.PI;
	public static final double inchesPerTick = circumferenceInInches/360;
	public CANTalon leftTread1;
	public CANTalon leftTread2;
	//public CANJaguar rightTread1;
	//public CANJaguar rightTread2;
	//public CANJaguar middleTread;
    //public Encoder encLeft;
    //public Encoder encRight;
    
	public DriveTrain() 
	{
        leftTread1 = new CANTalon(RobotMap.leftMotor1);
        //rightTread1 = new CANJaguar(RobotMap.rightMotor1);
        leftTread2 = new CANTalon(RobotMap.leftMotor2);
        //rightTread2 = new CANJaguar(RobotMap.rightMotor2);
        //middleTread = new CANJaguar(RobotMap.middleMotor);
    	//encLeft = new Encoder(0, 1, true, EncodingType.k4X);
    	//encRight = new Encoder(2, 3, true, EncodingType.k4X);
		//encLeft.reset();
		//encRight.reset();
        //leftTread1.changeControlMode(TalonControlMode.Position);
        leftTread2.changeControlMode(CANTalon.TalonControlMode.Follower);
        leftTread2.set(RobotMap.leftMotor1);
	}
	/**
	 * When no other command is running let the operator drive around
	 * using the PS3 joystick.
	 */
	public void initDefaultCommand() 
	{
		//setDefaultCommand(new DriveWithJoystick());
	}
	//MOTOR SETTERS---------------------------------------------------------
	
	public void drive(double left, double right, double middle) {	
		/*
		leftTread1.setPercentMode();
		rightTread1.setPercentMode();
		leftTread2.setPercentMode();
		rightTread2.setPercentMode();
		leftTread1.enableControl();
		rightTread1.enableControl();
		leftTread2.enableControl();
		rightTread2.enableControl();
		
		leftTread1.set(RobotMap.victor_linearize(left));
		leftTread2.set(RobotMap.victor_linearize(left));
		rightTread1.set(-RobotMap.victor_linearize(right));
		rightTread2.set(-RobotMap.victor_linearize(right));
		middleTread.set(RobotMap.victor_linearize(middle));
		*/
	}
	
	public void MoveDistanceInches(double inches){
		double numTicks = inches/inchesPerTick;
		
		leftTread1.setEncPosition(0);
		leftTread1.changeControlMode(CANTalon.TalonControlMode.Position);
		leftTread1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftTread1.reverseSensor(true);
		//leftTread1.configEncoderCodesPerRev(360);
		leftTread1.setF(0.25);
		leftTread1.setPID(0.3, 0, 0);
		leftTread1.setCloseLoopRampRate(0);
		leftTread1.setIZone(0);
		leftTread1.set(1);
		System.out.println(leftTread1.getControlMode());
		//leftTread1.set(numTicks);
	}
}
