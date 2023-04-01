package XML_file.Reader;

import Presentation.Presentation;
import XML_file.Builder.JDOM_BUILDER;
import XML_file.Printer.Printer;
import XML_file.Printer.XMLPrinter;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static XML_file.XMLAccessor.PCE;


public class XMLReader extends Reader {

    public static final String DEMO_NAME = "Demo presentation";// The name of the demo presentation
    public static final String DEFAULT_EXTENSION = ".xml"; // The default file extension for XML files

    @Override // Loads a presentation from an XML file
    public void loadFile(Presentation presentation, String filename) throws IOException
    {
        // Initialize variables for JDOM and printing
        Element element = null;
        Printer xmlPrinter = new XMLPrinter();
        JDOM_BUILDER jdom_builder = new JDOM_BUILDER();
        try // Attempt to build the JDOM element from the XML file
        {
            element = jdom_builder.builder(filename);
        }
        catch (IOException iox)
        {
            System.err.println(iox.toString());
        }
        catch (SAXException sax)
        {
            System.err.println(sax.getMessage());
        }
        catch (ParserConfigurationException pcx)
        {
            System.err.println(PCE);
        }
        if(element != null) // If the element is not null, print the slide element

            xmlPrinter.printSlideElement(presentation,element);
    }
}
