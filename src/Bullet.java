import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Bullet extends Player implements KeyListener {

	int bulletY;
	int bulletX;
	boolean playerfire = false;
	//private ArrayList bullets;
	
	//*Jack*//
	public Bullet() {
		if (playerfire == true) {
			getX();
			bulletY ++;
		}
		
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
