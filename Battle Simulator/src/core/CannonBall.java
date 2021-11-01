package core;

import org.newdawn.slick.Image;

public class CannonBall {
 float x;
 float y;
 float random;
 int timer;
 Image img;
 

	public CannonBall(float targetX, float targetY) {
		img = Images.explosion;
		this.x=targetX;
		this.y=targetY;
		random = Util.random(100, -100);
		targetX+= random;
		random = Util.random(100, -100);
		targetY+= random;
		timer = 10;
		
	}
	
	void act()
	{
		
		Util.flash.add(new Flash(x+Util.random(20, -20),y+Util.random(20, -20)));
		timer --;
		
		findRed();
		findBlue();
		if(timer <= 0)
		{
			Util.cannonballs.remove(this);
		}
	}
	void display()
	{
		img.draw(x,y);
	}
	
	
	void findRed()
	{
		for(int i = 0; i < Util.red.size(); i++)
		{
				if( Util.dist(x, y, Util.red.get(i).getX(), Util.red.get(i).getY()) < 20)
				{
					Util.red.get(i).die();
				}
		}
	}
	
	void findBlue()
	{
		for(int i = 0; i < Util.blue.size(); i++)
		{
				if( Util.dist(x, y, Util.blue.get(i).getX(), Util.blue.get(i).getY()) < 20)
				{
					Util.blue.get(i).die();
				}
		}
	}
}
