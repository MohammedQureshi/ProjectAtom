import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Actor {
	
	private Monster monster;
	private int movementX = 0;
	public static int X = 0;
	public static int Y = 0;
	private static int wait = 0;
	private static int movementDirection = 1;

	public boolean isMarkedForRemoval() {
		return false;
	}
	
	/* Mohammed -- Mark */
	public static void movement() {
		if (movementDirection == 1 && X != 57 ) {
			wait += 1;
			if(wait == 1000) {
				X += 3;
				wait = 0;
				System.out.print(X+" ");
			}
		} 
		else if (movementDirection == 1 && X == 57) {
			wait+=1;	
			if (wait==1000) {
				System.out.print("y = " +Y +" ");
				Y += 10;
				wait = 0;
				movementDirection = -1;
			}
		}
		else if (movementDirection == -1 && X !=0) {
			wait+=1;
			if(wait == 1000) {
				X -= 3;
				System.out.print(X+" ");
				wait = 0;
			}
		} 
		else if (movementDirection == -1 && X == 0) {
			wait+=1;
			if (wait==1000) {
				System.out.print("y = " +Y +" ");
				Y += 10;
				wait = 0;
				movementDirection = 1;
			}
		}
	}

	public void act() {
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
			g.drawImage(Stage.Monster ,i+X,0+Y,SpriteCache.Image.getWidth() * 3,SpriteCache.Image.getHeight() * 3, null);			
		}
		for(int i = 0; i < 450; i += 50) {
			g.drawImage(Stage.Monster ,i+X,Y+40,SpriteCache.Image.getWidth() * 3,SpriteCache.Image.getHeight() * 3, null);			
		}
		for(int i = 0; i < 450; i += 50) {
			g.drawImage(Stage.Monster ,i+X,Y+80,SpriteCache.Image.getWidth() * 3,SpriteCache.Image.getHeight() * 3, null);			
		}
		for(int i = 0; i < 450; i += 50) {
			g.drawImage(Stage.Monster ,i+X,Y+120,SpriteCache.Image.getWidth() * 3,SpriteCache.Image.getHeight() * 3, null);			
		}
		for(int i = 0; i < 450; i += 50) {
			g.drawImage(Stage.Monster ,i+X,Y+160,SpriteCache.Image.getWidth() * 3,SpriteCache.Image.getHeight() * 3, null);			
		}
		for(int i = 0; i < 450; i += 50) {
			g.drawImage(Stage.Monster ,i+X,Y + 200,SpriteCache.Image.getWidth() * 3,SpriteCache.Image.getHeight() * 3, null);			
		}
		movement();
		
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
