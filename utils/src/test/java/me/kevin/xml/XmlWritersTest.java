package me.kevin.xml;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author Kevin
 * @description
 * @date 2017/1/20
 */
public class XmlWritersTest {

    @Test
    public void xmlWritersTest() {
        String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><mch_id>137</mch_id><long>1370000000</long><float>137.123456</float><beans><bean><![CDATA[bean1]]></bean><bean><![CDATA[bean2]]></bean></beans><beans><bean><![CDATA[bean1]]></bean></beans><beans><bean>1</bean></beans></xml>";

        XmlWriters xmlWriters = XmlWriters.create();
        String xmlResult = xmlWriters.element("return_code", "SUCCESS").element("mch_id", 137)
                .element("long", 1370000000).element("float", 137.123456)
                .element("beans", "bean", "bean1", "bean", "bean2")
                .element("beans","bean","bean1")
                .element("beans","bean",1)
                .build();
        assertThat(xmlResult).isEqualToIgnoringCase(xml);
    }
}
