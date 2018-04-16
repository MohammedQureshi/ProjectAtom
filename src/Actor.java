import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Actor {

	public boolean isMarkedForRemoval() {
		return false;
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
		g.drawImage(Stage.Monster, SpriteCache.Image.getWidth() * 5,SpriteCache.Image.getHeight() * 5, null);
		g.drawImage(Stage.Monster, SpriteCache.Image.getWidth() * 5,SpriteCache.Image.getHeight() * 10, null);
		g.drawImage(Stage.Monster, SpriteCache.Image.getWidth() * 10,SpriteCache.Image.getHeight() * 5, null);
	}

}
