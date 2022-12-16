import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

class Player
{
	private int x;
	private int y;

  public Player(int x, int y)
  {
	  this.x = x;
	  this.y = y;
  }
  
  public void tick()
  {
	  // check collisions
	  if (this.x < 0) { this.x ++; }
	  if (this.x > Board.COLUMNS - 1) { this.x --; }
	  if (this.y < 0) { this.y ++; }
	  if (this.y > Board.ROWS - 1) { this.y --; }
	  
  }
  
  public void draw(Graphics g)
  {
	g.setColor(new Color(255, 0, 100));
	g.fillRect(this.x * Board.TILE_SIZE, this.y * Board.TILE_SIZE, Board.TILE_SIZE, Board.TILE_SIZE);
  }
  
 public int getX() { return this.x; }
 public int getY() { return this.y; }
 public void addX() { this.x++; }
 public void sousX() { this.x --; }
 public void sousY() { this.y--; }
 public void addY() { this.y ++; }

}
