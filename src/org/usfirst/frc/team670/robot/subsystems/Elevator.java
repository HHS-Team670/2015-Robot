package org.usfirst.frc.team670.robot.subsystems;

import org.usfirst.frc.team670.robot.commands.LiftWithJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
    
	//private CANJaguar liftMotor;
	
    public Elevator()
    {
    	//liftMotor = new CANJaguar(RobotMap.liftMotor);    
    }

    public void initDefaultCommand() 
    {
    	setDefaultCommand(new LiftWithJoystick());
    }
    
    public void setMotor(double val)
    {
    	//liftMotor.set(RobotMap.victor_linearize(val));
    }
    
    
}

