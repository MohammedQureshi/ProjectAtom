package spaceInvaders;

import java.awt.image.ImageObserver;

/**
 *
 * @author Soraia
 */
 public interface Stage extends ImageObserver {
 
public static final int WIDTH = 800;
 public static final int HEIGHT = 600;
 public static final int PLAY_HEIGHT = 520;
 public static final int SPEED = 10;
 
public SpriteManager getSpriteManager();
 
public SoundManager getSoundManager();
 
public Player getPlayer();
 
public void addActor(Actor a);
 
public void gameOver();
 
}