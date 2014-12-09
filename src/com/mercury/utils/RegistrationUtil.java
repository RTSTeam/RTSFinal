package com.mercury.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegistrationUtil {
	
	public static String md5(String s) throws NoSuchAlgorithmException {
		MessageDigest m=MessageDigest.getInstance("MD5");
	    m.update(s.getBytes(),0,s.length());
		return new BigInteger(1,m.digest()).toString(16);
	}
	public static String setBirthdayFormat(String birthday) {
		String[] content = birthday.split(" ");
		StringBuilder processedBirthdy = new StringBuilder(); 
		processedBirthdy.append(content[1]).append(" ").append(content[2]).append(" ").append(content[3]);
		return processedBirthdy.toString();
	}
}
