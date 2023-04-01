package XML_file.Reader;

import Presentation.Presentation;

import java.io.IOException;

/*
Reader is an abstract class that serves as the base for all classes that read or load presentation data.
It has a single abstract method loadFile that accepts a Presentation object and a filename as arguments,
and is responsible for loading the presentation data from a file into the Presentation object.
 */

public abstract class Reader
{
    public abstract  void loadFile(Presentation p, String fn) throws IOException;
}
