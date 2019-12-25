package utils;

/**
 * @Author ZhangGJ
 * @Date 2019/12/24 19:57
 */
public class Test {

    /**
     * app的secret，加解密使⽤，开放平台获得
     */
    private static final String SECRET = "8cf860c0-30b7-4357-a104-fa627c59085d";

    public String encryption(String json) throws Exception {
//        String reqJson="{\"eventType\":\"corpAuth\",\"tenantId\":\"tenant\",\"timestamp\":\"1565167553\"}";
        String ivStr = WeLinkUtil.createIV(16);
        String result = ivStr + WeLinkUtil.encryptByGcm(json,SECRET, ivStr);
        System.out.println("=======================密文：" + result);
        return result;
    }

    public String decrypt(String ciphertext) throws Exception {
        String ivStr = WeLinkUtil.createIV(16);
        int len = ciphertext.length();
        String result = WeLinkUtil.decryptByGcm(ciphertext.substring(ivStr.length(), len), SECRET, ciphertext.substring(0, ivStr.length()));
        System.out.println("=======================明文：" + result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        new Test().encryption("{\"eventType\":\"corpAuth\",\"tenantId\":\"tenant\",\"timestamp\":\"1565167553\"}");
        new Test().decrypt(new Test().encryption("{\"eventType\":\"corpAuth\",\"tenantId\":\"tenant\",\"timestamp\":\"1565167553\"}"));
    }
}
