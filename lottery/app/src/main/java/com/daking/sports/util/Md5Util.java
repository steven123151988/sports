package com.daking.sports.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description:
 * Data：2018/4/10-16:16
 * steven
 */
public class Md5Util {
    public static String HEXAndMd5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            try {
                md.update(plainText.getBytes("UTF8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer(200);
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset] & 0xff;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {

            return null;
        }
    }
}
