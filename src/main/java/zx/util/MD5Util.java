package zx.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;

public class MD5Util {
	 public static String getMD5Str(String str) {
	        byte[] digest = null;
	        try {
	            MessageDigest md5 = MessageDigest.getInstance("md5");
	            digest  = md5.digest(str.getBytes("utf-8"));
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        //16�Ǳ�ʾת��Ϊ16������
	        String md5Str = new BigInteger(1, digest).toString(16);
	        return md5Str;
	    }


	 public static void main(String[] args) {
		 String md5 = MD5Util.getMD5Str("JavaEE");//JavaEEΪ���룺md5���ܺ�����ݣ�a1212a200973d24c465cfde2c3e6b5ed
		 System.out.println("MD5Util JavaEE = " + md5);
	}

}
