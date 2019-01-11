package project2.hightechindustries.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import project2.hightechindustries.beans.Users;
import project2.hightechindustries.dao.UserDAO;
import project2.hightechindustries.dao.UserDAOImpl;

@Service
public class LoginService {

	/**
	 * @author (name=Sean) This is the LoginService. The purpose of this service is
	 *         to log people in, both employee members and customer members, create
	 *         a session when they're logged in, log them out, and end the session
	 *         when they log out.
	 */

	/**
	 * Login X Logout X
	 */
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

	public byte[] hash(String password, byte[] salt) {
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

	public String findUser(String username, String password) {
		Users currentUser = null;
		UserDAO ud = new UserDAOImpl();

		return currentUser.toString();
	}

}