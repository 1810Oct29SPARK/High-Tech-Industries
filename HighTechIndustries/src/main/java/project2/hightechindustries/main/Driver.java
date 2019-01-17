package project2.hightechindustries.main;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;

import javax.imageio.ImageIO;

import project2.hightechindustries.beans.Store;
import project2.hightechindustries.dao.StoreDAO;
import project2.hightechindustries.dao.StoreDAOImpl;

public class Driver {
	public static void main(String args[]) throws Exception {
		StoreDAO sd = new StoreDAOImpl();
		Store thing = sd.getStoreById(44);
		System.out.println(thing);
		Blob image = thing.getImage();
		InputStream inputStream = image.getBinaryStream();
		Files.copy(inputStream, Paths.get("productPics/" + thing.getProductId()+".png"), StandardCopyOption.REPLACE_EXISTING);
		
		
//		byte[] byteThing = thing.getImage();
//		ByteArrayInputStream thingStream = new ByteArrayInputStream(byteThing);
//		BufferedImage thingy = ImageIO.read(thingStream);
//		ImageIO.write(thingy, "jpg", new File (thing.getProductId() +".jpg"));
		/**
		 * There's probably a better way to do this.
		 * But for now, this is what we've got.
		 */
		
		
//	      BufferedImage bImage = ImageIO.read(new File("sample.jpg"));
//	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
//	      ImageIO.write(bImage, "jpg", bos );
//	      byte [] data = bos.toByteArray();
//	      ByteArrayInputStream bis = new ByteArrayInputStream(data);
		
//	      BufferedImage bImage2 = ImageIO.read(bis);
//	      ImageIO.write(bImage2, "jpg", new File("output.jpg") );
//	      System.out.println("image created");
	   }

}
