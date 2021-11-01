package core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import org.newdawn.slick.SlickException;

public class Game extends BasicGame
{
	 
	public Game(String BattleSimulator)
	{
		super(BattleSimulator);
	}

	Engine e;
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		e = new Engine();
		e.init();
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		e.update();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		e.render(g);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game("BattleSimulator"));
			appgc.setDisplayMode(Util.WIDTH, Util.HEIGHT, false);
			appgc.setVSync(true);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}