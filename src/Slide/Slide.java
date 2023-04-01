package Slide;

import Presentation.TextItem;

import java.util.Vector;

/** <p>A slide. This class has drawing functionality.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide
{
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	protected String title; //The title is kept separately
	protected Vector<SlideItem> items; //The SlideItems are kept in a vector

	public Slide()
	{
		//items = new Vector<Slide.SlideItem>();
		this.items = new Vector<>();
	}

	//Add a Slide.SlideItem
	public void append(SlideItem anItem)
	{
		this.items.addElement(anItem);
	}

	//Return the title of a slide
	public String getTitle()
	{
		return this.title;
	}

	//Change the title of a slide
	public void setTitle(String newTitle)
	{
		this.title = newTitle;
	}

	//Create a Presentation.TextItem out of a String and add the Presentation.TextItem
	public void append(int level, String message)
	{
		append(new TextItem(level, message));
	}

	//Returns the Slide.SlideItem
	public SlideItem getSlideItem(int number)
	{
		//return (Slide.SlideItem)items.elementAt(number);
		return this.items.elementAt(number);
	}

	//Return all the SlideItems in a vector
	public Vector<SlideItem> getSlideItems()
	{
		return this.items;
	}

	//Returns the size of a slide
	public int getSize()
	{
		return this.items.size();
	}



}
