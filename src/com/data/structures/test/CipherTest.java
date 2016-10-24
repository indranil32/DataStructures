package com.data.structures.test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;



public class CipherTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
		Security.addProvider(new BouncyCastleProvider());
		Base64 b64 = new Base64();
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
        SecretKeySpec key = new SecretKeySpec(getKeyBytes(), "AES");
        /*cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] ePwdBytes = b64.decode("gMWlxF/GDtZSSm771XqVITlR/YsdkONwCObMGQj7lc8=");
        byte[] plainText = new byte[cipher.getOutputSize(ePwdBytes.length)];
        int ptLength = cipher.update(ePwdBytes, 0, ePwdBytes.length, plainText, 0);
        ptLength += cipher.doFinal(plainText, ptLength);
        System.out.println(new String(plainText).trim());
        */
        
        //byte[] input = "edhCdUZsWYzAEOTjcEfF".getBytes();
        byte[] input = "san_sit_singtel_mdms_read".getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
        int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);
        byte[] b64Text = b64.encode(cipherText);
        System.out.println(new String(b64Text));
	}
	
	private static byte[] getKeyBytes()
    {
        byte[] res =
        {
            (byte) 0xde,
            (byte) 0xf2,
            (byte) 0x03,
            (byte) 0x23,
            (byte) 0x51,
            (byte) 0xa4,
            (byte) 0x05,
            (byte) 0x74,
            (byte) 0x2a,
            (byte) 0xcf,
            (byte) 0x84,
            (byte) 0x99,
            (byte) 0x24,
            (byte) 0x0d,
            (byte) 0xa9,
            (byte) 0x85
        };
        return res;
    }

}
