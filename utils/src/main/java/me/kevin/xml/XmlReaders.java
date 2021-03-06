package me.kevin.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Kevin
 * @description
 * @date 2017/1/19
 */
public class XmlReaders {
    private static DocumentBuilder builder;
    private static String DFT_ENCODING = "UTF-8";

    static {
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("init xml failed.");
        }
    }

    private Document document;

    public static XmlReaders create(String xml) {
        return create(xml, DFT_ENCODING);
    }

    public static XmlReaders create(String xml, String encoding) {
        try {
            return create(new ByteArrayInputStream(xml.getBytes(encoding)));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("xml create fail");
        }
    }

    public static XmlReaders create(InputStream inputStream) {
        XmlReaders readers = new XmlReaders();
        try {
            readers.document = builder.parse(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("xml create fail", e);
        }
        return readers;
    }

    /**
     * 获取指定标签节点对象
     *
     * @param tagName
     * @return
     */
    public Node getNode(String tagName) {
        NodeList nodes = document.getElementsByTagName(tagName);
        if (nodes.getLength() <= 0) {
            return null;
        }
        return nodes.item(0);
    }

    /**
     * 获取指定标签节点列表
     *
     * @param tagName
     * @return
     */
    public NodeList getNodes(String tagName) {
        NodeList nodes = document.getElementsByTagName(tagName);
        if (nodes.getLength() <= 0) {
            return null;
        }
        return nodes;
    }

    /**
     * 获取某个节点的文本内容，若有多个该节点，只会返回第一个
     *
     * @param tagName 标签名
     * @return 文本内容，或NULL
     */
    public String getNodeStr(String tagName) {
        Node node = getNode(tagName);
        return node == null ? null : node.getTextContent();
    }

    /**
     * 获取某个节点的Integer，若有多个该节点，只会返回第一个
     *
     * @param tagName 标签名
     * @return Integer值，或NULL
     */
    public Integer getNodeInt(String tagName) {
        String nodeContent = getNodeStr(tagName);
        return nodeContent == null ? null : Integer.valueOf(nodeContent);
    }

    /**
     * 获取某个节点的Long值，若有多个该节点，只会返回第一个
     *
     * @param tagName 标签名
     * @return Long值，或NULL
     */
    public Long getNodeLong(String tagName) {
        String nodeContent = getNodeStr(tagName);
        return nodeContent == null ? null : Long.valueOf(nodeContent);
    }

    /**
     * 获取某个节点的Float，若有多个该节点，只会返回第一个
     *
     * @param tagName 标签名
     * @return Float值，或NULL
     */
    public Float getNodeFloat(String tagName) {
        String nodeContent = getNodeStr(tagName);
        return nodeContent == null ? null : Float.valueOf(nodeContent);
    }
}
