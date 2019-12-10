package dom;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dom4JUtil {

    private static final Logger log = LoggerFactory.getLogger(Dom4JUtil.class);

    /**
     * 修改xml中某个标签的属性值
     * @param tableName
     */
    public void modifyXML(String tableName) {
        log.info("开始修改配置文件：generatorConfig.xml");
        try {
            SAXReader sr = new SAXReader(); // 需要导入jar包:dom4j
            Document document = sr.read("generatorConfig.xml");
            Element table = document.getRootElement().element("context").element("table");
            Attribute OldTableName = table.attribute("tableName");
            Attribute OldDomainObjectName = table.attribute("domainObjectName");
            if(!OldTableName.equals(tableName)){
                OldTableName.setText(tableName);
                OldDomainObjectName.setText(StringUtil.convertToCamelCase(tableName));
            }
            saveDocument(document, new File("generatorConfig.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改完后保存文件
     * @param document
     * @param xmlFile
     */
    private void saveDocument(Document document, File xmlFile){
        try {
            Writer osWrite = new OutputStreamWriter(new FileOutputStream(xmlFile));// 创建输出流
            OutputFormat format = OutputFormat.createPrettyPrint(); // 获取输出的指定格式
            format.setEncoding("UTF-8");// 设置编码 ，确保解析的xml为UTF-8格式
            XMLWriter writer = new XMLWriter(osWrite, format);// XMLWriter
            // 指定输出文件以及格式
            writer.write(document);// 把document写入xmlFile指定的文件(可以为被解析的文件或者新创建的文件)
            writer.flush();
            writer.close();
            log.info("修改完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getXmlTableValue(String xmlFileName) {
        return readStringXmlOut(new Dom4JUtil().xmlToString(xmlFileName));
    }

    //将xml转换成字符串
    private String xmlToString(String xmlFileName) {
        SAXReader saxReader = new SAXReader();
        Document document;
        String xmlString;
        try {
            document = saxReader.read(new File(xmlFileName));
            xmlString = document.asXML();
        } catch (Exception e) {
            e.printStackTrace();
            xmlString = "";
        }
        return xmlString;
    }

    /**
     * @param xml
     * @return Map
     * @description 将xml字符串转换成map
     */
    private static Map<String, String> readStringXmlOut(String xml) {
        Map<String, String> map = new HashMap<>();
        Document doc;
        try {
            // 将字符串转为XML
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            Iterator<Element> iter = rootElt.elementIterator("context");
            while (iter.hasNext()) {
                Element recordEle = iter.next();
                Iterator<Element> iters = recordEle.elementIterator("table");
                while (iters.hasNext()) {
                    Element itemEle = iters.next();
                    map.put("tableName", itemEle.attributeValue("tableName"));
                    map.put("domainObjectName", itemEle.attributeValue("domainObjectName"));
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }
}
