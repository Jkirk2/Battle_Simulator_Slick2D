package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Flash {

	float x;
	float y;
	int timer;
	float size;
	Color c;
	public Flash(float x, float y) {
		timer = 255;
		size = Util.random(7, 2);
		this.x=x;
		this.y=y;
		c = new Color(timer,timer,timer);
		Sounds.playGunshot();
		
	}
	
	
	void display(Graphics g)
	{
		x-=.2;
		c = new Color(timer,timer,timer,50);
		g.setColor(c);
		g.fillOval(x , y, timer/size , timer /size);
		
		timer --;
		
		if( timer <=0)
		{
			Util.flash.remove(this);
		}
		
	}

}
