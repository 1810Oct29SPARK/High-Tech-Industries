package project2.hightechindustries.service;

import java.net.PasswordAuthentication;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.dao.UserDAO;
import project2.hightechindustries.dao.UserDAOImpl;

@Service(value = "loginService")
public class LoginService {

	/**
	 * @author (name=Sean, name=Jeremy) This is the LoginService. The purpose of
	 *         this service is to log people in, both employee members and customer
	 *         members, create a session when they're logged in, log them out, and
	 *         end the session when they log out.
	 */

	/**
	 * Login X Logout X
	 */
//	used in the password hashing process
	private static final Random RANDOM = new SecureRandom();
	private static final int iterations = 20000;
	private static final int keySize = 256;

	private ObjectMapper om = new ObjectMapper();

	// Create a random sequence of characters to attach to the end of each person's
	// password
	public byte[] getNextSalt() {
		// make a new byte array variable
		byte salt[] = new byte[16];
		// generate a random byte array
		RANDOM.nextBytes(salt);
		return salt;
	}

//	hash the password appended with the salt
	public byte[] hashPassword(String password, byte[] salt) {
		System.out.println("password is: " + password);
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keySize);
		Arrays.fill(password.toCharArray(), Character.MIN_VALUE);
		try {
			// try to make a new instance of the SecretKeyFactory class using the specific
			// algorithm "PBKDF2WithHmacSHA1"
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			// return the hashcode
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}

	}

//	login method that will grab the users username, password, and id and verify that what they logged in with matches. 
//	if it does, then the full user will be returned
	public Users login(String username, String password) {
		UserDAO ud = new UserDAOImpl();
		Users usersCredentials = ud.findUser(new Users(username));
		if (usersCredentials == null) {
			System.out.println("User not found, invalid username");
		} else {
			String userSalt = usersCredentials.getSalt();
			byte userSaltByte[] = userSalt.getBytes();
			String userPassHash = usersCredentials.getPassHash();
			int userId = usersCredentials.getId();
			String loginPassHash = new String(hashPassword(password, userSaltByte));
			if (!loginPassHash.equals(userPassHash)) {
				System.out.println("invalid password");
				usersCredentials = null;
			}
		}
		return usersCredentials;
	}

	public void updatePass(int userId, String firstName, String lastName, String email, String phone,
			String employeeStatus, String username, String password) {
		UserDAO ud = new UserDAOImpl();
		Integer helpedBy = null;
		Blob image = null;
		byte[] userSaltByte = new byte[16];
		userSaltByte = getNextSalt();
		byte[] passByte = hashPassword(password, userSaltByte);
		String passHash = new String(passByte);
		String userSalt = new String(userSaltByte);
		ud.updateUser(new Users(userId, firstName, lastName, email, phone, employeeStatus, helpedBy, image, username,
				passHash, userSalt));

	}

//	whenever a new user is added, the password will be hashed with a salt and both the salt and hashed password will be 
//	stored with the new user info 
	public void addUserService(String firstName, String lastName, String email, String phone, String employeeStatus,
			String username, String password) {
		UserDAO ud = new UserDAOImpl();
		Integer helpedBy = null;
		Blob image = null;
		byte[] userSaltByte = new byte[16];
		userSaltByte = getNextSalt();
		byte[] passByte = hashPassword(password, userSaltByte);
		String passHash = new String(passByte);
		String userSalt = new String(userSaltByte);
		ud.addUser(new Users(firstName, lastName, email, phone, employeeStatus, helpedBy, image, username, passHash,
				userSalt));

	}

}
