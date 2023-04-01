package XML_file.Builder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/*
The JDOM_BUILDER class extends the abstract Builder class and provides an implementation for the builder method.
This method reads an XML file using JDOM and returns the root element of the document.
 */
public class JDOM_BUILDER extends Builder
{
    @Override
    public Element builder(String filename) throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(new File(filename)); // create a JDOM DOCUMENT
        return document.getDocumentElement();

    }
}
