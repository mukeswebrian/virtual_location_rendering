package myclasses;

import java.util.HashMap;
import myclasses.WorldConfig;

/**
 * A virtual world that contains various locations.
 * 
 * @author Brian Mukeswe
 * @contact b.mukeswe@ed.ac.uk
 *
 */
public class World {
	
	// A record of the initial state of all locations in the virtual worlds
	private static HashMap<String, Location> locations = new HashMap<>();  
	
	
	/**
	 * Specify the locations contained in the virtual world.
	 * Location information is retrieved from the configuration class 
	 */
	private static void setLocations() {
		
		// Retrieve location information from the configuration class
		for (String locationName : WorldConfig.getLocationNames()) {
			locations.put(locationName, new Location(locationName));
		}
	}
	
	/**
	 * Retrieve the entry location for the virtual world
	 * 
	 * @return location, The location where one can enter the virtual world
	 */
	public static Location getStartLocation() {
		
		// Update location records
		setLocations();
		
		if (locations.isEmpty() == false) {
			
			// Identify the start location. 
			// The name of the start location is retrieved from the configuration class
			Location startLocation = locations.get(WorldConfig.getStartLocation());
			
			return startLocation;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Retrieve a location from the virtual world
	 * 
	 * @param locationName name of the location to retrieve
	 * @return a location object
	 */
	public static Location getLocation(String locationName) {
		
		// Update location records
		setLocations();
		
		if (locations.isEmpty() == false) {
			
			// Retrieve the specified location
			return locations.get(locationName);
		}
		else {
			return null;
		}
	}

}
