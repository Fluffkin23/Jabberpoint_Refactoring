package XML_file.Writer;

import Presentation.Presentation;
import Presentation.TextItem;
import Slide.Slide;
import Slide.SlideItem;
import Presentation.BitmapItem;
import XML_file.XMLAccessor;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class XMLWriter extends Writer{
    private XMLAccessor xmlAccessor;    // An object to access XML data

    // Names of XML tags
    protected static final String KIND = "kind";
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";
    protected static final String UNKNOWNTYPE = "Unknown Element type";

    @Override
    public void saveFile(Presentation presentation, String filename) throws IOException  // Saves a presentation to an XML file
    {
        PrintWriter out = new PrintWriter(new FileWriter(filename));
        out.println("<?xml version=\"1.0\"?>");
        out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
        out.println("<presentation>");
        out.print("<showtitle>");
        out.print(presentation.getTitle());
        out.println("</showtitle>");
        for (int slideNumber=0; slideNumber<presentation.getSize(); slideNumber++)
        {
            Slide slide = presentation.getSlide(slideNumber);
            out.println("<slide>");
            out.println("<title>" + slide.getTitle() + "</title>");
            Vector<SlideItem> slideItems = slide.getSlideItems();
            for (int itemNumber = 0; itemNumber<slideItems.size(); itemNumber++)
            {
                SlideItem slideItem = (SlideItem) slideItems.elementAt(itemNumber);
                out.print("<item kind=");
                if (slideItem instanceof TextItem)
                {
                    out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
                    out.print( ( (TextItem) slideItem).getText());
                }
                else
                {
                    if (slideItem instanceof BitmapItem)
                    {
                        out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
                        out.print( ( (BitmapItem) slideItem).getName());
                    }
                    else
                    {
                        System.out.println("Ignoring " + slideItem);
                    }
                }
                out.println("</item>");
            }
            out.println("</slide>");
        }
        out.println("</presentation>");
        out.close();
    }

    public void appendTextItem(Slide slide, NamedNodeMap value, Element item, int level) // Appends a slide item to a slide object
    {
        String type = value.getNamedItem(KIND).getTextContent();
        if (TEXT.equals(type))
        {
            slide.append(new TextItem(level, item.getTextContent()));
        }
        else
        {
            if (IMAGE.equals(type))
            {
                slide.append(new BitmapItem(level, item.getTextContent()));
            }
            else
            {
                System.err.println(UNKNOWNTYPE);
            }
        }
    }
}
