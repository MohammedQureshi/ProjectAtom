import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Actor implements KeyListener{
	
	private int XPos = 0;
	private int YPos = 380;
	//private int Random = 100;
	private int Height;
	private int Width;
	private int currentPos;
	//private int PlayerLives = 3;
	
	public Player(SpaceInvaders spaceInvaders) {

	}
	
	public Player() {
		
	}

	public int getX() {
		return XPos;
	}

	public void setX(int x) {
		XPos = x;
	}

	public int getY() {
		return YPos;
	}

	public void setY(int y) {
		YPos = y;
	}

	public int getHeight() {
		return Height;
	}

	public void setHeight(int height) {
		Height = height;
	}

	public int getWidth() {
		return Width;
	}

	public void setWidth(int width) {
		Width = width;
	}

	public void act() {
	}

	public Rectangle getBounds() {
		return null;
	}

	public void collision(Actor a1) {
		
	}

	public void paint(Graphics2D g) {
		/* Mohammed / Mark */
		g.drawImage(Stage.Monster, XPos, YPos,SpriteCache.Image.getWidth() * 5,SpriteCache.Image.getHeight() * 5, null);
		
	}

	public void keyPressed(KeyEvent key) {
		/* Mohammed */
		if(key.getKeyCode() == KeyEvent.VK_LEFT) { 
			XPos -= 10;
			currentPos = XPos;
		}
		if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
			XPos += 10;
			currentPos = XPos;
		}
		if (key.getKeyCode() == KeyEvent.VK_SPACE) {
			//FIRE//
		}
		
	}
	
	/* Mohammed */
	public void keyReleased(KeyEvent key) {
		XPos = currentPos;
		
	}

	public void keyTyped(KeyEvent key) {
		
	}
}
