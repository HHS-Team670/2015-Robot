package org.usfirst.frc.team670.robot.commands;

import org.usfirst.frc.team670.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Move extends Command {
	
	private double startTime;
	private double period;
	private double amount;
	private double amountSide;
	
    public Move(double p, double a, double as) {
        requires(Robot.driveTrain);
        period = p;
        amount = a;
        amountSide = as;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.driveTrain.drive(amount, amount, amountSide);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis() - startTime) > period * 1000;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.driveTrain.drive(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
