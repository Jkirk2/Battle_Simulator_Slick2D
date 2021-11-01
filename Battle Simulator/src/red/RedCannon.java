package red;


import org.newdawn.slick.Graphics;

import core.Bullet;
import core.CannonBall;
import core.Flash;
import core.Images;
import core.Util;





public class RedCannon extends Red {
	float random = Util.random(100, -100);
	int reloadTimer;
	public RedCannon(float x, float y) {
		super(x,y);
		xSpeed = 0;
		ySpeed = 0;
		loadImages();
		reloadTimer = (int) (100 + random);
		turnReset = Util.RED_INF_TURN;
		moveLeft();
		random = Util.random(15, -15);
	}


	public void act()
	{
		super.act();

		
		if(range <= Util.CANNON_RANGE && reloadTimer <= 0)
		{
			for(int i = 0; i < 10; i ++)
			{
			Util.flash.add(new Flash(x + Util.random(-15, 15),y + Util.random(-15, 15)));
			}
			Util.bullet.add(new Bullet(x,y,targetX,targetY));
			Util.cannonballs.add(new CannonBall(targetX,targetY));
			reloadTimer = (int) (Util.CANNON_RELOAD + random);
			
		}
		else if(range <= Util.CANNON_RANGE && reloadTimer > 0)
		{
			state = "reload";
			reloadTimer --;
			toTarget();
		}
	
		
		

			
		
		
	}

	public void display(Graphics g)
	{
		super.display(g);

	}






	public void loadImages()
	{
		img = Images.CannonR;
		imgR = Images.CannonR;
		imgL =	Images.CannonL;
		imgS = Images.CannonS;
		imgN = Images.CannonN;
	}

}
