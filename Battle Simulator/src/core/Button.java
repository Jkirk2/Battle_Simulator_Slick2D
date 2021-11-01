package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Button {
	Color off;
	Color on;
	Color tCol;
	
	int x;
	int y;
	int w;
	int h;
	String q;
	boolean isSelected;
	
	int clickTimer = 50;
	Button(int x, int y, String q)
	{
		this.x=x;
		this.y=y;
		w = Util.BUTTON_WIDTH;
		h = Util.BUTTON_HEIGHT;
		this.q = q;
		off = new Color(150,0,0);
		on =  new Color(255,0,0);
		tCol = new Color(0,0,0);
		
		isSelected = false;
		
	}

	void display(Graphics g)
	{	
		
	
		
		g.setColor(tCol);
		g.fillRect((x-10), (y-10), (w+20), (h+20));
		
		if(!isSelected)
		{
		if(mouseOver()){g.setColor(on);}
		else g.setColor(off);
		
		
		
		g.fillRect(x, y, w, h);
		
		g.setColor(tCol);
		g.setFont(Fonts.font);
		
	    g.drawString(q, x + w/2 - Fonts.font.getWidth(q)/2 , y + 8);
	    clickTimer --;
		}
	    if(Util.input.isMouseButtonDown(0) && mouseOver()&& clickTimer <=0)
	    {
	    	isSelected = true;
	    }    
	}
	
	boolean mouseOver()
	{
		if(Util.input.getMouseX() > x  && Util.input.getMouseX() < x + w && Util.input.getMouseY() > y && Util.input.getMouseY() < y + h){return true;}
		
		else return false;
	}
}