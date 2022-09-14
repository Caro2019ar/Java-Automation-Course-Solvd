package br.caro.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser {
    public static void main(String[] args)  {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc= builder.parse("teachplats.xml");
            NodeList usersList = doc.getElementsByTagName("user");
            for(int i=0;i< usersList.getLength();i++){
                Node u = usersList.item(i);
                if (u.getNodeType()==Node.ELEMENT_NODE){
                    Element user = (Element) u;
                    String id = user.getAttribute("id");
                    NodeList nameList = user.getChildNodes();
                    for(int j=0; j< nameList.getLength();j++){
                        Node n = nameList.item(j);
                        if(n.getNodeType()==Node.ELEMENT_NODE){
                            Element name = (Element) n;
                            System.out.println("User id: "+ id+" : "+ name.getTagName() + "  - " + name.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
}
