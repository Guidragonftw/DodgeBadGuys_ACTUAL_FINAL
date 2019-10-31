//Name -

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Person 
{
	private ArrayList<Image> list;	
	private int x, y, current;
	
	public Person(int x, int y) throws IOException
	{
		this.x=x;
		this.y=y;
		current = 0;

		Image back = ImageIO.read(new File("dudeU.gif"));
		Image left = ImageIO.read(new File("dudeL.gif"));
		Image right = ImageIO.read(new File("dudeR.gif"));
		Image front = ImageIO.read(new File("dude.gif"));

		list = new ArrayList<>();

		list.add(front);
		list.add(left);
		list.add(right);
		list.add(back);
		//point the array list at a new ArrayList
		
		//add all images to the list		
	}
	
	// will return true if person collides with another object
	public boolean collide(int x, int y)
	{
		Rectangle a = new Rectangle(this.x, this.y, 50, 50);
		Rectangle b = new Rectangle(x, y, 50, 50);
		return a.intersects(b);
	}
	
	public void drawPerson(Graphics2D g)
	{
		//draw the current image on the screen
		g.drawImage(getCurrent(), getX(), getY(), null);
		if(y >= 550){
			VICTORY(g);
		}
	}
	
	public Image getCurrent()
	{
		//return the current image
		return list.get(current);
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public void moveRight()
	{
		//finish
		current = 2;
		x += 5;
	}
	
	public void moveLeft()
	{
		current = 1;
		x -= 5;
	}
	
	public void moveUp()
	{
		//finish
		current = 3;
		y -= 5;
	}
	
	public void moveDown()
	{
		//finish
		current = 0;
		y += 5;
	}
	public void VICTORY(Graphics2D g)
	{
		Font f = new Font("Dialog", Font.PLAIN, 24);
		g.setFont(f);
		g.drawString("VICTORY!", 400, 300);
		Game.RUNNING = false;
	}
}
