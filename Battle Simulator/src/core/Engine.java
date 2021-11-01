package core;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;






public class Engine {

	boolean newGame = true;
	static String gameState;
	Menu m;
	float timer = 100;
	float victoryTimer = 200;
	void init()
	{
		m = new Menu();
		
		Sounds.loadSounds();
		Images.loadImages();
		Sounds.music.loop();
		Sounds.music.setVolume((float) .5);
		Fonts.loadFonts();
		
	}

	void update()
	{
		
		
		
		timer --;
		if(timer == 0){gameState = "newGame";}
		if(gameState == "newGame") {newGame(); }
		if(gameState == "selecter"){selecter();}
		if(gameState == "gameplay"){gameplay();actions();exitButton();}
		
	}

	void render(Graphics g)
	{
		if(timer > 0)
		{
			g.drawString("Loading...", Util.WIDTH/2 - 30, Util.HEIGHT/2);
		}
		
		
		if(gameState == "newGame"){displayTitle();}
		if(gameState == "selecter"){displayField(); display(g); m.statBar(g);}
		if(gameState == "gameplay"){displayField();display(g); m.statBar(g);}
		
		if(gameState == "redVictory") {redVictory(g);}
		if(gameState == "blueVictory"){blueVictory(g);}


		m.buttons(g);
		
		
	}


	void blueVictory(Graphics g)
	{
		Color blue = new Color(100,100,200);
		victoryTimer --;
		Images.blueVictory.draw(0,0,Util.WIDTH,Util.HEIGHT);
		String b = "Blue Victory!";
		g.setColor(blue);
		g.setFont(Fonts.font);
		g.drawString(b, Util.WIDTH/2 -Fonts.font.getWidth(b)/2, Util.HEIGHT/2);
		if(victoryTimer <=0)
		{
			newGame = true;
			gameState = "newGame";
		}
	}
	
	void redVictory(Graphics g)
	{
		
		Color red = new Color(200,100,100);
		String r = "Red Victory!";
		victoryTimer --;
		Images.redVictory.draw(0,0,Util.WIDTH,Util.HEIGHT);
		g.setFont(Fonts.font);
		g.setColor(red);
		g.drawString(r, Util.WIDTH/2 - Fonts.font.getWidth(r)/2, Util.HEIGHT/2);
		
		if(victoryTimer <=0)
		{
			newGame = true;
			gameState = "newGame";
		}
	}


	void display(Graphics g)
	{
		
		for(int i = 0; i < Util.bullet.size(); i++)
		{
			Util.bullet.get(i).display(g);
		}
		for(int i = 0; i < Util.red.size(); i++)
		{
			Util.red.get(i).display(g);
		}
		for(int i = 0; i < Util.blue.size(); i++)
		{
			Util.blue.get(i).display(g);
		}
		for(int i = 0; i < Util.cannonballs.size(); i++)
		{
			Util.cannonballs.get(i).display();
		}
		for(int i = 0; i < Util.flash.size(); i++)
		{
			Util.flash.get(i).display(g);
		}
		
	}

	void actions()
	{
		for(int i = 0; i < Util.red.size(); i++)
		{
			Util.red.get(i).act();

		}

		for(int i = 0; i < Util.blue.size(); i++)
		{
			Util.blue.get(i).act();
		}
	
		for(int i = 0; i < Util.cannonballs.size(); i++)
		{
			Util.cannonballs.get(i).act();
		}

	}


	void displayField()
	{
		Images.Field.draw(0,0,Util.WIDTH,Util.HEIGHT);
	}
	void displayTitle()
	{
		Images.Title.draw(0,0,Util.WIDTH,Util.HEIGHT);
	}


	void newGame()
	{
		if(newGame == true)
		{
			m.StartGame();
			newGame = false;
		}


		if(Util.buttons.get(1).isSelected){System.exit(0);}
		if(Util.buttons.get(0).isSelected){m.clickTimer = 20; gameState = "selecter";  wipe();playButton();}


	}

	void selecter()
	{

		m.selecter();
		if(Util.buttons.get(0).isSelected)
		{
			gameState = "gameplay";
			Util.buttons.clear();
		}
	}


	void gameplay()
	{
		if(Util.blue.size()<=0 )
		{
			victoryTimer = 150;
			wipe();
			
			gameState = "redVictory";
			
			
		}
		else if(Util.red.size()<=0)
		{
			victoryTimer = 150;
			wipe();
			
			gameState = "blueVictory";
			
		}
	}




	void playButton()
	{
		Util.buttons.add(new Button(Util.WIDTH/2 - Util.BUTTON_WIDTH/2 ,Util.HEIGHT - Util.BUTTON_HEIGHT-10 ,"Go"));
	}
	void exitButton()
	{
		//Util.buttons.add(new Button(Util.WIDTH/2 - Util.BUTTON_WIDTH/2 ,Util.HEIGHT - Util.BUTTON_HEIGHT-10 ,"Restart"));
	}
	void wipe()
	{
		Util.buttons.clear();
		Util.blue.clear();
		Util.red.clear();
		Util.flash.clear();
		Util.bullet.clear();
		Util.cannonballs.clear();
	}



}
