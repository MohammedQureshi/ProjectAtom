import java.util.Random;
import java.util.Timer;

public class Monster extends Actor {
	
	private Actor actor;

	protected static int VX;
	protected static int VY;
	protected int WIDTH, HEIGHT;
	private int Firevalue = 6;
	
	public Monster() {
		
	}

	public Monster(SpaceInvaders spaceInvaders) {

	}
	
	/* Mohammed */
	public static void movement() {
		System.out.println("Test");
	}
	
	public int getWidth() {
		return WIDTH;
	}

	public void setWidth(int width) {
		this.WIDTH = width;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public void setHeight(int height) {
		this.HEIGHT = height;
	}
	
	/* Jack */
		public void Fire() {
			Random rand = new Random();
			int  n = rand.nextInt(10) + 1;
			if (n == Firevalue) {
				System.out.println(n);
				//delay(1000);
				//Fire bullet//
			}
			
		}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getVx() {
		return VX;
	}

	public void setVx(int vx) {
		VX = vx;
	}
}
