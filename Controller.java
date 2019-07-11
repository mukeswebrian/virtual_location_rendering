package controller;


import interfaces.WorldViewer;
import myclasses.Avatar;
import myclasses.Command;
import myclasses.World;

/**
 * A controller for the World application.
 * 
 * @author Brian Mukeswe
 * @contact b.mukeswe@sms.ed.ac.uk
 *
 */
public class Controller {
	
	private Avatar avatar; // An avatar to perform actions on behalf of the user
	private WorldViewer viewer; // A viewer to interact with the user interface
	
	/**
	 * Constructor for the controller
	 * 
	 * @param viewer the class that receives commands from the user and 
	 * shows the current state of the avatar.
	 */
	public Controller(WorldViewer viewer) {
		
		// connect the viewer to this controller
		this.viewer = viewer;
		 
		init();

	}
	
	/**
	 * Initialise the controller
	 */
	private void init() {
		
		// Create an avatar
		avatar = new Avatar(World.getStartLocation());
		
		// Initialise the viewer
		viewer.setController(this);
		viewer.Initialise(avatar.getCurrentLocation().getView(avatar.getCurrentDirection()),
			              avatar.getCartItems(),
			              avatar.getCurrentLocation().getContents());
	}
	
	/**
	 * Process a user command
	 */
	public void select(Command command) {
		
		// Delegate processing of the command
		avatar.perform(command);
		
		// Refresh the viewer with the new state
		viewer.refresh(avatar.getCurrentLocation().getView(avatar.getCurrentDirection()),
				        avatar.getCartItems(),
				       avatar.getCurrentLocation().getContents());
		
	}

}
