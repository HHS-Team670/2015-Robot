package org.usfirst.frc.team670.robot.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team670.robot.RobotMap;
import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;

public class DriveTrain extends Subsystem {
	public final double gearRatio; 
	public CANJaguar leftTread;		//use these to access the right and left sides of the drivebase
	public CANJaguar rightTread;
	public CANJaguar middleTread;
    public Encoder encLeft;
    public Encoder encRight;
    
	public DriveTrain() 
	{
        leftTread = new CANJaguar(RobotMap.leftMotor);
        rightTread = new CANJaguar(RobotMap.rightMotor);
        middleTread = new CANJaguar(RobotMap.middleMotor);
        gearRatio = 10.71;
    	encLeft = new Encoder(0, 1);
    	encRight = new Encoder(2, 3);
		encLeft.reset();
		encRight.reset();
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
		double degreesLeft = encLeft.getRate();
		double degreesRight = encRight.getRate();
		System.out.println("DegreesLeft: " + degreesLeft + " | DegreesRight: " + degreesRight );
		leftTread.set(RobotMap.victor_linearize(left));
		rightTread.set(-RobotMap.victor_linearize(right));
		middleTread.set(RobotMap.victor_linearize(middle));
	}
	
	@SuppressWarnings("deprecation")
	public void MoveDistanceCM(double cm, double speed){

		
		double CircumfrenceInCm = 16;
		double degreesLeft = encLeft.getRate();
		double degreesRight = encRight.getRate();
		double DegPerCm = 360/CircumfrenceInCm; 
		double totaldegrees = gearRatio*(cm*DegPerCm);
	
		System.out.println("DegreesLeft: " + degreesLeft + " | DegreesRight: " + degreesRight );
		
		if(degreesLeft < totaldegrees && degreesRight < totaldegrees){
			
			rightTread.set(speed);
			leftTread.set(speed);
		}
		else{
			leftTread.stopMotor();
			rightTread.stopMotor();
			}
		
		
	}
	
}
