package org.usfirst.frc.team670.robot.commands;

import org.usfirst.frc.team670.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command {

	private double startTime;
	private double period;
	private double amount;
	
    public Lift(double p, double a) {
        requires(Robot.elevator);
        period = p;
        amount = a;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.elevator.setMotor(amount);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis() - startTime) > period * 1000;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.elevator.setMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }

}
