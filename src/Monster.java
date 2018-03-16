import java.util.Random;

public class Monster extends Actor {

	private int X;
	private int Y;
	private int Vx;
	private int movementDirection = 1;
	private int Firevalue = 6;

	public Monster(SpaceInvaders spaceInvaders) {

	}
	
	/* Mohammed */
	public void movement() {
		if (movementDirection == 1) {
			X++;
			delay(1000);
		} else if (movementDirection == -1) {
			X--;
			delay(1000);
		} else {
			X = 0;
			Y = 0;
		}
		if(X == 500) {
			delay(1000);
			Y += 5;
			movementDirection = -1;
		}else if(X == 0) {
			delay(1000);
			Y += 5;
			movementDirection = 1;
		}
	}
	
	/* Jack */
		public void Fire() {
			Random rand = new Random();
			int  n = rand.nextInt(10) + 1;
			if (n == Firevalue) {
				System.out.println(n);
				//delay(1000);//
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
		public void delay(long t) {
			try {
				Thread.sleep(t);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

}
