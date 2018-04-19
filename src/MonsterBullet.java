import java.awt.Graphics2D;

public class MonsterBullet extends Monster {
	
	private int mbulletY;
	private int mbulletX;
	
	public MonsterBullet(int X) {
		mbulletX = X;
		mbulletY--;
		if(mbulletY <= Stage.HEIGHT - 500) {
			isMarkedForRemoval();
		}
		
	}

	public int getMbulletX() {
		return mbulletX;
	}

	public void setMbulletX(int mbulletX) {
		mbulletX = X;
	}
	
	public int getMBulletX() {
		return mbulletY;
	}
	
	public void setMbulletY(int mbulletY) {
		mbulletY = Y;
	}
	
	public void paint(Graphics2D g) {
		g.drawImage(Stage.Bullet, mbulletX, mbulletY,SpriteCache.Image2.getWidth() * 5,SpriteCache.Image2.getHeight() * 5, null);
	}

}
