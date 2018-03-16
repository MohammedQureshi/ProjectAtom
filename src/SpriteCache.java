import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
	
public class SpriteCache {
	
	private String fileName = "monster";
	public static BufferedImage Image;
	
	public SpriteCache() {
		try{
			Image = ImageIO.read(new File("res/"+fileName+".png"));
			System.out.println(fileName + " File Loaded");
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
}
