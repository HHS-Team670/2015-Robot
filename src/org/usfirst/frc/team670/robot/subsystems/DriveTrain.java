package org.usfirst.frc.team670.robot.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team670.robot.RobotMap;
import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;

public class DriveTrain extends Subsystem {
	public static final double gearRatio = 10.71;
	public static final double diameterInInches = 6;
	public static final double circumferenceInInches = diameterInInches * Math.PI;
	public CANJaguar leftTread1;
	public CANJaguar leftTread2;
	public CANJaguar rightTread1;
	public CANJaguar rightTread2;
	public CANJaguar middleTread;
    public Encoder encLeft;
    public Encoder encRight;
    
	public DriveTrain() 
	{
        leftTread1 = new CANJaguar(RobotMap.leftMotor1);
        rightTread1 = new CANJaguar(RobotMap.rightMotor1);
        leftTread2 = new CANJaguar(RobotMap.leftMotor2);
        rightTread2 = new CANJaguar(RobotMap.rightMotor2);
        middleTread = new CANJaguar(RobotMap.middleMotor);
    	encLeft = new Encoder(0, 1, true, EncodingType.k4X);
    	encRight = new Encoder(2, 3, true, EncodingType.k4X);
		//encLeft.reset();
		//encRight.reset();
	}
	/**
	 * When no other command is running let the operator drive around
	 * using the PS3 joystick.
	 */
	public void initDefaultCommand() 
	{
		setDefaultCommand(new DriveWithJoystick());
	}
	//MOTOR SETTERS---------------------------------------------------------
	
	public void drive(double left, double right, double middle) 
	{
		/*
		double speedLeft = encLeft.getRate();
		double speedRight = encRight.getRate();
		System.out.println("LeftSpeed: " + speedLeft + " | RightSpeed: " + speedRight );
		*/
		
		double leftCount = encLeft.get();
		double rightCount = encRight.get();
		System.out.println("Left Count: " + leftCount + " | Right Count: " + rightCount );
		
		leftTread1.setPercentMode();
		rightTread1.setPercentMode();
		leftTread2.setPercentMode();
		rightTread2.setPercentMode();
		leftTread1.enableControl();
		rightTread1.enableControl();
		leftTread2.enableControl();
		rightTread2.enableControl();
		
		leftTread1.set(left);
		leftTread2.set(left);
		rightTread1.set(right);
		rightTread2.set(right);
		middleTread.set(middle);
		
		//leftTread.set(RobotMap.victor_linearize(left));
		//rightTread.set(-RobotMap.victor_linearize(right));
		//middleTread.set(RobotMap.victor_linearize(middle));
	}
	
	public void MoveDistanceInches(double inches){
		
		double numRotations = inches/circumferenceInInches;

		encLeft.reset();
		encRight.reset();
		//(int)(gearRatio*360)
		leftTread1.setPositionMode(CANJaguar.kQuadEncoder, 360, 25, .5, 0);
		rightTread1.setPositionMode(CANJaguar.kQuadEncoder, 360, 25, .5, 0);
	 	leftTread2.setPositionMode(CANJaguar.kQuadEncoder, 360, 25, .5, 0);
		rightTread2.setPositionMode(CANJaguar.kQuadEncoder, 360, 25, .5, 0);
		leftTread1.enableControl();
		rightTread1.enableControl();
		leftTread2.enableControl();
		rightTread2.enableControl();
		
		leftTread1.set(3);
		leftTread2.set(3);
		rightTread1.set(3);
		rightTread2.set(3);
		/*
		double leftCount = encLeft.get();
		double rightCount = encRight.get();
		System.out.println("Left Count: " + leftCount + " | Right Count: " + rightCount );
		*/
		/*
		double DegPerCm = 360/circumfrenceInCm; 
		double totaldegrees = gearRatio*(cm*DegPerCm);
		
		System.out.println("DegreesLeft: " + degreesLeft + " | DegreesRight: " + degreesRight );
		
		if(degreesLeft < totaldegrees && degreesRight < totaldegrees){
			
			rightTread.set(speed);
			leftTread.set(speed);
		}
		else{
			leftTread.stopMotor();
			rightTread.stopMotor();
			}*/	
	}
	
	public void setSpeed(double rotPerSec){
		//CONVERT TO ACTUAL SPEED
		//(int)(gearRatio*360)
		leftTread1.setSpeedMode(CANJaguar.kQuadEncoder, (int)(gearRatio*360), 0, 0, 0);
		rightTread1.setSpeedMode(CANJaguar.kQuadEncoder, (int)(gearRatio*360), 0, 0, 0);
		leftTread2.setSpeedMode(CANJaguar.kQuadEncoder, (int)(gearRatio*360), 0, 0, 0);
		rightTread2.setSpeedMode(CANJaguar.kQuadEncoder, (int)(gearRatio*360), 0, 0, 0);
		leftTread1.enableControl();
		rightTread1.enableControl();
		leftTread2.enableControl();
		rightTread2.enableControl();
	}
	
}
