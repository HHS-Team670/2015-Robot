package org.usfirst.frc.team670.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static int leftMotor1 = 2;
    public static int leftMotor2 = 3;
    public static int rightMotor1 = 4;
    public static int rightMotor2 = 5;
    public static int middleMotor = 6;
    public static int liftMotor = 1;
    
    public static int leftDriveStick = 1;
    public static int rightDriveStick = 2;
    public static int operatorStick = 0;
    public static int arcButtons = 4;
	
	// For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
    
    public static double victor_linearize(double goal_speed)
    {
			final double deadband_value = 0.082;
			
			if (goal_speed > deadband_value)
				goal_speed -= deadband_value;
			else if (goal_speed < -deadband_value)
				goal_speed += deadband_value;
			else
				goal_speed = 0.0;
			goal_speed = goal_speed / (1.0 - deadband_value);

			double goal_speed2 = goal_speed * goal_speed;
			double goal_speed3 = goal_speed2 * goal_speed;
			double goal_speed4 = goal_speed3 * goal_speed;
			double goal_speed5 = goal_speed4 * goal_speed;
			double goal_speed6 = goal_speed5 * goal_speed;
			double goal_speed7 = goal_speed6 * goal_speed;

			// Original untweaked one.
			//double victor_fit_c		= -1.6429;
			//double victor_fit_d		= 4.58861e-08;
			//double victor_fit_e		= 0.547087;
			//double victor_fit_f		= -1.19447e-08;

			// Constants for the 5th order polynomial
			double victor_fit_e1		= 0.437239;
			double victor_fit_c1		= -1.56847;
			double victor_fit_a1		= (- (125.0 * victor_fit_e1  + 125.0 * victor_fit_c1 - 116.0) / 125.0);
			double answer_5th_order = (victor_fit_a1 * goal_speed5
				+ victor_fit_c1 * goal_speed3
				+ victor_fit_e1 * goal_speed);

			// Constants for the 7th order polynomial
			double victor_fit_c2 = -5.46889;
			double victor_fit_e2 = 2.24214;
			double victor_fit_g2 = -0.042375;
			double victor_fit_a2 = (- (125.0 * (victor_fit_c2 + victor_fit_e2 + victor_fit_g2) - 116.0) / 125.0);
			double answer_7th_order = (victor_fit_a2 * goal_speed7
				+ victor_fit_c2 * goal_speed5
				+ victor_fit_e2 * goal_speed3
				+ victor_fit_g2 * goal_speed);


			// Average the 5th and 7th order polynomials
			double answer =  0.85 * 0.5 * (answer_7th_order + answer_5th_order)
			+ .15 * goal_speed * (1.0 - deadband_value);

			if (answer > 0.001)
				answer += deadband_value;
			else if (answer < -0.001)
				answer -= deadband_value;

			return answer;
		}
}
