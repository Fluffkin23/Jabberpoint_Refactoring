package Slide;

import Presentation.CreateStyles;
import Presentation.Style;
import Presentation.TextItem;

import java.awt.*;
import java.awt.image.ImageObserver;

public class SlideDrawer
{
    private Slide slide;

    public SlideDrawer(Slide slide)
    {
        this.slide = slide;
    }

    public Slide getSlide() {
        return slide;
    }

    public void setSlide(Slide slide) {
        this.slide = slide;
    }

    //Draws what the slide actual contain.
    public void draw(Graphics g, Rectangle area, ImageObserver view)
    {
        int y = area.y;

        //Here we will draw just the title
        y+= drawBody(new TextItem(0,slide.getTitle()), y, g, area, view);

        //Drawing all others elements
        for(int number = 0; number < slide.getSize(); number ++)
        {
            y +=drawBody(slide.getSlideItems().elementAt(number),y,g,area,view);
        }
    }

    //draw the actual slide
    private int drawBody(SlideItem slideItem, int y, Graphics g, Rectangle area,ImageObserver view)
    {
        Style style = CreateStyles.getStyle(slideItem.getLevel());
        slideItem.draw(area.x,y,getScale(area),g,style,view);
        return slideItem.getBoundingBox(g, view, getScale(area),style).height;
    }
    //Returns the scale to draw a slide
    private float getScale(Rectangle area) {
        return Math.min(((float)area.width) / ((float)slide.WIDTH), ((float)area.height) / ((float)slide.HEIGHT));
    }

}
