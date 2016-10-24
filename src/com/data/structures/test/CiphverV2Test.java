package com.data.structures.test;

import com.quickplay.security.crypto.CipherV2;
import com.quickplay.security.error.SecurityException;


public class CiphverV2Test {

	public static void main(String[] args) throws SecurityException {
		CipherV2 c = new CipherV2();
		System.out.println(c.encrypt("adminp", "v01"));
	}

}
