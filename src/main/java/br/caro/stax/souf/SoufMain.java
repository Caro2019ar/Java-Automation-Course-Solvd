package br.caro.stax.souf;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

public class SoufMain {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        SoufXMLStreamHandler souf = new SoufXMLStreamHandler();
        souf.processXMLFile(new File("teachplats.xml"));

    }
}
