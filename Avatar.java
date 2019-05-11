package myclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import myclasses.Abilities;

/**
 * An avatar that is able to move through locations in the virtual world and to carry 
 * portable items from one location to another using a cart. The avatar's abilities
 * correspond to specific user commands.
 * 
 * @author mukeswe brian
 *
 */
public class Avatar {
	
	// A variable to keep track of the avatar's location in the world
	private Location currentLocation;
	
	// A variable to keep track of the avatar's direction in the world
	private String currentDirection;
	
	// A variable to keep track of the items that have been collected
	private List<Item> cart = new ArrayList<>(); 
	
	// A variable to keep track of the locations that have been visited
	private HashMap<String, Location> visitedLocations = new HashMap<>();

	
    /**
     * Constructor for the Avatar class
     * 
     * @param startLocation, the location where the avatar enters the virtual world
     */
	public Avatar(Location startLocation) {
		
        // Put the avatar in the specified start location
		currentLocation = startLocation;
		
		init();
	}
	/**
	 * Initialise the avatar
	 */
	private void init() { 
		
		// Specify the direction where the newly initialised avatar will face
		currentDirection = "south"; 
	}

	/** 
	 * Retrieve the avatar's current location
	 * 
	 * @return a Location object corresponding to the avatar's current location
	 */
	public Location getCurrentLocation() {
		
		return currentLocation;
	}
	
	/**
	 *  Move the avatar to a new location
	 * 
	 * @param location the Location where the avatar should move
	 */
	public void setCurrentLocation(Location location) {
		
		updateVisitedLocations(); 
		currentLocation = location;
	}
	
	/**
	 * Retrieve the direction where the avatar currently is facing
	 * 
	 * @return a String specifying the avatar's current direction
	 */
	public String getCurrentDirection() {
		
		return currentDirection;
	}
	
	/**
	 *  Make the avatar face a new direction
	 *  
	 * @param a String specifying where the avatar should face
	 */
	public void setCurrentDirection(String direction) {
		
		currentDirection = direction;
	}
	
	/**
	 *  Retrieve all the portable items that the avatar is carrying
	 *  
	 * @return an iterator of Items
	 */
	public Iterator<Item> getCartItems(){
		
		if (cart.isEmpty() == false) {
			return cart.iterator();
		}
		else {
			return null;
		}
	}
	
	/**
	 *  Add a new item to the avatar's cart
	 *  
	 * @param the Item to be added to the avatar's cart
	 */
	public void addCartItem(Item item) {
		
		cart.add(item);
	}
	
	/**
	 *  Remove an item from the avatar's cart
	 *  
	 * @param itemName a String specifying the name of the item to be removed
	 */
	public void removeCartItem(String itemName) {
		
		Item toRemove = null;
		
		if (cart.isEmpty() == false) {
			
			// Identify the item to be removed
			for (Item item : cart) {
				if (item.getFileName().equals(itemName)) {
					toRemove = item;
				}
			}
			
			// Remove the identified item
			if (toRemove != null) {
				cart.remove(toRemove);
			}
		}
	}
	
	/**
	 * Handle a command from the controller
	 * 
	 * @param command a Command corresponding to  a specific action to be performed by the avatar.
	 */
	public void perform(Command command) {
		
		// Use the abilities to perform the appropriate action
		Abilities.perform(command, this);
	}
	
    /**
     *  Retrieve a single item from the avatar's cart
     *  
     * @param itemName, the name of the item to be retrieved
     * 
     * @return an Item object
     */
	public Item getCartItem(String itemName) {
		
		Item targetItem = null;
		
		if (cart.isEmpty() == false) {
			
			// Find the requested item
			for (Item item : cart) {
				if (item.getFileName().equals(itemName)) {
					targetItem =  item;
				}
		    }
		}
	
		return targetItem;
	}
	
	/**
	 * Update the record of visited locations
	 */
	private void updateVisitedLocations() {
		visitedLocations.put(currentLocation.getLocationName(), currentLocation);
	}
	
	/**
	 * Retrieve a location from the record of visited locations
	 * 
	 * @param locationName, the name of the location to be retrieved
	 * 
	 * @return a Location object
	 */
	public Location getVisitedLocation(String locationName) {
		if (visitedLocations.containsKey(locationName) == true) {
			return visitedLocations.get(locationName);
		}
		else {
			return null;
		}
	}
}
