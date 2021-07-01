package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class Handler extends DefaultHandler {
    private final Set<String> uniqueModifications = new HashSet<>();

    public int getUniqueCount() {
        return uniqueModifications.size();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("modification")) {
            final String thisAttribute = attributes.getValue("name");
            uniqueModifications.add(thisAttribute.trim());
        }
    }
}
