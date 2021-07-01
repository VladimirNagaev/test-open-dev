package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Handler extends DefaultHandler {

    private List<String> modificationNames = new ArrayList<String>();
    private HashSet<String> uniqueModifications;

    private String thisElement;
    private  String thisAttribute;

    public List<String> getNames() {
        return modificationNames;
    }

    public HashSet<String> getUniqueModifications() {
        return uniqueModifications;
    }
    public int getUniqueCount() {
        return uniqueModifications.size();
    }

    @Override
    public void startDocument() {
        System.out.println("stat parsing...");
    }

    @Override
    public void endDocument() {
        System.out.println(uniqueModifications.size());
        System.out.println("... end parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
        thisAttribute = attributes.getValue("name");
    }

    @Override
    public void endElement(String namespace, String localName, String qname) throws SAXException {
        thisElement = "";
        thisAttribute = "";
    }

    @Override
    public void characters(char[] chars, int st, int en) {
        if (thisElement.equals("modification")) {
            String modifName = new String(chars, st, en);
            modificationNames.add(thisAttribute);
            uniqueModifications.add(thisAttribute);
            System.out.println(thisAttribute);
        }

    }

}
