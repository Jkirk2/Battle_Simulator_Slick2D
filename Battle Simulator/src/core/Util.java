package core;

import java.util.ArrayList;

import org.newdawn.slick.Input;

import blue.Blue;
import red.Red;

public interface Util {

	
	int WIDTH =  1440;
	int HEIGHT = 900;
	

	
	
	

	
	int BUTTON_WIDTH = 300;
	int BUTTON_HEIGHT = 40;
	
	int REDCOAT_RANGE = 350;
	int REDCOAT_RELOAD = 300;
	
	int BLUECOAT_RANGE = 350;
	int BLUECOAT_RELOAD = 300;
	
	int RED_CAV_TURN   = 10;
	int RED_INF_TURN   =30;
	
	int CANNON_RELOAD = 1000;
	int CANNON_RANGE = 10000;
	
	public ArrayList<Blue> blue = new ArrayList<Blue>();
	public ArrayList<Red>  red  = new ArrayList<Red>();
	public ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	public ArrayList<Flash> flash = new ArrayList<Flash>();
	public ArrayList<Button> buttons = new ArrayList<Button>();
	public ArrayList<CannonBall> cannonballs = new ArrayList<CannonBall>();
	
	public static Input input = new Input(HEIGHT);
	
	public static float dist(float x1,float y1, float x2, float y2)
	{
		return (float) Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
	}
	
	public static float dist(float p1, float p2)
	{
		return (float) Math.abs(p2 - p1);
	}
	
	public static float random(float max, float min)
	{
		return (float)(Math.random()*(max-min))+ min;	
	}
	
}
