package me.kevin.base;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 * Created by Administrator on 2017/1/19.
 */
public class StringsTest {
    @Test
    public void stringsTest(){
        assertThat(Strings.isEmpty(null)).isTrue();
        assertThat(Strings.isEmpty("")).isTrue();
        assertThat(Strings.isEmpty("test")).isFalse();
    }
}
