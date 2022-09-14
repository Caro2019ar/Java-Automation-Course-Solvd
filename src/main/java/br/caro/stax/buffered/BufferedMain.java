package br.caro.stax.buffered;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;

public class BufferedMain {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, TransformerException {
        System.out.println(BufferedMain.transformXML(3, new XMLStreamHandlerBuffered().processXMLFile(new File("./teachplats.xml")).toString()));
        //System.out.println(new XMLStreamHandlerBuffered().processXMLFile(new File("teachplats.xml")).toString());
    }
    public static String transformXML(int indentation, String rawXML) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", indentation);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult streamResult = new StreamResult(new StringWriter());
        transformer.transform(new StreamSource(new StringReader(rawXML)), streamResult);
        return streamResult.getWriter().toString();
    }
}
