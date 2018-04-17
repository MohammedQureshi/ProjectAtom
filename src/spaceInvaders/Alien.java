package spaceInvaders;

/**
 *
 * @author Soraia
 */
public class Alien extends Actor {

	protected int vx;
	protected int vy;

	public Alien(Stage stage) {

		super(stage);
		setSpriteNames(new String[] { "img/alien1.gif", "img/alien2.gif" });
		setFrameSpeed(35);
	}

	public void act() {
		super.act();

		x += vx;
		y += vy;
		if (x < 0)
			vx = -vx;

		if (x > Stage.WIDTH - getWidth()) {
			vx = -vx;
			vy = vy + 1;
		}

		if (y < 0)
			vy = 0;
		if (y >= Stage.PLAY_HEIGHT - getHeight())
			stage.gameOver();
	}

	public void spawn() {
		Alien a = new Alien(stage);
		a.setX(1);
		a.setY((int) (Math.random() * Stage.PLAY_HEIGHT / 2));
		a.setVx((int) (Math.random() * 20 - 10));
		stage.addActor(a);
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int i) {
		vx = i;
	}

	public void collision(Actor a) {
		if (a instanceof Shot) {
			setRemove();
			spawn();
			// Adiciona 20 pontos casa alienigena destruido
			stage.getPlayer().addScore(20);
			stage.getSoundManager().playSong("sound/defeat.wav");
		}
	}
}