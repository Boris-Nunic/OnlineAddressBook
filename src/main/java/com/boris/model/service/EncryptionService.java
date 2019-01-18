package com.boris.model.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionService {

	public static String encryptPassword(String password) throws NoSuchAlgorithmException {
	
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		return new String(md.digest());
	}
}
