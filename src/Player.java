import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Actor  implements KeyListener{
	
	protected int XPos;
	private int YPos = 380;
	//private int Random = 100;
	private int Height;
	private int Width;
	protected int currentPos;
	//private int PlayerLives = 3;
	
	public Player(SpaceInvaders spaceInvaders) {

	}
	
	public Player() {
		
	}
	
	public void paint(Graphics2D g) {
		/* Mohammed / Mark */
		g.drawImage(Stage.Monster, XPos, YPos,SpriteCache.Image.getWidth() * 5,SpriteCache.Image.getHeight() * 5, null);
		
	}

	public Rectangle getBounds() {
		return null;
	}

	public void collision(Actor a1) {
		
	}

	public void keyPressed(KeyEvent key) {
		/* Mohammed */
		if(key.getKeyCode() == KeyEvent.VK_LEFT) {
			if (XPos == 0) {
				XPos -=0;
			}
			else {
				XPos -= 10;
				currentPos = XPos;
			}
		}
		if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (XPos >= Stage.WIDTH - 61) {
				XPos +=0;
			}
			else {
				XPos += 10;
				currentPos = XPos;
			}
		}
		if (key.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println(currentPos);
			new Bullet();

		}
	}
	
	/* Mohammed */
	public void keyReleased(KeyEvent key) {
		XPos = currentPos;
	}
	
	

	public int getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(int currentPos) {
		this.currentPos = currentPos;
	}

	public void keyTyped(KeyEvent key) {
		
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
}
