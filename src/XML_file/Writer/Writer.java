package XML_file.Writer;

import java.io.IOException;
import Presentation.Presentation;

/*
Writer is an abstract class that serves as the base for all classes that write or save presentation data.
It has a single abstract method saveFile that accepts a Presentation object and a filename as arguments,
 and is responsible for saving the presentation to a file.
 */
public abstract class Writer
{
    public abstract void saveFile(Presentation presentation, String filename) throws IOException;
}
