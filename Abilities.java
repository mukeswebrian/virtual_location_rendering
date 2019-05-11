package myclasses;

import java.util.HashMap;

/**
* A class that implements the avatar's abilites including navigation and 
* manipulation of portable items in the virtual world. 
*
*/
public class Abilities {
	
	// Maps to store navigation logic
	private static HashMap<String, String> leftLogic = new HashMap<>();
	private static HashMap<String, String> rightLogic = new HashMap<>();
	
	/**
	* Initialise the navigation logic maps
	*/
	private static void init(){
		
		// Specify the logic for turning left
		leftLogic.put("north", "west");
		leftLogic.put("west", "south");
		leftLogic.put("south", "east");
		leftLogic.put("east", "north");
		
		// Specify the logic for turning right
		rightLogic.put("north", "east");
		rightLogic.put("east", "south");
		rightLogic.put("south", "west");
		rightLogic.put("west", "north");
	}
	
	/**
	* Identify the appropriate actions to take based on the received command
	*
	*/
	public static void perform(Command command, Avatar avatar) {
		
		init();
		
		switch (command.getCommandWord()) {
		
		case DROP_ITEM:
			dropItem(command, avatar);
			break;
			
		case MOVE_FORWARD:
			
			// Check that the command contains a parameter
			if (command.getParameters() != null) {
				
				moveForward(command, avatar);
			}
			else {// The command contains no parameter
			
				moveForward(avatar);
			}
			break;
			
		case PICKUP_ITEM:
			pickupItem(command, avatar);
			break;
			
		case TURN_LEFT:
			turnLeft(command, avatar);
			break;
			
		case TURN_RIGHT:
			turnRight(command, avatar);
			break;
			
		case UNKNOWN:
			break;
			
		default:
			break;
		}
	}
	
	/**
	* Make the avatar turn right
	*/
	private static void turnRight(Command command, Avatar avatar) {
		
		// Identify the new direction after turning
		String newDirection = rightLogic.get(avatar.getCurrentDirection());
		
		// Make the avatar face the new direction
		avatar.setCurrentDirection(newDirection);
		
	}
	
	/**
	* Make the avatar turn left
	*/
	private static void turnLeft(Command command, Avatar avatar) {
		
		// Identify the new direction after turning
		String newDirection = leftLogic.get(avatar.getCurrentDirection());
		
		// Make the avatar face the new direction
		avatar.setCurrentDirection(newDirection);
		
	}
	
	/**
	* Make the avatar pick up an item from the current location
	*/
	private static void pickupItem(Command command, Avatar avatar) {
		
		// Check that the command has a parameter
		if (command.getParameters() != null) {
			
			if (command.getParameters().hasNext() == true) {
				
				// Identify the item to be picked up from the avatar's current location
				Item item = avatar.getCurrentLocation().getItem(command.getParameters().next());
				
				// Pick up the item
				avatar.addCartItem(item);
				avatar.getCurrentLocation().removeItem(item.getFileName());
				
			}
		}
	}
	
	/**
	* Make the avatar move forward through a specified exit
	*/
	private static void moveForward(Command command, Avatar avatar) {
		
		// Check that the command has a parameter
		if (command.getParameters() != null) {
			if (command.getParameters().hasNext() == true){
				
				// Identify the destination
				String newLocationName = command.getParameters().next();
				
				//  Check if the avatar has previously visited the destination location
				if (avatar.getVisitedLocation(newLocationName) != null) {
					
					// Load the destination location from the record of previously visited locations
					avatar.setCurrentLocation(avatar.getVisitedLocation(newLocationName));
				}
				else { // The avatar is visiting the destination for the first time
				
					// Load the destination from the World class
					avatar.setCurrentLocation(World.getLocation(newLocationName));
				}
			}
		}
	}
	
	/**
	* Make the avatar move forward through the first available exit. This method is
	* used when the user does not explicitly specify the exit to be used.
	*/
	private static void moveForward(Avatar avatar) {
		
		// Identify the destination
		String newLocationName = avatar.getCurrentLocation().getView(avatar.getCurrentDirection()).getExits().next();
		
		//  Check if the avatar has previously visited the destination location
		if (avatar.getVisitedLocation(newLocationName) != null) {
			
			// Load the destination location from the record of previously visited locations
			avatar.setCurrentLocation(avatar.getVisitedLocation(newLocationName));
		}
		else {// The avatar is visiting the destination for the first time
			
			// Load the destination from the World class
			avatar.setCurrentLocation(World.getLocation(newLocationName));
		}
	
	}
	/**
	* Make the avatar drop off an item at the current location
	*/
	private static void dropItem(Command command, Avatar avatar) {
		
		// Check that the command has a parameter
		if (command.getParameters() != null) {
			if (command.getParameters().hasNext() == true){
				
				// Get the name of the item to be dropped
				String itemName = command.getParameters().next();
				
				// Drop off the specified item in the current location
				avatar.getCurrentLocation().addItem(avatar.getCartItem(itemName));
				avatar.removeCartItem(itemName);
			}
		}
	}
}
