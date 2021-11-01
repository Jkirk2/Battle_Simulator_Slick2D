package core;


import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Sounds {

	public static Sound shot1;
	public static Sound shot2;
	public static Sound shot3;
	public static Sound shot4;
	public static Sound shot5;
	public static Sound shot6;
	public static Sound shot7;
	
	
	public static Music music;
	
	public static void playGunshot()
	{
		int random = (int) Util.random(7,0);
		
		if(random == 0) { shot1.play();}
		if(random == 1) { shot2.play();}
		if(random == 2) { shot3.play();}
		if(random == 3) { shot2.play();}
		if(random == 4) { shot5.play();}
		if(random == 5) { shot3.play();}
		if(random == 6) { shot7.play();}
		
			
		
		
		
	}
	
	
	public static void loadSounds()
	{
		try{
			
		
			shot1 = new Sound("data/Sounds/Gunshot1.ogg");
			shot2 = new Sound("data/Sounds/Gunshot2.ogg");
			shot3 = new Sound("data/Sounds/Gunshot3.ogg");
			shot4 = new Sound("data/Sounds/Gunshot4.ogg");
			shot5 = new Sound("data/Sounds/Gunshot5.ogg");
			shot6 = new Sound("data/Sounds/Gunshot6.ogg");
			shot7 = new Sound("data/Sounds/Gunshot7.ogg");
			music =  new Music("data/Sounds/Music.ogg");
			
		}
		catch(SlickException e) {
		}
		
	}
	
	
	

}
