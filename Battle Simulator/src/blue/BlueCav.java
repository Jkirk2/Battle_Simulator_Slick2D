package blue;
import org.newdawn.slick.Graphics;


import core.Images;
import core.Util;

public class BlueCav extends Blue {






	public BlueCav(float x, float y) {
		super(x,y);
		loadImages();
		turnReset = Util.RED_CAV_TURN;
		reloadTimer = 20;

		moveRight();

	}


	public void act()
	{
		super.act();
		findTarget();
		if(range > img.getWidth()/2)
		{
			xSpeed +=.08;
			ySpeed +=.08;
		toTarget();
		
		}
		if(range < img.getWidth()/2)
		{
			reloadTimer --;
			if(reloadTimer < 0)
			{
			Util.red.get(targetID).die();
			reloadTimer = 50;
			}
			xSpeed = xSpeed /6;
			ySpeed= ySpeed /6;
		}
		maxSpeed();


	}

	
	
	void maxSpeed()
	{
		if(xSpeed > 3)
		{
			xSpeed = 3;
		}
		if(xSpeed < -3)
		{
			xSpeed = -3;
		}
		
		if(ySpeed > 3)
		{
			ySpeed = 3;
		}
		if(ySpeed < -3)
		{
			ySpeed = -3;
		}
	}
	
	public void display(Graphics g)
	{
		super.display(g);

	}

	public void loadImages()
	{
		img = Images.BlueCavimg;
		imgR = Images.BlueCavimgR;
		imgL =	Images.BlueCavimgL;
		imgS = Images.BlueCavimgS;
		imgN = Images.BlueCavimgN;
	}

}


