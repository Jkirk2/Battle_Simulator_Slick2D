package core;

import java.awt.Font;

import org.newdawn.slick.TrueTypeFont;

public class Fonts {
public static TrueTypeFont font;

public static void loadFonts()
{
	font = new TrueTypeFont(new Font("Arial",Font.BOLD ,20),false);
}
}