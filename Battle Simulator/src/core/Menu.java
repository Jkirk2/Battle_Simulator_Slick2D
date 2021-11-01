package core;



import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import blue.BlueCannon;
import blue.BlueCav;
import blue.Bluecoat;
import red.RedCannon;
import red.RedCav;
import red.Redcoat;





public class Menu {

	String instruction;
	String blueSize;
	String redSize;

	boolean wipe;
	int clickTimer = 50;
	Color bar = new Color(50,50,50); 
	Color blue = new Color(100,100,200);
	Color red  = new Color(200,100,100);
	Color blueBox = new Color(100,100,200,120);
	Color redBox  = new Color(200,100,100,120);
	void StartGame()
	{
		Util.buttons.clear();
		Util.blue.clear();
		Util.red.clear();
		Util.flash.clear();
		Util.bullet.clear();

		Util.buttons.add(new Button(Util.WIDTH/2 - Util.BUTTON_WIDTH/2 ,Util.HEIGHT/2 - Util.BUTTON_HEIGHT*3 ,"Start Game"));
		Util.buttons.add(new Button(Util.WIDTH/2 - Util.BUTTON_WIDTH/2 ,Util.HEIGHT/2 + Util.BUTTON_HEIGHT*3,"Exit Game"));






	}

	boolean blueSelecting;
	boolean redSelecting;
	
	
	
	void selecter()
	{

		clickTimer --;
		if(Util.input.isMouseButtonDown(0) && clickTimer <= 0)
		{
			

			if(Util.input.getMouseX() > Util.WIDTH/2 && Util.input.getMouseY() < Util.HEIGHT - 60)
			{
				Util.red.add(new Redcoat(Util.input.getMouseX(),Util.input.getMouseY()));	
			}

			if(Util.input.getMouseX() < Util.WIDTH/2 && Util.input.getMouseY() < Util.HEIGHT - 60)
			{
				Util.blue.add(new Bluecoat(Util.input.getMouseX(),Util.input.getMouseY()));	
			}
			clickTimer = 15;

		}
		if(Util.input.isMouseButtonDown(1) && clickTimer <= 0)
		{
			if(Util.input.getMouseX() > Util.WIDTH/2 && Util.input.getMouseY() < Util.HEIGHT - 60)
			{
				Util.red.add(new RedCav(Util.input.getMouseX(),Util.input.getMouseY()));	
			}
			if(Util.input.getMouseX() < Util.WIDTH/2 && Util.input.getMouseY() < Util.HEIGHT - 60)
			{
				Util.blue.add(new BlueCav(Util.input.getMouseX(),Util.input.getMouseY()));	
			}
			clickTimer = 15;
		}
		
		if(Util.input.isMouseButtonDown(2) && clickTimer <= 0)
		{
			
			if(Util.input.getMouseX() < Util.WIDTH/2 && Util.input.getMouseY() < Util.HEIGHT - 60)
			{
				Util.blue.add(new BlueCannon(Util.input.getMouseX(),Util.input.getMouseY()));	
			}
			if(Util.input.getMouseX() > Util.WIDTH/2 && Util.input.getMouseY() < Util.HEIGHT - 60)
			{
				Util.red.add(new RedCannon(Util.input.getMouseX(),Util.input.getMouseY()));	
			}
			clickTimer = 15;
		}


	}

	void statBar(Graphics g)
	{





		blueSize = "Blue Soldiers : " + Util.blue.size();
		redSize = "Red Soldiers : " + Util.red.size();
		instruction = "LEFT CLICK TO ADD INFANTRY RIGHT CLICK FOR CAVALRY MIDDLE CLICK FOR ARTILLERY";
		String warning = "OVER 400 WILL CAUSE LAG";
		g.setFont(Fonts.font);
		if(Engine.gameState == "selecter")
		{
			g.setColor(blueBox);
			g.fillRect(0,0,Util.WIDTH/2,Util.HEIGHT-60);

			g.setColor(redBox);
			g.fillRect(Util.WIDTH/2, 0,Util.WIDTH/2,Util.HEIGHT - 60);

			g.setColor(bar);
			g.drawString(instruction, Util.WIDTH/2 - Fonts.font.getWidth(instruction)/2 , 50);
			g.drawString(warning, Util.WIDTH/2 - Fonts.font.getWidth(warning)/2 , 100);
		}

		g.setColor(bar);
		g.fillRect(0, Util.HEIGHT - 60, Util.WIDTH, 60);

		g.setColor(blue);

		g.drawString(blueSize, 20  , Util.HEIGHT - 40);

		g.setColor(red);
		g.drawString(redSize, Util.WIDTH - Fonts.font.getWidth(redSize) -20 , Util.HEIGHT - 40);


		if(Engine.gameState == "gameplay")
		{
			g.setColor(red);
			g.fillRect(Util.WIDTH/2 - 200 , Util.HEIGHT-40 , 400, 30);

			g.setColor(blue);
			g.fillRect(Util.WIDTH/2 - 200 , Util.HEIGHT-40, 400 * ratio(),30);

		}

	}




	float ratio()
	{

		return ((float) Util.blue.size() / ( (float)Util.blue.size() + (float) Util.red.size()));

	}


	void buttons(Graphics g)
	{
		for(int i = 0; i < Util.buttons.size(); i++)
		{
			Util.buttons.get(i).display(g);
		}
	}


}
