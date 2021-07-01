package org.example;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        if (args.length > 0) {
            final Handler handler = new Handler();
            final File file = new File(args[0]);
            final SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            final SAXParser parser = parserFactory.newSAXParser();
            parser.parse(file, handler);
            System.out.println(handler.getUniqueCount());
        } else {
            System.out.println("XML file argument required");
        }
    }
}
