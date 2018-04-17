package spaceInvaders;

import java.awt.event.KeyEvent;

/**
 *
 * @author Soraia
 */
public class Player extends Actor {

	protected int vx;
	// protected int vy;
	protected static final int PLAYER_SPEED = 4;
	private boolean /* up, down, */ left, right;
	// Zerando a variavel pontos
	private int score = 0;

	public Player(Stage stage) {
		super(stage);
		setSpriteNames(new String[] { "img/ship.gif" });
	}

	public void act() {
		super.act();
		x += vx;
		// y+=vy;
		if (x < 0)
			x = 0;
		if (x > Stage.WIDTH - getWidth())
			x = Stage.WIDTH - getWidth();
		// if (y < 0 )
		// y = 0;
		// if ( y > Stage.PLAY_HEIGHT-getHeight())
		// y = Stage.PLAY_HEIGHT - getHeight();
	}

	protected void updateSpeed() {
		vx = 0;
		// vy = 0;
		// if(down)
		// vy = PLAYER_SPEED;
		// if(up)
		// vy = -PLAYER_SPEED;
		if (left)
			vx = -PLAYER_SPEED;
		if (right)
			vx = PLAYER_SPEED;
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		// case KeyEvent.VK_UP : up = false;
		// break;
		//
		// case KeyEvent.VK_DOWN : down = false;
		// break;

		case KeyEvent.VK_LEFT:
			left = false;
			break;

		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		}
		updateSpeed();
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		// case KeyEvent.VK_UP : up = true;
		// break;
		//
		// case KeyEvent.VK_DOWN : down = true;
		// break;

		case KeyEvent.VK_LEFT:
			left = true;
			break;

		case KeyEvent.VK_RIGHT:
			right = true;
			break;

		case KeyEvent.VK_SPACE:
			fire();
			break;
		}
		updateSpeed();
	}

	public void fire() {
		Shot shot = new Shot(stage);
		shot.setX(x + 25);
		shot.setY(y - shot.getHeight());
		stage.addActor(shot);
		stage.getSoundManager().playSong("sound/shot.wav");
	}

	public int getScore() {
		return score;
	}

	public void setScore(int i) {
		score = i;
	}

	public void addScore(int i) {
		score = score + i;
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int i) {
		vx = i;
	}

	// public int getVy(){return vy;}
	// public void setVy(int i){vy = i;}

	public void collision(Actor a) {
		if (a instanceof Alien)
			stage.gameOver();
	}
}