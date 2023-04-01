package XML_file;

import Slide.Slide;
import XML_file.Writer.XMLWriter;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;


/** XML_file.XMLAccessor, getting all the information about  XML files
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class XMLAccessor
{
	
    /** Default API to use. */
    protected static final String DEFAULT_API_TO_USE = "dom";
    
    /** Names of xml tags of attributes */

    protected static final String LEVEL = "level";

    /** Text of messages */
    public static final String PCE = "Parser Configuration Exception";
    protected static final String NFE = "Number Format Exception";


    public String getTitle(Element element, String tagName) // Returns the text of a tag with a given name from an element
	{
    	NodeList titles = element.getElementsByTagName(tagName);
    	return titles.item(0).getTextContent();
    }

	private int levelText(NamedNodeMap value) // Parses the level attribute of a NamedNodeMap and returns its integer value
	{
		String leveltext = value.getNamedItem(LEVEL).getTextContent();
		if (leveltext != null)
		{
			try
			{
				return Integer.parseInt(leveltext);
			} catch (NumberFormatException x)
			{
				System.err.println(NFE);
			}
		}
		return 1;
	}

	public void loadSlideItem(Slide slide, Element item) // Loads an individual slide item into a slide object using an XMLWriter object
	{
		XMLWriter xmlWriter = new XMLWriter();
		NamedNodeMap attributes = item.getAttributes();
		int level = this.levelText(attributes);
		xmlWriter.appendTextItem(slide,attributes,item,level);
	}

}
