package org.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

/**
 * Burn in Hell!!!!
 */
public class App {
    public static void main(@org.jetbrains.annotations.NotNull String[] args) throws ParserConfigurationException, SAXException, IOException {
        Handler handler = new Handler();
        File file = new File(args[0]);
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        parser.parse(file, handler);
//        System.out.println(handler.getUniqueCount());

    }
}
