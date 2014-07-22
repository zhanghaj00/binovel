package com.binovel.util;


/**
 * filename��com.yilucaifu.utils.Des3.java
 * 
 * @author: zhangyong
 * @time: 2014-2-11����4:11:01
 */
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * 3DES���ܹ�����
 */
public class Des3 {
	// // ��Կ
	// private final static String secretKey = ConfigUtil.getDESKey();
	// // ����
	// private final static String iv = ConfigUtil.getDESIv();

	// ��Կ
	 private final static String secretKey = "uUPCHtw3oeuD4z8qUfjNOg==";
	// ����
	private final static String iv = "01234567";

	// �ӽ���ͳһʹ�õı��뷽ʽ
	private final static String encoding = "utf-8";

	/**
	 * 3DES����
	 * 
	 * @param plainText
	 *            ��ͨ�ı�
	 * @return
	 * @throws Exception
	 */
	public static String encode(String plainText) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		return Base64.encode(encryptData);
	}

	/**
	 * 3DES����
	 * 
	 * @param encryptText
	 *            �����ı�
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String encryptText) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

		byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));
		return new String(decryptData, encoding);
	}

	public static void main(String[] args) throws Exception {
		Integer a = null ;
		System.out.println(a);
		// System.out.println("13068119880705121X".toUpperCase());
//		System.out.println(encode("13880319057"));
//		System.out.println(decrypt("WhPOy9fCqyReJcBytrreA=="));
	}
}

