package blue;



import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.Bullet;
import core.Flash;
import core.Util;

public abstract class Blue {

	Image img;
	Image imgR;
	Image imgL;
	Image imgS;
	Image imgN;
	Image imgFire;
	Image imgReload;
	Image imgDie;
	protected float x;
	protected float y;
	protected float range;


	protected int maxHealth;
	protected int curHealth;
	protected int speed;
	protected int reloadTimer;
	protected int reload;
	protected float  targetX;
	protected float targetY;
	protected float moveX;
	protected float moveY;
	
	protected float xSpeed;
	protected float ySpeed;

	protected int targetID;
	protected int friendlyID;

	protected boolean isAlive;

	protected String state;



	protected int turnTimer;
	protected int turnReset;


	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Blue(float x, float y) {
		this.x=x;
		this.y=y;
		loadImages();
		range = 10000;
		isAlive = true;
		xSpeed = 1;
		ySpeed = 1;

	}

	public void act()
	{
		update();
	}
	public void display(Graphics g)
	{
		displayUnit();
	}

	void displayUnit()
	{
		img.draw(x - img.getWidth()/2, y - img.getWidth()/2);
	}

	void update()
	{
		if (!isAlive)
		{
			Util.blue.remove(this);
		}

		if(state == "left"){moveLeft();}
		if(state == "right"){moveRight();}
		if(state == "north"){moveNorth();}
		if(state == "south"){moveSouth();}
		if(state == "fire") {fire();}
		if(state == "reload"){reload();}
		//if(state != "fire" && state != "reload"){collision();}
		collision();
	}

	void moveRight()
	{
		x += xSpeed;
		img = imgR;
	}

	void moveLeft()
	{
		x -= xSpeed;
		img = imgL;
	}
	void moveNorth()
	{
		y-=ySpeed;
		img = imgN;
	}
	void moveSouth()
	{
		y+=ySpeed;
		img = imgS;
	}

	void findTarget()
	{
		float shortest = 1000000;
		float bestX= 0;
		float bestY= 0;
		for(int i = 0; i < Util.red.size(); i++)
		{

			if(Util.dist(x, y, Util.red.get(i).getX(), Util.red.get(i).getY()) < shortest)
			{
				bestX = Util.red.get(i).getX();
				bestY = Util.red.get(i).getY();
				shortest = Util.dist(x, y, Util.red.get(i).getX(), Util.red.get(i).getY());
				targetID = i;
			}
		}
		targetX = bestX;
		targetY = bestY;
		range = Util.dist(x, y, targetX, targetY);
	}


	void reload()
	{
		findTarget();
		
		reloadTimer --;
	}

	void findFriendly()
	{
		float shortest = 1000000;
		float bestX= 0;
		float bestY= 0;
		for(int i = 0; i < Util.blue.size(); i++)
		{

			if(Util.dist(x, y, Util.blue.get(i).getX(), Util.blue.get(i).getY()) < shortest)
			{
				bestX = Util.blue.get(i).getX();
				bestY = Util.blue.get(i).getY();
				if(Util.blue.get(i).getX() != x && Util.blue.get(i).getY() != y)
				{
					shortest = Util.dist(x, y, Util.blue.get(i).getX(), Util.blue.get(i).getY());
				}
				friendlyID = i;
			}
		}
		moveX = bestX;
		moveY = bestY;

	}

	void toTarget()
	{
		turnTimer --;
		if(turnTimer <= 0)
		{
			findTarget();
			if(Util.dist(x, targetX) > Util.dist(y, targetY))
			{
				if(Util.dist(x, targetX) > 1 )
				{
					if(x > targetX)
					{
						state = "left";
					}
					if(x < targetX)
					{
						state = "right";
					}
				}
			}
			if(Util.dist(y, targetY) > 1 && Util.dist(x, targetX) < Util.dist(y, targetY)){
				if(y > targetY)
				{
					state = "north";
				}
				if(y < targetY)
				{
					state = "south";
				}
			}
			turnTimer = turnReset;
		}
	}


	void collision()
	{
		float random = Util.random(100, 0);
		findFriendly();
		if(Util.dist(x, y,moveX,moveY) < img.getWidth()/2 )
		{

			if(Util.dist(x, moveX) < Util.dist(y, moveY))
			{
				//if(x > moveX){state = "right";}
				//if(x < moveY){state = "left"; }

				if(random > 50){x++;}
				if(random < 50){x--;}
			}
			if(Util.dist(x, moveX) > Util.dist(y, moveY))
			{
				//if(y > moveY){state = "south";}
				//if(y < moveY){state = "north"; }
				if(random > 50){y++;}
				if(random < 50){y--;}
			}

		}

	}

	public void die()
	{
		curHealth = 0;
		isAlive = false;
	}

	void loadImages()
	{
		try{
			img = new Image("data/default.png");
			imgR = new Image("data/default.png");
			imgL = new Image("data/default.png");
			imgS = new Image("data/default.png");
			imgN = new Image("data/default.png");
		}
		catch(SlickException e) {
		}
	}

	void fire()
	{

		findTarget();
		for(int i = 0; i<3; i++)
		{
			float random = Util.random(10,-10);
		Util.flash.add(new Flash(x - img.getWidth() + random,y- img.getTextureWidth() + random));
		}
		if(Util.random(range, 0)/5 < 10)
		{
			Util.bullet.add(new Bullet(x,y,targetX,targetY));
			Util.red.get(targetID).die();

		}
		else
		{
			Util.bullet.add(new Bullet(x,y,targetX + Util.random(-20, 20),targetY + Util.random(-40, 40)));
			
		}

		state = "null";
		
	}


}
