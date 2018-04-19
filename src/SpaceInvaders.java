import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpaceInvaders extends Canvas implements Stage, KeyListener {

	/**
	 * Mohammed Faisal Qureshi
	 * Mark Percy
	 * Jack Procter
	 * Jessica Wolfenden
	 */
	private static final long serialVersionUID = 1L;
	private BufferStrategy strategy;
	private long usedTime;
	private long score = 0;

	private SpriteCache spriteCache;
	private ArrayList actors;
	private Player player;
	
	private long SPEED = 0;

	public SpaceInvaders() {
		spriteCache = new SpriteCache();

		JFrame ventana = new JFrame(Stage.NAME);
		JPanel panel = (JPanel) ventana.getContentPane();
		setBounds(0, 0, Stage.WIDTH, Stage.HEIGHT);
		panel.setPreferredSize(new Dimension(Stage.WIDTH, Stage.HEIGHT));
		panel.setLayout(null);
		panel.add(this);
		ventana.setBounds(0, 0, Stage.WIDTH, Stage.HEIGHT);
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		ventana.setResizable(Stage.RESIZEABLE);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		requestFocus();
		addKeyListener(this);
	}

	public void initWorld() {
		actors = new ArrayList();
		for (int i = 0; i < 10; i++) {
			Monster m = new Monster(this);
			m.setX((int) (Math.random() * Stage.WIDTH));
			m.setY(i * 20);
			m.setVx((int) (Math.random() * 20 - 10));

			actors.add(m);
		}

		player = new Player(this);
		player.setX(Stage.WIDTH / 2);
		//player.setY(Stage.HEIGHT - 2 * player.getHeight()); //Reconfigure to Work with monster size
			}

	public void addActor(Actor a) {
		actors.add(a);

	}

	public void updateWorld() {
		int i = 0;
		while (i < actors.size()) {
			Actor m = (Actor) actors.get(i);
			if (m.isMarkedForRemoval()) {
				actors.remove(i);
			} else {
				m.act();
				i++;
			}
		}
		player.act();
	}

	public void checkCollisions() {
		
		try {
            
        
		
		
		Rectangle playerBounds = player.getBounds();
		for (int i = 0; i < actors.size(); i++) {
			Actor a1 = (Actor) actors.get(i);
			Rectangle r1 = a1.getBounds();
			if (r1.intersects(playerBounds)) {
				player.collision(a1);
				a1.collision(player);
			}
			for (int j = i + 1; j < actors.size(); j++) {
				Actor a2 = (Actor) actors.get(j);
				Rectangle r2 = a2.getBounds();
				if (r1.intersects(r2)) {
					a1.collision(a2);
					a2.collision(a1);
				}
			}
		}
		
		} catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");
        }
	}
	public void paintWorld() {
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		player.paint(g);
		for (int i = 0; i < actors.size(); i++) {
			Actor m = (Actor) actors.get(i);
			m.paint(g);
		}
		
		Bullet b = new Bullet(player.getX());
		b.paint(g);

		g.setColor(Color.white);
		if (usedTime > 0)
			g.drawString(String.valueOf(1000 / usedTime) + " fps", 0, Stage.HEIGHT - 480);
		else
			g.drawString("--- fps", 0, Stage.HEIGHT - 480);
		//*Jack*//
		g.setColor(Color.white);
		g.drawString("Press the ARROW keys to move & SPACE to fire", 0, Stage.HEIGHT - 30);
		
		g.setColor(Color.white);
		g.drawString(String.valueOf(Score.Cscore) + " points",  0, Stage.HEIGHT - 45);
		
		g.setColor(Color.white);
		g.drawString(String.valueOf(Score.Hscore) + " High Score",  0, Stage.HEIGHT - 465);
		
		
		strategy.show();
	}

	public SpriteCache getSpriteCache() {
		return spriteCache;
	}

	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);

	}

	public void keyTyped(KeyEvent e) {
	}

	public void game() {
		usedTime = 1000;
		initWorld();
		while (isVisible()) {
			long startTime = System.currentTimeMillis();
			updateWorld();

			checkCollisions();

			paintWorld();

			usedTime = System.currentTimeMillis() - startTime;
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
			}
		}
	}
	
	//*Jack*//
	//This will reset the program, including variables//
	public void resetGame() {
		game();
	}

	public static void main(String[] args) {
		SpaceInvaders inv = new SpaceInvaders();
		inv.game();
	}
}
