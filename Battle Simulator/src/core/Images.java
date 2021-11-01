package core;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Images {


	public static Image Blueimg;
	public static Image BlueimgR;
	public static Image BlueimgL;
	public static Image BlueimgS;
	public static Image BlueimgN;

	public static Image Redimg;
	public static Image RedimgR;
	public static Image RedimgL;
	public static Image RedimgS;
	public static Image RedimgN;

	public static Image RedCavimg;
	public static Image RedCavimgR;
	public static Image RedCavimgL;
	public static Image RedCavimgS;
	public static Image RedCavimgN;

	public static Image BlueCavimg;
	public static Image BlueCavimgR;
	public static Image BlueCavimgL;
	public static Image BlueCavimgS;
	public static Image BlueCavimgN;

	public static Image CannonR;
	public static Image CannonL;
	public static Image CannonS;
	public static Image CannonN;
	public static Image explosion;

	public static Image Title;
	public static Image Field;
	public static Image blueVictory;
	public static Image redVictory;


	static public void loadImages()
	{
		try{
			Blueimg = new Image("data/blueInfRight.png");
			BlueimgR = new Image("data/blueInfRight.png");
			BlueimgL = new Image("data/blueInfLeft.png" );
			BlueimgS = new Image("data/blueInfDown.png");
			BlueimgN = new Image("data/blueInfUp.png");

			Redimg = new Image("data/redInfRight.png");
			RedimgR = new Image("data/redInfRight.png");
			RedimgL = new Image("data/redInfLeft.png" );
			RedimgS = new Image("data/redInfSouth.png");
			RedimgN = new Image("data/redInfNorth.png");


			RedCavimg = new Image("data/default.png");
			RedCavimgR = new Image("data/RedHorseRight.png");
			RedCavimgL = new Image("data/RedHorseLeft.png" );
			RedCavimgS = new Image("data/RedHorseSouth.png");
			RedCavimgN = new Image("data/RedHorseNorth.png");

			BlueCavimg = new Image("data/default.png");
			BlueCavimgR = new Image("data/BlueHorseRight.png");
			BlueCavimgL = new Image("data/BlueHorseLeft.png" );
			BlueCavimgS = new Image("data/BlueHorseSouth.png");
			BlueCavimgN = new Image("data/BlueHorseNorth.png");

			CannonR = new Image("data/CannonRight.png");
			CannonL = new Image("data/CannonLeft.png");
			CannonN = new Image("data/CannonNorth.png");
			CannonS = new Image("data/CannonSouth.png");

			Field   = new Image("data/field.jpg");
			Title   = new Image("data/title.jpg");
			blueVictory = new Image("data/Blue Victory.jpg");
			redVictory = new Image("data/Red Victory.jpg");

			explosion = new Image("data/explosion.png");

		}
		catch(SlickException e) {
		}

	}

}
