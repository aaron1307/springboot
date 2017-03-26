package com.aaron.exer.util;

import java.util.Random;

/**
 * UUIDUtil created to generate uuid
 * 
 * @author Aaron C.
 * @version v0.1
 */
public class UUIDUtil {

	//character table
	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
			'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z' };

	/**
	 * use random generated index to form a uuid, the size of the
	 * uuid can be defined according to needs
	 * 
	 * @param size
	 * @return String
	 */
	public static String id(int size) {
		Random random = new Random();
		char[] cs = new char[size];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = digits[random.nextInt(digits.length)];
		}
		return new String(cs);
	}

}
