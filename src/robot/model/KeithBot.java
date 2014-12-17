package robot.model;

import lejos.nxt.Motor;
import lejos.nxt.*;

public class KeithBot 
{
	
	private UltrasonicSensor mySonar;
	private TouchSensor frontTouch;
	private TouchSensor backTouch;
	private SoundSensor microphone;
	
	public KeithBot()
	{
		mySonar = new UltrasonicSensor(SensorPort.S1);
		frontTouch = new TouchSensor(SensorPort.S2);
		backTouch = new TouchSensor(SensorPort.S3);
		microphone = new SoundSensor(SensorPort.S4);
	}
	
	/**
	 * Uses the SoundSensor Object microphone to dance.
	 * microphone.readValue(); will be the method used to determine dance
	 */
	public void danceRobotDance()
	{
		int SoundValue;
		SoundValue = microphone.readValue();
		System.out.print(SoundValue);
		
		boolean move = false;
		do
		{
			if (microphone.readValue() > 50)
			{
				move = !move;
			}
			while (mySonar.getDistance() > 30)
			{
				Motor.A.backward();
				Motor.B.backward();
			}
			if (move)
			{
				Motor.A.rotate(-90, true);
				Motor.B.rotate(90, true);
			}
	}
	
	
	/**
	 * Uses the TouchSensor, specifically the isPressed() method to move away from objects and continue moving.
	 */
	public void hasHaphephobia()
	{
		
	}
	
	/**
	 * You should stay about 8-12 inches away from objects and use the mySonar.getDistance() method to calculate that.
	 * Use this method and the mySonar object to avoid objects and drive around the room.
	 */
	public void driveAroundRoom()
	{
		
	}
	
	
	/**
	 * 
	 * @param vertexCount
	 * @param length
	 */
		public void drawShape(int vertexCount, int length)
		{
			int angle = (int) calculateAngle(vertexCount);
			
			for(int drawCount = 0; drawCount < vertexCount; drawCount++)
			{
				try
				{
					Motor.A.setSpeed(10000);
					Motor.B.setSpeed(10000);
					Button.waitForAnyPress();
					Motor.A.forward();
					Motor.B.forward();
					Thread.sleep(length* 1000);
					Motor.A.stop();
					Motor.B.stop();
					Motor.A.rotate(-angle, true);
					Motor.B.rotate(angle, true);
					}
				
					
					
				
				catch(Exception threadException)
				{
					System.out.print(threadException.getMessage());
				}
			}
		}
		/**
		 * 
		 * @param vertexCount
		 * @return
		 */
		private double calculateAngle(int vertexCount)
		{
			int currentAngle = 0;
			
			if(vertexCount != 0)
			{
				currentAngle = 360/vertexCount;
			}
			
			return currentAngle;
			
		}
}
