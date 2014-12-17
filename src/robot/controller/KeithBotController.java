package robot.controller;

import lejos.nxt.Button;
import robot.model.KeithBot;

public class KeithBotController 
{
	
	private KeithBot myBot;
	
	public KeithBotController()
	{
		myBot = new KeithBot();
	}
	
	public void start()
	{
		while(Button.waitForAnyPress() != Button.ID_ESCAPE)
		{
			myBot.drawShape(1, 1);
		}
		
	}
}
