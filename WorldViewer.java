package interfaces;

import java.util.Iterator;

import controller.Controller;
import myclasses.Item;
import myclasses.View;

/**
* An interface for a world veiwer
*/
public interface WorldViewer {
	
	/**
	* Specify the controller that is assciated with the viewer
	*/
	public void setController(Controller controller);
	
	/**
	* Initialise the viewer
	*/
	public void Initialise(View currentView, Iterator<Item> cart, Iterator<Item> locationContents);
	
	/**
	* Update the content of the viewer
	*/
	public void refresh(View currentView, Iterator<Item> cart, Iterator<Item> locationContents);

}
