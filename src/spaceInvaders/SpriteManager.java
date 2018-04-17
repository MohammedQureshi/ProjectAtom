package spaceInvaders;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Soraia
 */
public class SpriteManager extends ResourceCache {

	protected Object loadResource(URL url) {
		try {
			return ImageIO.read(url);
		} catch (Exception e) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Erro ao carregar o jogo!" + "\nPor favor, verifique a instalação.",
					"Invasores Do Espaço - Soraia", JOptionPane.ERROR_MESSAGE);

			System.exit(0);

			return null;
		}
	}

	public BufferedImage getSprite(String name) {
		return (BufferedImage) getResource(name);
	}
}