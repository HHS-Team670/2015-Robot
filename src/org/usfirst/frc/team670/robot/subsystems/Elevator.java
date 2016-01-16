package org.usfirst.frc.team670.robot.subsystems;

import org.usfirst.frc.team670.robot.Robot;
import org.usfirst.frc.team670.robot.RobotMap;
import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team670.robot.commands.LiftWithJoystick;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
    
	private Jaguar liftMotor;
	
    public Elevator()
    {
    	liftMotor = new Jaguar(RobotMap.liftMotor);    
    }

    public void initDefaultCommand() 
    {
    	setDefaultCommand(new LiftWithJoystick());
    }
    
    public void setMotor(double val)
    {
    	liftMotor.set(RobotMap.victor_linearize(val));
    }
    
    
}

