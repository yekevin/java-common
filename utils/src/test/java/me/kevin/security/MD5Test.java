package me.kevin.security;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Kevin
 * @description
 * @date 2017/1/20
 */
public class MD5Test {

    @Test
    public void md5Test() {
        String sourceHello = "Hello";
        String sourceWorld = "World";

        String encodeHello = "8b1a9953c4611296a827abf8c47804d7";
        String encodeWorld = "f5a7924e621e84c9280a9a27e1bcb7f6";

        String helloMD5 = MD5.generate(sourceHello, false);
        String worldMD5 = MD5.generate(sourceWorld, false);

        Assertions.assertThat(helloMD5).isEqualToIgnoringCase(encodeHello);
        Assertions.assertThat(worldMD5).isEqualToIgnoringCase(encodeWorld);
    }
}
