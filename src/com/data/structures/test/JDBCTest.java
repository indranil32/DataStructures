package com.data.structures.test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class JDBCTest {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@san-dev-ora-03:1521:SANSIT101";
	private static final String DB_USER = "san_sit_singtel54_mdms_crud";
	private static final String DB_PASSWORD = "K7uOmaHpggD222gIxmWepnCogqrJJ/eO1wrM4nFyzSk=";

	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
		try {

			callOracleStoredProcOUTParameter();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}
	
	private static void callOracleStoredProcOUTParameter() throws SQLException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {

		Connection dbConnection = null;
		CallableStatement callableStatement = null;

		String getDBUSERByUserIdSql = "{call FETCHDELTACONTENTMETA(?,?)}";

		try {
			dbConnection = getDBConnection();
			callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);

			callableStatement.setLong(1, 1);
			callableStatement.setLong(2, 100);

			// execute getDBUSERByUserId store procedure
			callableStatement.executeUpdate();

			/*String userName = callableStatement.getString(2);
			String createdBy = callableStatement.getString(3);
			Date createdDate = callableStatement.getDate(4);

			System.out.println("UserName : " + userName);
			System.out.println("CreatedBy : " + createdBy);
			System.out.println("CreatedDate : " + createdDate);*/
			System.out.println("done");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private static Connection getDBConnection() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
				DB_CONNECTION, DB_USER, decrypt(DB_PASSWORD));
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

	private static String decrypt(String arg) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, ShortBufferException, IllegalBlockSizeException, BadPaddingException {
		Security.addProvider(new BouncyCastleProvider());
		Base64 b64 = new Base64();
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding", "BC");
        SecretKeySpec key = new SecretKeySpec(getKeyBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] ePwdBytes = b64.decode(arg);
        byte[] plainText = new byte[cipher.getOutputSize(ePwdBytes.length)];
        int ptLength = cipher.update(ePwdBytes, 0, ePwdBytes.length, plainText, 0);
        ptLength += cipher.doFinal(plainText, ptLength);
        System.out.println(new String(plainText).trim());
        return new String(plainText).trim();
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
