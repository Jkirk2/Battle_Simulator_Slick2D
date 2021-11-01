package red;


import org.newdawn.slick.Graphics;


import core.Images;
import core.Util;




public class Redcoat extends Red {
	float random = Util.random(100, -100);
	int reloadTimer;
	public Redcoat(float x, float y) {
		super(x,y);
		loadImages();
		reloadTimer = (int) (20 + random);
		turnReset = Util.RED_INF_TURN;
		moveLeft();
		random = Util.random(15, -15);
	}


	public void act()
	{
		super.act();

		
		if(range < Util.REDCOAT_RANGE && reloadTimer <= 0)
		{
			
			state = "fire";
			reloadTimer = (int) (Util.REDCOAT_RELOAD + random);
			
		}
		else if(range < Util.REDCOAT_RANGE && reloadTimer > 0)
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
		img = Images.Redimg;
		imgR = Images.RedimgR;
		imgL =	Images.RedimgL;
		imgS = Images.RedimgS;
		imgN = Images.RedimgN;
	}

}
