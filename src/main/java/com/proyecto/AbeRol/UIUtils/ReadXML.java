package com.proyecto.AbeRol.UIUtils;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;

public class ReadXML {

    public static String getServerDomain(Document doc, XPath xpath) {
        String url = null;
        try {
            XPathExpression expr =
                xpath.compile("/url/server/text()");
            url = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return url;
    }
    public static String getDataBase(Document doc, XPath xpath) {
        String url = null;
        try {
            XPathExpression expr =
                xpath.compile("/url/database/text()");
            url = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return url;
    }
    public static String getUsername(Document doc, XPath xpath) {
        String url = null;
        try {
            XPathExpression expr =
                xpath.compile("/url/username/text()");
            url = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return url;
    }
    public static String getpassword(Document doc, XPath xpath) {
        String url = null;
        try {
            XPathExpression expr =
                xpath.compile("/url/password/text()");
            url = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return url;
    }
}