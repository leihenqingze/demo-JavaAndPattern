package thirdpart.adapter.xmlproperties;

import org.xml.sax.SAXException;

import java.io.*;
import java.util.Properties;

public class XMLProperties extends Properties {

    XMLParser p = null;

    @Override
    public synchronized void load(InputStream in) throws IOException {
        try {
            p = new XMLParser(in, this);
        } catch (SAXException e) {
            throw new IOException(e.getMessage());
        }
    }

    public synchronized void load(File file) throws SAXException, IOException {
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        XMLParser p = null;
        try {
            p = new XMLParser(in, this);
        } catch (SAXException e) {
            System.out.println(e);
            throw e;
        }
    }

    @Override
    public void save(OutputStream out, String comments) {
        try {
            store(out, comments);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void store(OutputStream out, String comments) throws IOException {
        PrintWriter wout = new PrintWriter(out);
        wout.println("<?xml version='1.0' encoding='UTF-8'?>");
        if (null != comments) {
            wout.println("<!--" + comments + "-->");
        }

    }
}
