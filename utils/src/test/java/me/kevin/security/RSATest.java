package me.kevin.security;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * @author Kevin
 * @description
 * @date 2017/1/20
 */
public class RSATest {
    private String privateKey;
    private String publicKey;

    @Before
    public void init() {
        Map<String, Object> keyPair = RSA.initKey();
        privateKey = RSA.getPrivateKey(keyPair);
        publicKey = RSA.getPublicKey(keyPair);
    }

    @Test
    public void rsaTest() {
        String data = "RSA security data.";
        byte[] privateEncode = RSA.encryptByPrivateKey(data.getBytes(), privateKey);
        byte[] publicDecode = RSA.decryptByPublicKey(privateEncode, publicKey);

        byte[] publicEncode = RSA.encryptByPublicKey(data.getBytes(), publicKey);
        byte[] privateDecode = RSA.decryptByPrivateKey(publicEncode, privateKey);

        Assertions.assertThat(new String(publicDecode)).isEqualToIgnoringWhitespace(data);
        Assertions.assertThat(new String(privateDecode)).isEqualToIgnoringWhitespace(data);
    }
}
