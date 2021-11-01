package red;
import org.newdawn.slick.Graphics;


import core.Images;
import core.Util;

public class RedCav extends Red {






	public RedCav(float x, float y) {
		super(x,y);
		loadImages();
		turnReset = Util.RED_CAV_TURN;
		reloadTimer = 20;

		moveLeft();

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
			Util.blue.get(targetID).die();
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
		img = Images.RedCavimg;
		imgR = Images.RedCavimgR;
		imgL =	Images.RedCavimgL;
		imgS = Images.RedCavimgS;
		imgN = Images.RedCavimgN;
	}

}


