package com.okdeer.mall.common;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * .ClassName: DES(des加密解密类) <br/>
 * date: 2015年7月31日 上午11:28:51 <br/>
 * @author tangjh
 */
public class DESUtils {

    // DES加密key
    public static final String DES_KEY = "3B827D20";

    /**
     * @param args 
     * @throws Exception  
     */  
    public static void main(String[] args) throws Exception {  
        String key = DESUtils.DES_KEY;
        String text = "star010";  
        String result1 = DESUtils.encrypt(text,key);
        String result2 = DESUtils.decrypt(result1, key);
        System.out.println(result1);  
        System.out.println(result2);  
    }  
    
    //解密
    public static String decrypt(String message, String key)
            throws Exception {
        byte[] bytesrc = Base64.decode(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);
        return new String(retByte);
    }
 
    // 加密
    public static String encrypt(String message, String key)
            throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encryptbyte = cipher.doFinal(message.getBytes());
        return new String(Base64.encode(encryptbyte));
    }

}
