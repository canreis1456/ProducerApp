package com.producer.producerapp.Model;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import com.producer.producerapp.Producer.ProducerController;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class EntityGenerator{

    public static String CurName = "";
    public static String ForexBuying = "";
    public static String ForexSelling = "";
    public static String BanknoteBuying = "";
    public static String BanknoteSelling = "";

    public void EntityGen() {
        ProducerController pc = new ProducerController();


        File file = new File("C:\\Users\\can.kilic\\Desktop\\ProducerConsumer\\today.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        }
        Document doc = null;
        try {
            doc = db.parse(file);
        } catch (SAXException | IOException ex) {
            throw new RuntimeException(ex);
        }
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("Currency");
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;


                CurName = "" + eElement.getElementsByTagName("CurrencyName").item(0).getTextContent();
                ForexBuying = "" + eElement.getElementsByTagName("ForexBuying").item(0).getTextContent();
                ForexSelling = "" + eElement.getElementsByTagName("ForexSelling").item(0).getTextContent();
                BanknoteBuying = "" + eElement.getElementsByTagName("BanknoteBuying").item(0).getTextContent();
                BanknoteSelling = "" + eElement.getElementsByTagName("BanknoteSelling").item(0).getTextContent();
                CurrencyNameMethod(CurName);
                ForexBuyingMethod(ForexBuying);
                ForexSellingMethod(ForexSelling);
                BanknoteBuyingMethod(BanknoteBuying);
                BanknoteSellingMethod(BanknoteSelling);


/*
                System.out.println("Currency Name: " + eElement.getElementsByTagName("CurrencyName").item(0).getTextContent());
                System.out.println("Forex Buying: " + eElement.getElementsByTagName("ForexBuying").item(0).getTextContent());
                System.out.println("Forex Selling: " + eElement.getElementsByTagName("ForexSelling").item(0).getTextContent());
                System.out.println("BanknoteBuying: " + eElement.getElementsByTagName("BanknoteBuying").item(0).getTextContent());
                System.out.println("BanknoteSelling: " + eElement.getElementsByTagName("BanknoteSelling").item(0).getTextContent());
                 */
            }
        }
    }
    public static String CurrencyNameMethod(String a)
    {
        return a;
    }
    public static String ForexBuyingMethod(String a)
    {
        return a;
    }
    public static String ForexSellingMethod(String a)
    {
        return a;
    }
    public static String BanknoteBuyingMethod(String a)
    {
        return a;
    }
    public static String BanknoteSellingMethod(String a)
    {
        return a;
    }

}
