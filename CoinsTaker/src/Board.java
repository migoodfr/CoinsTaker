

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.JPanel;

class Board extends JPanel implements ActionListener, KeyListener
{
	// CONSTANTS
	private static final int DELAY = 5;
	public static final int TILE_SIZE = 50;
	public static final int ROWS = 12;
	public static final int COLUMNS = 18;
	public static final int NBR_COINS = 25;
	
	private Player player;
	private ArrayList<Coin> coins;
	
	private int score = 0;
	private boolean running = false;
	private int counter = 0;
	
	public Board()
	{
		setPreferredSize(new Dimension(TILE_SIZE * COLUMNS, TILE_SIZE * ROWS));
		setBackground(new Color(0, 0, 0));
		
		player = new Player(5, 5);
		coins = new ArrayList();
		Random r = new Random();
		
		// creates all the coins
		int posX;
		int posY;
		for (int i = 0 ; i < NBR_COINS ; i++)
		{
			do
			{
				posX = r.nextInt(COLUMNS - 1);
				posY = r.nextInt(ROWS - 1);
			} while ((posX == player.getX() && (posY == player.getY())));
				
			coins.add(new Coin(posX, posY));
		}
		
		running = true;
		// per frame
		Timer timer = new Timer(DELAY, this);
		timer.start();
	
	}
	
	// draw functions
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (running)
		{
			drawBackground(g);
		
			for (Coin coin : coins)
			{
				coin.draw(g);
			}
		
			player.draw(g);
		}
		else
		{
			gameOver(g);
		}
		
	}
	
	private void drawBackground(Graphics g)
	{
		g.setColor(new Color(50, 50, 50));
		
		for (int row = 0 ; row < ROWS ; row++)
		{
			for (int col = 0 ; col < COLUMNS ; col++)
			{
				if ((col + row) % 2 == 1)
				{
					g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				}
			}
		}
		
	}
	
	private void gameOver(Graphics g)
	{
		g.setColor(new Color(255, 255, 255));
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Score: " + score, (ROWS * TILE_SIZE - metrics.stringWidth("Score: " + score)) / 2, g.getFont().getSize());
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_DOWN)
		{
			player.addY();
		}
		if (key == KeyEvent.VK_UP)
		{
			player.sousY();
		}
		if (key == KeyEvent.VK_LEFT)
		{
			player.sousX();
		}
		if (key == KeyEvent.VK_RIGHT)
		{
			player.addX();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (running)
		{
			player.tick();
		
			// check if player is on coin
			for (int i = 0 ; i < coins.size() ; i++)
			{
				if ((coins.get(i).getX() == player.getX()) && (coins.get(i).getY() == player.getY()))
				{
					score++;
					coins.remove(i);
				}
			}
			
			if (coins.size() == 0)
			{
				running = false;
			}
			
			if (counter == DELAY * 1000)
			{
				counter = 0;
				System.out.println(counter);
			}

			counter++;
		}
		repaint();
		
	}
}