package com.yskj.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具
 * @author Administrator
 *
 */
public class CryptographyUtil {

	
	/**
	 * Md5加密
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}
	
	public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//		String password="123456";
		
//		System.out.println("Md5加密："+CryptographyUtil.md5(password, "java1234"));

		//**************************加密******************************

		//Cipher：提供加密的类，"AES" 表示加密使用的算法
		Cipher cipher = Cipher.getInstance("AES");

		//SecretKey密码生成器，用于生成一个密钥
		SecretKey key = KeyGenerator.getInstance("AES").generateKey();

		//用密钥初始化此 Cipher，   Cipher.ENCRYPT_MODE 加密模式
		cipher.init(Cipher.ENCRYPT_MODE, key);

		//对"aaa"执行加密的操作,返回值为加密后的结果
		byte[] result = cipher.doFinal("aaa".getBytes());

		System.out.println(new String(result));



		//**************************解密******************************

		//解密的时候，要用原来加密的密钥
		cipher.init(Cipher.DECRYPT_MODE, key);

		//解密，得到加密前的字符串
		result = cipher.doFinal(result);

		System.out.println(new String(result));
	}
}
