package spaceInvaders;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Autora: Soraia Teixeira Barbosa
// E-mail: soraiatbarbosa@gmail.com
//arcade Space Invaders

//Classe com o metodo principal do jogo
@SuppressWarnings("serial")
public class Game extends Canvas implements Stage, KeyListener {

	private BufferStrategy strategy;
	private SpriteManager spriteManager;
	private SoundManager soundManager;
	private ArrayList<Actor> actors;
	private Player player;
	@SuppressWarnings("unused")
	private long time;
	private boolean gameOver = false;

	public Game() {
		spriteManager = new SpriteManager();
		soundManager = new SoundManager();

		JFrame window = new JFrame("Invasores do Espaço - Soraia");
		JPanel panel = (JPanel) window.getContentPane();
		setBounds(0, 0, Stage.WIDTH, Stage.HEIGHT);
		panel.setPreferredSize(new Dimension(Stage.WIDTH, Stage.HEIGHT));
		panel.setLayout(null);
		panel.add(this);

		window.setBounds(0, 0, Stage.WIDTH, Stage.HEIGHT);
		// Torna a janela visivel
		window.setVisible(true);
		// Tamanho fixo do programa, sem alteção
		window.setResizable(false);
		// Deixa o programa no meio da tela, centralizado
		window.setLocationRelativeTo(null);
		// Fecha o programa ao clicar no X da janela
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createBufferStrategy(2);
		strategy = getBufferStrategy();

		setIgnoreRepaint(true);
		window.requestFocus();

		window.addKeyListener(this);
	}

	public void initStage() {

		actors = new ArrayList<Actor>();

		for (int i = 0; i < 10; i++) {
			Alien alien = new Alien(this);
			alien.setX(i + 10);
			alien.setY(i * 20);
			alien.setVx((int) (Math.random() * 20 - 10));
			actors.add(alien);
		}

		player = new Player(this);
		player.setX(Stage.WIDTH / 2);
		player.setY(Stage.HEIGHT - 3 * player.getHeight());
		// Audio
		soundManager.loopSong("sound/zerowing.mid");
	}

	public void addActor(Actor a) {
		actors.add(a);
	}

	public void updateStage() {

		int i = 0;

		while (i < actors.size()) {

			Actor alien = (Actor) actors.get(i);

			if (alien.isSetToRemove())
				actors.remove(i);

			else {
				alien.act();
				i++;
			}
		}
		player.act();
	}

	// Metodo que checa a colisão
	public void checkCollision() {

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
	}

	public void gameOver() {
		gameOver = true;
	}

	// Metodo que desenha os pontos do jogo
	public void paintScore(Graphics2D g) {
		// Cor do painel dos pontos
		g.setColor(Color.BLUE);
		g.fillRect(0, Stage.PLAY_HEIGHT, 800, (Stage.HEIGHT - Stage.PLAY_HEIGHT));
		// Tipo e tamanho da fonte
		g.setFont(new Font("Arial", Font.BOLD, 20));
		// Cor da Fonte
		g.setPaint(Color.BLACK);
		g.drawString("PONTOS:", 20, Stage.PLAY_HEIGHT + 20);
		// Cor da fonte
		g.setPaint(Color.YELLOW);
		g.drawString(player.getScore() + "", 120, Stage.PLAY_HEIGHT + 20);
	}

	public void paintStage() {

		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		// Cor da Fonte
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		for (int i = 0; i < actors.size(); i++) {
			Actor m = (Actor) actors.get(i);
			m.paint(g);
		}

		player.paint(g);

		paintScore(g);

		strategy.show();
	}

	// Metodo que desenha o fim do jogo
	public void paintGameOver() {

		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
		// Cor do retangulo
		g.setColor(Color.BLACK);
		// Tamanho do retangulo desenhado
		g.fillRect(0, 0, 800, 600);
		// Cor da Fonte
		g.setColor(Color.RED);
		// Tipo e tamanho da fonte
		g.setFont(new Font("Arial", Font.BOLD, 20));
		// Menssage de fim de jogo
		g.drawString("GAME OVER", Stage.WIDTH / 2 - 50, Stage.HEIGHT / 2);
		strategy.show();
	}

	public SpriteManager getSpriteManager() {
		return spriteManager;
	}

	public SoundManager getSoundManager() {
		return soundManager;
	}

	public Player getPlayer() {
		return player;
	}

	public void keyPressed(KeyEvent e) {
		player.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
	}

	// Metodo construtor
	public void game() {

		time = 1000;
		initStage();

		while (isVisible() && !gameOver) {

			long startTime = System.currentTimeMillis();
			updateStage();
			checkCollision();
			paintStage();

			time = System.currentTimeMillis() - startTime;

			try {
				// Pause
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// Possiveis erros declarar aqui
			}
		}
		paintGameOver();
	}

	// Metodo principal
	public static void main(String args[]) {
		Game inv = new Game();
		inv.game();
	}

	public void keyTyped(KeyEvent e) {
		// throw new UnsupportedOperationException("Not supported yet.");
	}
}