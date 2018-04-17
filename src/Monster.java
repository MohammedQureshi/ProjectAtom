import java.util.Random;
import java.util.Timer;

public class Monster extends Actor {
	
	private Actor actor;

	private static int X;
	private static int Y;
	private static int Vx;
	private static int Vy;
	private static int movementDirection = 1;
	private int Firevalue = 6;
	
	public Monster() {
		
	}

	public Monster(SpaceInvaders spaceInvaders) {

	}
	
	/* Mohammed */
	public static void movement() {
		System.out.println("Test");
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
		return Vx;
	}

	public void setVx(int vx) {
		Vx = vx;
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
