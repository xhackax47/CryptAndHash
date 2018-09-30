package services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES {
	
	public static void generateKey(String outputFileName) {
		try {
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecureRandom random = new SecureRandom();
			keygen.init(random);
			SecretKey key = keygen.generateKey();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outputFileName));
			out.writeObject(key);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void encryptFile(String inputFileName, String outputFileName, String keyFileName, int mode) {
		InputStream in = null;
		OutputStream out = null;
		try {
			ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(keyFileName));
			Key key = (Key) keyIn.readObject();
			keyIn.close();

			in = new FileInputStream(inputFileName);
			out = new FileOutputStream(outputFileName);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(mode, key);

			crypt(in, out, cipher);
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void crypt(InputStream in, OutputStream out, Cipher cipher)
			throws IOException, GeneralSecurityException {
		int blockSize = cipher.getBlockSize();
		int outputSize = cipher.getOutputSize(blockSize);
		byte[] inBytes = new byte[blockSize];
		byte[] outBytes = new byte[outputSize];

		int inLength = 0;
		boolean done = false;
		while (!done) {
			inLength = in.read(inBytes);
			if (inLength == blockSize) {
				int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
				out.write(outBytes, 0, outLength);
			} else
				done = true;
		}

		if (inLength > 0)
			outBytes = cipher.doFinal(inBytes, 0, inLength);
		else
			outBytes = cipher.doFinal();

		out.write(outBytes);
	}

}
