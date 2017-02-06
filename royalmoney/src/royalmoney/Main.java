/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package royalmoney;

/**
 *
 * @author fred
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {
  public static void main(String[] argv) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setValidating(true);
    factory.setExpandEntityReferences(false);
    Document doc = factory.newDocumentBuilder().parse(new File("test.xml"));
    Element element = doc.getElementById("key1");
    element = doc.createElement("root");
    doc.appendChild(element);

    Element element2 = doc.createElement("item");
    element.insertBefore(element2, element.getFirstChild().getNextSibling());

  }
}