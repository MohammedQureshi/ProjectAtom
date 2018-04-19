import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Bullet extends Player implements KeyListener {

	private static int bulletY;
	private int bulletX;
	//public static boolean playerfire = false;
	//private List<Bullet> bullets = new ArrayList<Bullet>();
	
	//*Jack*//
	
	//private Player p = new Player();
	
	public Bullet(int XPos) {
		//System.out.println(p.getCurrentPos());
			bulletX = XPos;
			System.out.print(bulletX);
			bulletY ++;
		if (bulletY >= Stage.HEIGHT - 61) {
			isMarkedForRemoval();
		}
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(Stage.Bullet, bulletX, bulletY,SpriteCache.Image2.getWidth() * 5,SpriteCache.Image2.getHeight() * 5, null);
	}
	
	//Setters & getters//
	public void setbulletY(int y) {
		bulletY = y;
	}
	
	public int getbulletY() {
		return bulletY;
	}
	
	public void setbulletX(int x) {
		bulletX = x;
	}
	
	public int getbulletX() {
		return bulletX;
	}
	
}
