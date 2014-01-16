/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.first.team342;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class SimpleRobotExample extends SimpleRobot {
    
    public static final int JOYSTICK_PORT_1 = 1;
    
    public static final int LEFT_MOTOR_CHANNEL = 1;
    
    public static final int RIGHT_MOTOR_CHANNEL = 2;
    
    private static final double AUTONOMOUS_DRIVE_TIME = 2.5;
    
    private static final double AUTONOMOUS_DRIVE_SPEED = 0.5;
    
    private RobotDrive drivetrain;
    
    public SimpleRobotExample() {
        this.drivetrain = new RobotDrive(LEFT_MOTOR_CHANNEL, RIGHT_MOTOR_CHANNEL);
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        Timer timer = new Timer();
        
        timer.start();
        
        double startTime = timer.get();
        double targetTime = (startTime + AUTONOMOUS_DRIVE_TIME);
        
        if (timer.get() < targetTime) {
            this.drivetrain.arcadeDrive(AUTONOMOUS_DRIVE_SPEED, 0.0);
        }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        Joystick joystick = new Joystick(JOYSTICK_PORT_1);
    
        while (this.isEnabled() && this.isOperatorControl()) {
            this.drivetrain.arcadeDrive(joystick);
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
        // IGNORE THIS METHOD FOR NOW.
    }
}
