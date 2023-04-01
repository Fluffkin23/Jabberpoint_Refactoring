package XML_file.Printer;

import Presentation.Presentation;
import org.w3c.dom.Element;
/*
Printer is an abstract class that serves as the base for all classes that print or display presentation data.
It has a single abstract method printSlideElement that accepts a Presentation object and a JDOM Element object as arguments,
and is responsible for printing or displaying the slide element to the user.
 */
public abstract class Printer {
    public abstract void printSlideElement(Presentation presentation, Element element);

}
