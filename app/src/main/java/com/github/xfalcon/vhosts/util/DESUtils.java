package com.github.xfalcon.vhosts.util;

import android.text.TextUtils;
import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DESUtils {
    private static final String KEY = "Lerist.T";
    public DESUtils(){
        super();
    }
    /** DES加密
     * @param str 要加密的内容
     */
    public String getDES(String str){
        if(TextUtils.isEmpty(str)){
            return null;
        }
        try {
            return Base64.encodeToString(desEncrypt(str, KEY), Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static byte[] desEncrypt(String str, String key) throws Exception {
        if (str == null || key == null)
            return null;
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "DES"));
        byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
        return bytes;
    }
}
