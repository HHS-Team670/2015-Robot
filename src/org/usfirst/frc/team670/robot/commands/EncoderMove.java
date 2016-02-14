package org.usfirst.frc.team670.robot.commands;

import org.usfirst.frc.team670.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderMove extends Command {

	private double distance;
	 
    public EncoderMove(double distance) {
	        requires(Robot.driveTrain);
	        this.distance = distance;
	    }
   
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.MoveDistanceInches(distance);
    	System.out.println("Execute");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("End");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
