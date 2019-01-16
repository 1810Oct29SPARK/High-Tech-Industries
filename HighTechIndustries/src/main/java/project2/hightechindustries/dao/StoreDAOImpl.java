package project2.hightechindustries.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.stereotype.Service;

import oracle.net.aso.s;
import project2.hightechindustries.beans.Store;
import project2.hightechindustries.util.HibernateUtil;

@Service
public class StoreDAOImpl implements StoreDAO {
	
	/**
	 * @author Esteban, Sean
	 */
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	// Getting a single item in the store
	@Override
	public Store getStoreById(Integer productId) {
		Store str = null;
		Store storeWithPic = null;
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			// Casting to Store object to be returned and used later
			System.out.println("str before: "+str);
			str = (Store) s.get(Store.class, productId);
			System.out.println("str: "+str);
			byte[] byteThing = str.getImage();
			ByteArrayInputStream thingStream = new ByteArrayInputStream(byteThing);
			BufferedImage thingy = ImageIO.read(thingStream);
			File hope = new File (str.getProductId()+ ".jpg");
			ImageIO.write(thingy, "jpg", hope);
			
			storeWithPic = new Store(str.getProductId(), str.getProductName(), str.getDescription(), str.getPrice(), str.getSpecs(), hope);
			
			tx.commit();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return storeWithPic;
	}

	// Getting a list of everything in the store, can be filtered to show specific things later by front end
	@Override
	public List<Store> getAllStore() {
		List<Store> str = new ArrayList<>();
		//use a Query to retrieve all caves
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			// Writing a query by selecting items from Store table
			str = s.createQuery("from Store").getResultList();
			tx.commit();
			s.close();
		}
		// Returning list of items from store
		return str;
	}

	// Adding items to the store
	@Override
	public void addStore(Store store) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(store);
			tx.commit();
			s.close();
		}
	}

	// If new/incorrect information is in a store, it can be updated
	@Override
	public void updateStore(Store store) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(store);
			tx.commit();
			s.close();
		}
	}

	// Used to delet an item from the store, may be faulty/bad
	@Override
	public void deleteStore(Store store) {
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(store);
			tx.commit();
			s.close();
		}
	}

//	@Override
//	public void addPhoto() {
//		try(Session s = sf.getCurrentSession()){
//			Transaction tx = s.beginTransaction();
//			tx.begin();
//			Store product = new Store();
//			product.setProductName("Prototype");
//			s.doWork(conn->{
//				product.setImage(BlobProxy.generateProxy(getImage()));
//			});
//			s.save(product);
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static byte[] getImage() {
//		File file = new File("Java.png");
//		if (file.exists()) {
//			try {
//				BufferedImage bufferedImage = ImageIO.read(file);
//				ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
//				ImageIO.write(bufferedImage, "png", byteOutputStream);
//				return byteOutputStream.toByteArray();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public void getPhoto() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void insertPhoto(int id) {
		File file = new File("C:\\Users\\seans\\Pictures\\RobotDog1.png");
		byte[] imageData = new byte[(int)file.length()];
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(imageData);
			fileInputStream.close();
			Store image = new Store();
			image.setProductId(id);
//			image.setImage("Asimo.jpeg");
			image.setImage(imageData);
			s.save(image);
			tx.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
