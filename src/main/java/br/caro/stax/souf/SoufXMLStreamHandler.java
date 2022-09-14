package br.caro.stax.souf;

import javax.xml.stream.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SoufXMLStreamHandler {
    public void processXMLFile(File xmlFile) throws FileNotFoundException, XMLStreamException {
        XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xmlFile));
        while(xmlStreamReader.hasNext()){
            switch (xmlStreamReader.next()){
                case XMLStreamConstants.START_ELEMENT:
                    System.out.printf("<" +xmlStreamReader.getLocalName()+">");
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.printf(" " +xmlStreamReader.getText());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.printf("</ " +xmlStreamReader.getLocalName()+">");
                    break;
            }
        }

    }
}
