package myclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A configuration class that specifies the names of the files that make up locations 
 * and items in the virtual world. For location images, the configuration class also 
 * specifies the exits that are in each image file (if any).
 * 
 * @author Brian Mukeswe
 * @contact b.mukeswe@ed.ac.uk
 *
 */
public class WorldConfig {
	
	// A record containing the names of all locations 
	private static List<String> locationNames = new ArrayList<>();
	
	// Variables to store information about the images that make up each location
	private static HashMap <String, String> bedroom = new HashMap<>();
	private static HashMap <String, String> livingroom = new HashMap<>();
	private static HashMap <String, String> kitchen = new HashMap<>();
	private static HashMap <String, String> washroom = new HashMap<>();
	private static HashMap <String, String> corridor = new HashMap<>();
	
	// A map between location names and their corresponding images
	private static HashMap <String, HashMap<String, String>> locationImages = new HashMap<>();
	
	// A record of the exits contained in each image
	private static HashMap <String,  String> exits = new HashMap<>();
	
	// A record of the items initially contained in each location
	private static HashMap <String, String>itemImages = new HashMap<>();
	
	// The entry location
	private static String startLocation;
	
	/**
	 * Specify the names of the locations in the world
	 */
	private static void setLocationNames() {
		
		locationNames.add("bedroom");
		locationNames.add("kitchen");
		locationNames.add("corridor");
		locationNames.add("livingroom");
		locationNames.add("washroom");
		
	}
	
	/**
	 * Retrieve an image corresponding to the view at a location in a specific direction
	 * 
	 * @param locationName,  the name of the location where the image is located
	 * @param direction, the direction corresponding to the image to be retrieved
	 * 
	 * @return The file name of the requested image
	 */
	public static String getViewImage(String locationName, String direction) {
		
		// Set up location information
		configLocations();
		setLocationImages();
		
		// Retrieve the appropriate image
		HashMap <String,  String> images = locationImages.get(locationName);
		return images.get(direction);
		
	}
	
	/**
	 * Retrieve a map of all exits between locations in the world
	 * 
	 * @return A HashMap containing image filenames and corresponding exits
	 */
	public static HashMap <String, String> getExits(){
		
		// Set up exit information
		setExits();
		
		if (exits.isEmpty() == false) {
			
			// Retrieve exit map
			return exits;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Retrieve the names of all locations in the virtual world
	 * 
	 * @return A list of all names in the virtual world
	 */
	public static List<String> getLocationNames(){
		
		// Set up location information
		setLocationNames();
		
		if (locationNames.isEmpty() == false) {
			
			// Retrieve location names
			return locationNames;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Retrieve the items that are initially present at a location
	 * 
	 * @param LocationName, The name of the locations where the items are located
	 * 
	 * @return a comma separated list of items at the specified location
	 */
	public static String getItemImages(String LocationName){
		
		// Update item information
		setItemImages();
		
		// Retrieve the items at the specified location
		return itemImages.get(LocationName);
	}
	
	/**
	 * Retrieve the name of the entry location into the virtual world
	 * 
	 * @return The name of the entry location
	 */
	public static String getStartLocation() {
		
		setStartLocation();
		return startLocation;
	}
	
	/**
	 * Specify the entry location into the virtual world
	 */
	private static void setStartLocation() {
		
		startLocation = "corridor";
	}
	
	/**
	 * Specify the group of images corresponding to each location
	 */
	private static void setLocationImages() {
		
		locationImages.put("bedroom", bedroom);
		locationImages.put("livingroom", livingroom);
		locationImages.put("kitchen", kitchen);
		locationImages.put("washroom", washroom);
		locationImages.put("corridor", corridor);
	}
	
	/**
	 * Specify the items that are initially at each location
	 */
	private static void setItemImages() {
		
		itemImages.put("bedroom", "book.png"); //book photo from https://www.wikihow.com/Dedicate-a-Book
		itemImages.put("livingroom", "none");
		itemImages.put("kitchen", "spoon.png, fork.png, plate.png");
		itemImages.put("washroom", "soap.png");
		itemImages.put("corridor", "clock.png");
	}
	
	/**
	 * Specify the group of image files that make up each location
	 */
	private static void configLocations() {
		
		bedroom.put("north","bedroom-north.jpeg");
		bedroom.put("south", "bedroom-south.jpeg");
		bedroom.put("east", "bedroom-east.jpeg");
		bedroom.put("west", "bedroom-west.jpeg");
		
		livingroom.put("north","livingroom-north.jpeg");
		livingroom.put("south", "livingroom-south.jpeg");
		livingroom.put("east", "livingroom-east.jpeg");
		livingroom.put("west", "livingroom-west.jpeg");
		
		kitchen.put("north", "kitchen-north.jpeg");
		kitchen.put("south", "kitchen-south.jpeg");
		kitchen.put("east", "kitchen-east.jpeg");
		kitchen.put("west", "kitchen-west.jpeg");
		
		washroom.put("north","bathroom-north.jpeg");
		washroom.put("south", "bathroom-south.jpeg");
		washroom.put("east", "bathroom-east.jpeg");
		washroom.put("west", "bathroom-west.jpeg");
		
		corridor.put("north","corridor-north.jpeg");
		corridor.put("south", "corridor-south.jpeg");
		corridor.put("east", "corridor-east.jpeg");
		corridor.put("west", "corridor-west.jpeg");
	}
	
	/**
	 * Specify the exits in each image if any
	 */
	private static void setExits() {
		
		exits.put("bedroom-north.jpeg", "none");
		exits.put("bedroom-south.jpeg", "none");
		exits.put("bedroom-east.jpeg", "corridor");
		exits.put("bedroom-west.jpeg", "none");
		
		exits.put("livingroom-north.jpeg", "none");
		exits.put("livingroom-south.jpeg", "none");
		exits.put("livingroom-east.jpeg", "corridor");
		exits.put("livingroom-west.jpeg", "none");
		
		exits.put("kitchen-north.jpeg", "none");
		exits.put("kitchen-south.jpeg", "corridor");
		exits.put("kitchen-east.jpeg", "none");
		exits.put("kitchen-west.jpeg", "none");
		
		exits.put("bathroom-north.jpeg", "corridor");
		exits.put("bathroom-south.jpeg", "none");
		exits.put("bathroom-east.jpeg", "none");
		exits.put("bathroom-west.jpeg", "none");
		
		exits.put("corridor-north.jpeg", "kitchen");
		exits.put("corridor-south.jpeg", "washroom");
		exits.put("corridor-east.jpeg", "none");
		exits.put("corridor-west.jpeg", "bedroom, livingroom");		
	}

}
