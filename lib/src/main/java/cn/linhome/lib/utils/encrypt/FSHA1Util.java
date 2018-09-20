package cn.linhome.lib.utils.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FSHA1Util
{
    /**
     * SHA1算法
     *
     * @param value
     * @return
     */
    public static String SHA1(String value)
    {
        String result;
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(value.getBytes());
            byte[] bytes = digest.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++)
            {
                String hex = Integer.toHexString(bytes[i] & 0XFF);
                if (hex.length() == 1)
                {
                    sb.append('0');
                }
                sb.append(hex);
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e)
        {
            result = null;
        }
        return result;
    }

}
