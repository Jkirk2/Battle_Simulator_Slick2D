package blue;


import org.newdawn.slick.Graphics;

import core.Images;
import core.Util;





public class Bluecoat extends Blue {
	float random = Util.random(100, -100);
	int reloadTimer;
	public Bluecoat(float x, float y) {
		super(x,y);
		loadImages();
		reloadTimer = (int) (20 + random);
		turnReset = Util.RED_INF_TURN;
		moveRight();
		random = Util.random(15, -15);
	}


	public void act()
	{
		super.act();

		
		if(range <= Util.REDCOAT_RANGE && reloadTimer <= 0)
		{
			
			state = "fire";
			reloadTimer = (int) (Util.REDCOAT_RELOAD + random);
			
		}
		else if(range <= Util.REDCOAT_RANGE && reloadTimer > 0)
		{
			state = "reload";
			reloadTimer --;
		}
		else 
		{
			
			toTarget();
			
		}
		
		

			
		
		
	}

	public void display(Graphics g)
	{
		super.display(g);

	}






	public void loadImages()
	{
		img = Images.Blueimg;
		imgR = Images.BlueimgR;
		imgL =	Images.BlueimgL;
		imgS = Images.BlueimgS;
		imgN = Images.BlueimgN;
	}

}
