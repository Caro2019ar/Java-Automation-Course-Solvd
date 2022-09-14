package br.caro.stax.buffered;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLStreamHandlerBuffered {
    public StringBuffer processXMLFile(File xmlFile) throws FileNotFoundException, XMLStreamException {

        StringBuffer rawXml = new StringBuffer();
        XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xmlFile));
        while(xmlStreamReader.hasNext()){
            switch (xmlStreamReader.next()){
                case XMLStreamConstants.START_ELEMENT:
                    rawXml.append("<" + xmlStreamReader.getLocalName()+">");
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if(!xmlStreamReader.isWhiteSpace()){
                    rawXml.append(xmlStreamReader.getText());
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    rawXml.append("</" + xmlStreamReader.getLocalName()+">");
                    break;
            }
        }
    return rawXml;
    }
}
