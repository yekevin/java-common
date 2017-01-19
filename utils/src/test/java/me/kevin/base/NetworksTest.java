package me.kevin.base;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 * Created by Administrator on 2017/1/19.
 */
public class NetworksTest {
    @Test
    public void networksTest(){
        System.out.println(Networks.hostName());

        String ip = "8.8.8.8";
        int ipInt = 134744072;
        assertThat(ip).isEqualTo(Networks.num2Ip(ipInt));
        assertThat(ipInt).isEqualTo(Networks.ip2Num(ip));
    }
}
