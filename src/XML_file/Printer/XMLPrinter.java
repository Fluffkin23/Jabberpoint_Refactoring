package XML_file.Printer;

import Presentation.Presentation;
import Slide.Slide;
import XML_file.Reader.Reader;
import XML_file.Reader.XMLReader;
import XML_file.XMLAccessor;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLPrinter extends Printer{
    // XML tag names
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDE = "slide";
    protected static final String ITEM = "item";

    @Override // Prints the slide element from the XML file to the presentation object
    public void printSlideElement(Presentation presentation, Element element)
    {
        XMLAccessor xmlAccessor = new XMLAccessor(); // Create XMLAccessor and XMLReader objects
        Reader XmlReader = new XMLReader();

        // Initialize variables for slide and item iteration
        int slideNumber;
        int maxItem;
        int itemNumber;
        int totalSlides;

        presentation.setTitle(xmlAccessor.getTitle(element, SHOWTITLE)); // Set the presentation title from the showtitle tag in the XML file
        NodeList slides = element.getElementsByTagName(SLIDE);  // Get all slide elements from the XML file

        // Iterate through each slide in the XML file
        totalSlides = slides.getLength();
        for(slideNumber = 0;slideNumber < totalSlides; slideNumber++)
        {
            // Get the current slide element
            Element xmlSlide = (Element) slides.item(slideNumber);
            Slide slide = new Slide();

            // Set the slide title from the title tag in the XML file
            slide.setTitle(xmlAccessor.getTitle(xmlSlide, SLIDETITLE));
            presentation.append(slide);

            // Get all item elements in the current slide element
            NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
            maxItem = slideItems.getLength();

            // Iterate through each item in the current slide element
            for(itemNumber = 0; itemNumber < maxItem; itemNumber++)
            {
                Element item = (Element) slideItems.item(itemNumber); // Get the current item element
                xmlAccessor.loadSlideItem(slide, item);  // Load the item into the slide using the XMLAccessor object
            }
        }
    }
}
