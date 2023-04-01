package Demo;

import Presentation.Presentation;

/*
The DemoLoader class is an abstract class that defines the base behavior for classes that load demo presentations into
a Presentation object. It declares a single abstract method, loadFile, which takes a Presentation object as a parameter and loads demo presentation slides into it.
 */
public abstract class DemoLoader {
    public abstract void loadFile(Presentation presentation);

}
