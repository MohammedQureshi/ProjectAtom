import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Actor {
	
	protected int X, Y;
	private static int wait = 0;
	static int movementDirection = 1;
	boolean hasExcuted = false;

	public boolean isMarkedForRemoval() {
		return false;
	}

	public void act() {
		if (movementDirection == 1) {
			wait += 1;
			if(wait == 1000) {
				X += 5;
				System.out.println(X);
				if(X >= 500) {
					Y += 30;
				}
				wait = 0;
			}
		} else if (movementDirection == -1) {
			if(wait == 1000) {
				X -= 5;
				wait = 0;
			}

		}
	}

	public Rectangle getBounds() {
		return null;
	}

	public void collision(Player player) {
		
	}

	public void collision(Actor actor) {
		
	}

	public void paint(Graphics2D g) {
		for(int i = 0; i < 450; i += 50) {
			g.drawImage(Stage.Monster ,X,Y,SpriteCache.Image.getWidth() * 3,SpriteCache.Image.getHeight() * 3, null);	
		}
	}
	
	/* Jack */
	public static void delay(long t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
