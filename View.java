package myclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myclasses.WorldConfig;

/**
* A view that represents what the user sees when they are facing
* a specific direction at a given location
*
* @author Brian Mukeswe
* @contact b.mukeswe@ed.ac.uk
*
*/
public class View {
	
	// The name of the image file that is associated with the view
	private String fileName;
	
	// A record of exits that are present in the view. 
	// Each name corresponds to the destination location accessed by the exit
	private List<String> exits = new ArrayList<>();
	
	/**
	* Constructor for a view object. 
	*
	* @param locationName, the name of the location where this view is located
	* @param direction, the direction associated with the view
	*
	*/
	public View(String locationName, String direction) {
		
		// Retrieve the appropriate file name from the configuration class
		fileName = WorldConfig.getViewImage(locationName, direction);
		
		// Specify the exits available in the view (if any)
		setExits();
	}
	
	/**
	* Specify the exits available in the view (if any)
	*
	*/
	private void setExits() {
		
		// Retrieve the appropriate exit information for the view
		for (String exit : WorldConfig.getExits().get(fileName).split(",")) {
			if (exit.trim().equals("none") == false) {
				exits.add(exit.trim());
			}
		}
	}
	/**
	* Check if a the view has at least one exit
	*
	*/
	public boolean hasExit() {
		
		if (exits.isEmpty() == false) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	* Use an iterator to retrieve the exits in the view (if any)
	*
	* @return An iterator of exit names. 
	*
	*/
	public Iterator<String> getExits() {
		
		if (exits.isEmpty() == false) {
			return exits.iterator();
		}
		else {
			return null;
		}
	}
	
	/**
	* Retrieve the name of the image file that is associated with the view
	*
	* @return a string specifying the 
	*
	*/
	public String getFileName() {
		
		return fileName;
	}
	
	/**
	 * Retrieve the number of exits present in the view
	 * 
	 * @return an integer specifying the number of available exits in the view
	 */
	public int getExitCount() {
		
		return exits.size();
	}

}
