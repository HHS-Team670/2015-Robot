package org.usfirst.frc.team670.robot.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team670.robot.RobotMap;
import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;

public class DriveTrain extends Subsystem 
{
	public CANJaguar leftTread;		//use these to access the right and left sides of the drivebase
	public CANJaguar rightTread;
	public CANJaguar middleTread;
    
	public DriveTrain() 
	{
        leftTread = new CANJaguar(RobotMap.leftMotor);
        rightTread = new CANJaguar(RobotMap.rightMotor);
        middleTread = new CANJaguar(RobotMap.middleMotor);
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
	
}
