import java.util.ArrayList;

public class Bullet {

	int bulletY;
	int bulletX;
	boolean playerfire = false;
	boolean monsterfire = false;
	//private ArrayList bullets;
	
	//*Jack*//
	//Split into two, aim is to create a bullet for both monsters and players using the same method//
	public Bullet() {
		if (playerfire == true) {
			bulletY ++;
		}
		if (monsterfire == true) {
			bulletY --;
		}
	}
	
	//*Jack*//
	//Alternate layout, two methods//
	public void playerFire() {
		if (playerfire == true) {
			bulletY ++;
		}
	}
	
	public void monsterFire() {
		if (monsterfire == true) {
			bulletY --;
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
