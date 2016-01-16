package org.usfirst.frc.team670.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.CANJaguar;
=======
<<<<<<< HEAD
import edu.wpi.first.wpilibj.CANJaguar;
=======
>>>>>>> efca77516d69822d99c956645dc6f022d6152443
>>>>>>> cb2425b689a077942e4e6d2ef0be766e018e1a79
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team670.robot.Robot;
import org.usfirst.frc.team670.robot.RobotMap;
import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem 
{
	
<<<<<<< HEAD
	public CANJaguar leftTread;		//use these to access the right and left sides of the drivebase
	public CANJaguar rightTread;
	public CANJaguar middleTread;
	public Encoder enc;
=======
<<<<<<< HEAD
	public CANJaguar leftTread;		//use these to access the right and left sides of the drivebase
	public CANJaguar rightTread;
	public CANJaguar middleTread;
>>>>>>> cb2425b689a077942e4e6d2ef0be766e018e1a79
    
	public DriveTrain() 
	{
        leftTread = new CANJaguar(RobotMap.leftMotor);
        rightTread = new CANJaguar(RobotMap.rightMotor);
        middleTread = new CANJaguar(RobotMap.middleMotor);
<<<<<<< HEAD
        //0, and 1 are port numbers, false tells it to not inverse values
    	enc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
=======
=======
	public Jaguar leftTread;		//use these to access the right and left sides of the drivebase
	public Jaguar rightTread;
	public Jaguar middleTread;
    
	public DriveTrain() 
	{
        leftTread = new Jaguar(RobotMap.leftMotor);
        rightTread = new Jaguar(RobotMap.rightMotor);
        middleTread = new Jaguar(RobotMap.middleMotor);
>>>>>>> efca77516d69822d99c956645dc6f022d6152443
>>>>>>> cb2425b689a077942e4e6d2ef0be766e018e1a79
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
		leftTread.set(RobotMap.victor_linearize(left));
		rightTread.set(-RobotMap.victor_linearize(right));
		middleTread.set(RobotMap.victor_linearize(middle));
	}
	
<<<<<<< HEAD
	public void MoveDistanceCM(double cm){
		double speed = 10;
		double CircumfrenceInCm = 16;
		double degrees = enc.get();
		double DegPerCm = 360/CircumfrenceInCm; 
		double totaldegrees = cm*DegPerCm;
		
		if(degrees < totaldegrees){
			leftTread.set(speed);
			rightTread.set(speed);
		}
		else{
			leftTread.reset();
			rightTread.reset();
			}
		
		
	}
	
=======
>>>>>>> cb2425b689a077942e4e6d2ef0be766e018e1a79
}
