import java.awt.Color;
import java.awt.Graphics;

public class Coin 
{
	private int x;
	private int y;

	public Coin(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(new Color(255, 255, 100));
		g.fillOval(this.x * Board.TILE_SIZE, this.y * Board.TILE_SIZE, Board.TILE_SIZE, Board.TILE_SIZE);
	}
	
	public int getX() { return this.x; }
	public int getY() { return this.y; }
	
}
