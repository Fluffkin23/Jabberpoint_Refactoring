package XML_file.Builder;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/*
The Builder class is an abstract class that defines the base behavior for classes that read and parse XML files.
It declares a single abstract method, builder, which takes a filename as a parameter and returns an Element object.
 */
public abstract class Builder
{
    public abstract Element builder(String filename) throws ParserConfigurationException, IOException, SAXException;
}
