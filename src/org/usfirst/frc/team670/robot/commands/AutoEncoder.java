package org.usfirst.frc.team670.robot.commands;

import org.usfirst.frc.team670.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class AutoEncoder extends Command {

	private double CM;
	private double Speed;
	 
    public AutoEncoder(double distanceinCM, double speedinSpeed) {
	        requires(Robot.driveTrain);
	        CM = distanceinCM;
	        Speed = speedinSpeed;
	    }
   
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.MoveDistanceCM(CM, Speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
