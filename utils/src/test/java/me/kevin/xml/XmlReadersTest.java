package me.kevin.xml;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 * @author Kevin
 * @description
 * @date 2017/1/20
 */
public class XmlReadersTest {

    @Test
    public void xmlReadersTest() {
        String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "<return_msg><![CDATA[OK]]></return_msg>\n" +
                "<appid><![CDATA[wxe37]]></appid>\n" +
                "<mch_id><![CDATA[137]]></mch_id>\n" +
                "<long><![CDATA[1370000000]]></long>\n" +
                "<float><![CDATA[137.123456]]></float>\n" +
                "<nonce_str><![CDATA[AYySchVKar2W0Ynb]]></nonce_str>\n" +
                "<sign><![CDATA[C2DD53C14B94761843CEA701254B8E4]]></sign>\n" +
                "<result_code><![CDATA[FAIL]]></result_code>\n" +
                "<err_code><![CDATA[OUT_TRADE_NO_USED]]></err_code>\n" +
                "<err_code_des><![CDATA[商户订单号重复]]></err_code_des>\n" +
                "</xml>";

        XmlReaders xmlReaders = XmlReaders.create(xml);
        assertThat(xmlReaders.getNodeStr("return_msg")).isEqualToIgnoringCase("OK");
        assertThat(xmlReaders.getNodeInt("mch_id")).isEqualTo(137);
        assertThat(xmlReaders.getNodeLong("long")).isEqualTo(1370000000L);
        assertThat(xmlReaders.getNodeFloat("float")).isEqualTo(137.123456f);

    }
}
