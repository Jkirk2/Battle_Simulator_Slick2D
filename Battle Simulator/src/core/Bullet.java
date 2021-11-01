package core;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;



public class Bullet {


	float x;
	float x2;
	float y;
	float y2;
	Color c;
	float xSpeed;
	float ySpeed;
	
	int timer;
	boolean isDead;
	public Bullet(float x1, float y1, float x2, float y2) {
		timer = 200;
		this.x=x1;
		this.y=y1;
		this.x2=x2;
		this.y2=y2;
		xSpeed = Util.dist(x1, x2)/5;
		ySpeed = Util.dist(y1, y2)/5;
		c = new Color(255,255,255);
		
		if(x > x2)
		{
			xSpeed = xSpeed *-1;
		}
		
		if(y > y2)
		{
			ySpeed = ySpeed *-1;
		}

	}

	
	
	void display(Graphics g)
	{
		g.setColor(c);
		g.drawLine(x, y, x+xSpeed/2, y+ ySpeed/2);
		x+=xSpeed;
		y+=ySpeed;
		timer --;
		
		if(Util.dist(x, y, x2, y2)< 1|| timer <=0)
		{
			Util.bullet.remove(this);
		}
		
	}
	
	
}
