package org.usfirst.frc.team670.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MoveAndLift extends CommandGroup {
    
    public  MoveAndLift(double moveTime, double moveAmount, double moveAmountSide, double liftTime, double liftAmount, boolean sameTime, boolean liftFirst) {
        
    	if(sameTime)
    	{
    		addParallel(new Lift(liftTime, liftAmount));
    		addSequential(new Move(moveTime, moveAmount, moveAmountSide));
    	}
    	else
    	{
        	if(liftFirst)
        	{
        		addSequential(new Lift(liftTime, liftAmount));
        		addSequential(new Move(moveTime, moveAmount, moveAmountSide));
        	}
        	else
        	{
        		addSequential(new Move(moveTime, moveAmount, moveAmountSide));
        		addSequential(new Lift(liftTime, liftAmount));
        	}
    	}
    	
    	
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
