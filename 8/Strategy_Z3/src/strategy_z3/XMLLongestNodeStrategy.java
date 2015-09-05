/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strategy_z3;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ja
 */
public class XMLLongestNodeStrategy implements DataAccessHandlerStrategy {
    
    protected File xml;
    protected String path;
    protected Node longest = null;
    
    protected class XMLDoc implements Data {
        Document d;
        
        public XMLDoc(Document d) {
            this.d = d;
        }
    }
    
    public XMLLongestNodeStrategy(String path) {
        this.path = path;
    }
    
    @Override
    public void connectToData() {
        xml = new File(path);
        if(!xml.exists())
            throw new IllegalArgumentException("File " + path + 
                    " doesn't exist.");
    }

    @Override
    public Data getDataViaConnection() {
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();
            return new XMLDoc(dBuilder.parse(xml));
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new RuntimeException("Cannot parse XML file " + path);
        }
    }

    @Override
    public void processData(Data d) {
        XMLDoc dd = (XMLDoc)d;
        Document doc = dd.d;
        if(doc.hasChildNodes())
            DFS(doc.getChildNodes());
        
        System.out.println("Longest node has name: " + longest.getNodeName());
    }
    
    private void DFS(NodeList nlist) {
        for(int i = 0; i < nlist.getLength(); i++) {
            Node n = nlist.item(i);
            if(longest == null)
                longest = n;
            if(n.getNodeName().length() > longest.getNodeName().length())
                longest = n;
            
            if(n.hasChildNodes())
                DFS(n.getChildNodes());
        }
        
    }

    @Override
    public void closeConnection() {
        // do nothing...?
    }
    
}