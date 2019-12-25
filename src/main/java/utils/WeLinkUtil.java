package utils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/**
 * 加密和解密的示例代码
 */
public class WeLinkUtil{
    private static final String ALGORITHM = "AES";
    private static final String defaultCharset = "UTF-8";
    private static final String KEY_GCM_AES = "AES/GCM/NoPadding";
    private static final int AES_KEY_SIZE = 128;
    /**
     * ⽣成length字节的偏移量IV
     * createIV的功能<br>
     *
     * @param length
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String createIV(int length) throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[length];
        random.nextBytes(salt);
        return encodeToBase64(salt);
    }
    /**
     * 解密——使⽤⾃定义的加密key
     *
     * @param data
     * @param key
     * @param ivStr
     * @return
     * @throws Exception
     */
    public static String decryptByGcm(String data, String key, String ivStr) throws
            Exception {
        Cipher cipher = Cipher.getInstance(KEY_GCM_AES);
        byte[] iv = decodeFromBase64(ivStr);
        SecretKeySpec keySpec = getSecretKeySpec(key);
        cipher.init(2, keySpec, new GCMParameterSpec(AES_KEY_SIZE, iv));
        byte[] content = decodeFromBase64(data);
        byte[] result = cipher.doFinal(content);
        return new String(result);
    }
    /**
     * 加密——使⽤⾃定义的加密key
     *
     * @param data
     * @param key
     * @param ivStr
     * @return
     * @throws Exception
     */
    public static String encryptByGcm(String data, String key, String ivStr) throws
            Exception {
        Cipher cipher = Cipher.getInstance(KEY_GCM_AES);
        byte[] iv = decodeFromBase64(ivStr);
        SecretKeySpec keySpec = getSecretKeySpec(key);
        cipher.init(1, keySpec, new GCMParameterSpec(AES_KEY_SIZE, iv));
        byte[] content = data.getBytes(defaultCharset);
        byte[] result = cipher.doFinal(content);
        return encodeToBase64(result);
    }
    private static byte[] decodeFromBase64(String data) {
        return Base64.getDecoder().decode(data);
    }
    private static String encodeToBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
    /**
     * 公共使⽤，获取SecretKeySpec
     *
     * @param key
     * @return
     */
    private static SecretKeySpec getSecretKeySpec(String key) {
        SecretKeySpec keySpec = null;
        try {
            //1.构造密钥⽣成器，指定为AES算法,不区分⼤⼩写
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
            //2.根据ecnodeRules规则初始化密钥⽣成器
            //⽣成⼀个128位的随机源,根据传⼊的字节数组
            SecureRandom secureRandom=
                    SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes(defaultCharset));
            kgen.init(AES_KEY_SIZE, secureRandom);
            //3.产⽣原始对称密钥
            SecretKey secretKey = kgen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] enCodeFormat = secretKey.getEncoded();
            //5.根据字节数组⽣成AES密钥
            keySpec = new SecretKeySpec(enCodeFormat, ALGORITHM);
        } catch (Exception e) {
            System.out.println("To do get SecretKeySpec exception!");
        }
        return keySpec;
    }
    public static void main(String[] args) throws Exception {
        String secret = "8cf860c0-30b7-4357-a104-fa627c59085d";//app的secret，加解密使⽤，开放平台获得
        String reqJson="{\"eventType\":\"corpAuth\",\"tenantId\":\"tenant\",\"timestamp\":\"1565167553\"}";
        String respJson="{\"timestamp\":\"1565167553\",\"msg\":\"success\"}";
        System.out.println("[请求Json]："+reqJson);
        String ivStr = createIV(16);
        String reqStr=encryptByGcm(reqJson,secret, ivStr);
        System.out.println("[请求密⽂]：" + ivStr + reqStr);
        String reqJsonAfterDecrypt=decryptByGcm(reqStr, secret, ivStr);
        System.out.println("[请求密⽂解析后]："+reqJsonAfterDecrypt);
        String ivStr2 = createIV(16);
        System.out.println("[响应Json]："+respJson);
        String respStr=encryptByGcm(respJson,secret, ivStr2);
        System.out.println("[响应密⽂]：" + ivStr2 + respStr);
        String respJsonAfterDecrypt=decryptByGcm(respStr,secret, ivStr2);
        System.out.println("[响应密⽂解析后]："+respJsonAfterDecrypt);
    }
}
/*
[请求Json]：
{"eventType":"corpAuth","tenantId":"tenant","timestamp":"1565167553"}
[请求密⽂]：
PGkTPQrrTwlqBEu5pzPyxw==3BWfWmYTj67h5qdD4og6el7GrxaXHqm0gndcv
/
X8zK6j9ablMO+571LbjQWJJogcIunLPkJf9Yo4iHAP+QIB3KcihrLj3IHrRhbE8Ku
QvzCPVAo=
[请求密⽂解析后]：
{"eventType":"corpAuth","tenantId":"tenant","timestamp":"1565167553"}
[响应Json]：{"timestamp":"1565167553","msg":"success"}
[响应密⽂]：
5wwd5oVCbwgvaGzE2W9vPg==kdG1FYbicMlNY77ALZdBtC1ylS0aF+jzff8iyq2
Ro1SJqUQCTAG96hLp+A7OyX/Im8IoFQ1XtfE=
[响应密⽂解析后]：{"timestamp":"1565167553","msg":"success"}
*/