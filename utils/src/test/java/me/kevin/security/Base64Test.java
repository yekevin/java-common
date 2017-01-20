package me.kevin.security;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author Kevin
 * @description
 * @date 2017/1/20
 */
public class Base64Test {

    @Test
    public void base64Test() throws UnsupportedEncodingException {
        String str = "Hello World!";
        String base64Str = "SGVsbG8gV29ybGQh";
        String encodeStr = Base64.encode(str.getBytes());
        String decodeStr = new String(Base64.decode(encodeStr));

        Assertions.assertThat(encodeStr).isEqualToIgnoringCase(base64Str);
        Assertions.assertThat(decodeStr).isEqualToIgnoringCase(str);
    }
}
