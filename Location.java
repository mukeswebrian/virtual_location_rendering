package myclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * A location in the virtual world. The location contains views in different directions. 
 * The location may also contain portable items.
 * 
 * @author mukeswe brian
 *
 */
public class Location {
	
	private String locationName;
	
	// A record of possible views at the location
	private HashMap<String, View> locationViews = new HashMap<>(); 
	
	// A record of the items contained at the location
	private List<Item> contents = new ArrayList<>();
	
	// A record of possible directions at that location
	private List<String> directions = new ArrayList<>();
	
	/**
	 * Constructor for the Location class
	 * 
	 * @param locationName, the name of the location
	 */
	public Location(String locationName) {
		
		this.locationName = locationName;
		init();
	}
	
	/**
	 * Initialise the location
	 */
	private void init() {
		
		setDirections(); // specify the possible directions at the location
		setViews(); // Specify the views corresponding to each direction
		setItems(); // Specify the items contained in the location
		
	}
	
	/**
	 * Specify the views corresponding to each direction
	 */
	private void setViews() {
		
		for (String direction : directions) {	
			locationViews.put(direction, new View(locationName, direction));
		}	
	}
	
	/**
	 * Specify the items contained in the location
	 */
	private void setItems() {
		
		// Retrieve item names from the configuration class
		String filenames = WorldConfig.getItemImages(locationName);
		
		if (filenames.equals("none") == false) {
			
			for (String filename: filenames.split(",")) {
				contents.add(new Item(filename.trim()));
				
			}
		}
	}
	
	/**
	 * specify the possible directions at the location
	 */
	private void setDirections() {
		
		directions.add("north");
		directions.add("south");
		directions.add("east");
		directions.add("west");
	}
	
	/**
	 * Retrieve the name of the location
	 * 
	 * @return a string specifying the name of the location
	 */
	public String getLocationName() {
		
		return locationName;
	}
	
	/**
	 * Retrieve the view that corresponds to what one sees
	 *  when facing in a specific direction at the location
	 *  
	 * @param direction of interest
	 * 
	 * @return a View object
	 */
	public View getView(String direction) {
		
		if (locationViews.isEmpty() == false) {	
			
			return locationViews.get(direction);
		}
		else {	
			return null;
		}
		
	}
	
	/**
	 *  Retrieve all the portable items that are currently at the location
	 *  
	 * @return an iterator of items
	 */
	public Iterator<Item> getContents(){
		
		if (contents.isEmpty() == false) {
			return contents.iterator();
		}
		else {
			return null;
		}
	}
	
	/**
	 * Retrieve a single item from the location
	 * 
	 * @param itemName, the name of the item to be retrieved
	 * 
	 * @return an ITem object
	 */
	public Item getItem(String itemName) {
		
		Item targetItem = null;
		
		if (contents.isEmpty() == false) {
			
			// Identify the requested item
			for (Item item : contents) {
				if (item.getFileName().equals(itemName)) {
					targetItem =  item;
				}
			}
		}
	
		return targetItem;
	}
	
	/**
	 *  Remove a portable item from the location
	 *  
	 * @param itemName, the name of the item to be removed
	 */
	public void removeItem(String itemName) {
		
		Item toRemove = null;
		
		if (contents.isEmpty() == false) {
			
			// Identify the item to be removed
			for (Item item : contents) {
				if (item.getFileName().equals(itemName)) {
					toRemove = item;
				}
			}
			
			// Remove the item
			if (toRemove != null) {
			contents.remove(toRemove);
			}
		}
	}
	/**
	 *  Add a new portable item to the location
	 *  
	 * @param item, the item to be added to the location
	 */
	public void addItem(Item item) {
		
		contents.add(item);
	}
}
