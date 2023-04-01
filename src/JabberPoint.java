import Demo.DemoPresentation;
import Presentation.Presentation;
import Slide.SlideViewerFrame;
import Presentation.CreateStyles;
import XML_file.Reader.XMLReader;

import java.io.IOException;

/** JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */




public class JabberPoint {

	// Version of the program
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	/** The main program */
	public static void main(String[] argv)
	{

		CreateStyles.createStyles(); // Initialize the styles used for the presentation
		Presentation presentation = new Presentation();        // Create a new Presentation object
		DemoPresentation demoPresentation = new DemoPresentation(); // Create a new DemoPresentation object
		XMLReader reader = new XMLReader();// Create a new XMLReader object
		new SlideViewerFrame(JABVERSION, presentation); // Create a new SlideViewerFrame object and display it
			if (argv.length == 0) // Check if any command line arguments were passed
			{
				demoPresentation.loadFile(presentation); // Load the demo presentation into the Presentation object
			}
			else
			{
				try {
					reader.loadFile(presentation, argv[0]);  // Load the presentation file specified by the first command line argument into the Presentation object
				} catch (IOException e) {
					throw new RuntimeException(e); // If there is an error loading the file, throw a RuntimeException
				}
			}
			presentation.setSlideNumber(0); // Set the slide number to zero
	}
}
