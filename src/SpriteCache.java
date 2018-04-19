import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
	
public class SpriteCache {
	
	private String fileName = "monster";
	private String fileName1 = "player";
	private String fileName2 = "bullet";
	public static BufferedImage Image;
	public static BufferedImage Image2;
	public static BufferedImage Image3;
	
	public SpriteCache() {
		try{
			Image = ImageIO.read(new File("res/"+fileName+".png"));
			System.out.println(fileName + " File Loaded");
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
		try{
			Image2 = ImageIO.read(new File("res/"+fileName2+".png"));
			System.out.println(fileName2 + " File Loaded");
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
		try{
			Image3 = ImageIO.read(new File("res/"+fileName1+".png"));
			System.out.println(fileName1 + " File Loaded");
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
