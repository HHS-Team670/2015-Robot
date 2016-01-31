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
		//setDefaultCommand(new DriveWithJoystick());
	}
	//MOTOR SETTERS---------------------------------------------------------
	
	public void drive(double left, double right, double middle) {	
		
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
	}
	
	public void MoveDistanceInches(double inches){
		
		double numRotations = inches/circumferenceInInches;

		encLeft.reset();
		encRight.reset();
		
		leftTread1.setPositionMode(CANJaguar.kQuadEncoder, 360, 25, .5, 0);
		rightTread1.setPositionMode(CANJaguar.kQuadEncoder, 360, 25, .5, 0);
	 	leftTread2.setPositionMode(CANJaguar.kQuadEncoder, 360, 25, .5, 0);
		rightTread2.setPositionMode(CANJaguar.kQuadEncoder, 360, 25, .5, 0);
		
		leftTread1.enableControl();
		rightTread1.enableControl();
		leftTread2.enableControl();
		rightTread2.enableControl();
		
		leftTread1.set(numRotations);
		leftTread2.set(numRotations);
		rightTread1.set(numRotations);
		rightTread2.set(numRotations);
	}
}
