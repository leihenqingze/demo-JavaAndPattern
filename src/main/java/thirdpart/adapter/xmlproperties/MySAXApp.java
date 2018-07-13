package thirdpart.adapter.xmlproperties;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileReader;
import java.io.IOException;

public class MySAXApp extends DefaultHandler {

    public MySAXApp() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument()");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument()");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.printf("characters()");
        for (int i = start; i < start + length; i++) {
            System.out.println(ch[i]);
        }
    }

    public static void main(String[] args) throws SAXException, IOException {
        String path = Thread.currentThread()
                .getContextClassLoader()
                .getResource("")
                .getPath()
                + "/thirdpart.adapter.xmlproperties/sax.xml";
        XMLReader xr = XMLReaderFactory.createXMLReader();
        MySAXApp handler = new MySAXApp();
        xr.setContentHandler(handler);
        xr.setErrorHandler(handler);

        FileReader fr = new FileReader(path);
        xr.parse(new InputSource(fr));
    }

}