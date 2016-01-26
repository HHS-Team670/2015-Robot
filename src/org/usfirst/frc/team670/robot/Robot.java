
package org.usfirst.frc.team670.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SampleRobot;

import org.usfirst.frc.team670.robot.commands.AutoNothing;
import org.usfirst.frc.team670.robot.commands.Lift;
import org.usfirst.frc.team670.robot.commands.Move;
import org.usfirst.frc.team670.robot.commands.MoveAndLift;
import org.usfirst.frc.team670.robot.subsystems.DriveTrain;
import org.usfirst.frc.team670.robot.subsystems.Elevator;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;




/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	CameraServer server;
	int session;
    Image frame;
	
	Command autoCommand;
    SendableChooser autoChooser;
    
    public static OI oi;
    public static DriveTrain driveTrain;
    public static Elevator elevator;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
    	driveTrain = new DriveTrain();
		elevator = new Elevator();
		oi = new OI();
		
		SmartDashboard.putData(Scheduler.getInstance());
	    SmartDashboard.putData(driveTrain);
	    SmartDashboard.putData(elevator);
	    
	    autoChooser = new SendableChooser();
	    autoChooser.addDefault("Nothing", new AutoNothing());
	    autoChooser.addObject("Move Forward", new Move(1, 0.75, 0));
	    autoChooser.addObject("Lift Elevator", new Lift(1, 1));
	    autoChooser.addObject("Move up elevator and move back A LOT", new MoveAndLift(2.8, -0.8, 0, 1, 1, false, true));
	    autoChooser.addObject("Move up elevator and move back A LOT AND GO TO LEFT", new MoveAndLift(2.8, -0.8, -0.75, 1, 1, false, true));
	    autoChooser.addObject("Move up elevator and move back A LOT AND GO TO RIGHT", new MoveAndLift(2.8, -0.8, 0.75, 1, 1, false, true));
	    autoChooser.addObject("Move up elevator and move back a tiny bit bruh", new MoveAndLift(0.5, -0.75, 0, 1, 1, false, true));
	    SmartDashboard.putData("Autonomous Command Chooser", autoChooser);
	    
        //autoCommand = new AutoCommand();
	    
	    frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	    // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera("cam0",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
    }
   
    /** 
     * Copied from the IntermediateVision example.
     */
    public void operatorControl() {
    	NIVision.IMAQdxStartAcquisition(session);

        /**
         * grab an image, draw the circle, and provide it for the camera server
         * which will in turn send it to the dashboard.
         */
        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);

        while (isOperatorControl() && isEnabled()) {

            NIVision.IMAQdxGrab(session, frame, 1);
            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
            
            CameraServer.getInstance().setImage(frame);

            /** robot code here! **/
            Timer.delay(0.005);		// wait for a motor update time
        }
        NIVision.IMAQdxStopAcquisition(session);
    }

    public void autonomousInit() 
    {
        autoCommand = (Command) autoChooser.getSelected();
        autoCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	
        if (autoCommand != null) 
        	autoCommand.cancel();
    	
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit()
    {
    	
    }
    
    public void disabledPeriodic() 
	{
    	
	}
    
    public void testInit()
    {
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
