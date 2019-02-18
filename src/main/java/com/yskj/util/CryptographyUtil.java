package com.yskj.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * ���ܹ���
 * @author Administrator
 *
 */
public class CryptographyUtil {

	
	/**
	 * Md5����
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}
	
	public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//		String password="123456";
		
//		System.out.println("Md5���ܣ�"+CryptographyUtil.md5(password, "java1234"));

		//**************************����******************************

		//Cipher���ṩ���ܵ��࣬"AES" ��ʾ����ʹ�õ��㷨
		Cipher cipher = Cipher.getInstance("AES");

		//SecretKey��������������������һ����Կ
		SecretKey key = KeyGenerator.getInstance("AES").generateKey();

		//����Կ��ʼ���� Cipher��   Cipher.ENCRYPT_MODE ����ģʽ
		cipher.init(Cipher.ENCRYPT_MODE, key);

		//��"aaa"ִ�м��ܵĲ���,����ֵΪ���ܺ�Ľ��
		byte[] result = cipher.doFinal("aaa".getBytes());

		System.out.println(new String(result));



		//**************************����******************************

		//���ܵ�ʱ��Ҫ��ԭ�����ܵ���Կ
		cipher.init(Cipher.DECRYPT_MODE, key);

		//���ܣ��õ�����ǰ���ַ���
		result = cipher.doFinal(result);

		System.out.println(new String(result));
	}
}
