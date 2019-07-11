package myclasses;

/**
* A portable item that can be picked up an carried from
* one location to another
*
* @author Brian Mukeswe
* @contact b.mukeswe@sms.ed.ac.uk
*
*/
public class Item {
	
	// The file name of the item's image
	private String fileName;
	
	/**
	* Constructor for the item class
	*
	* @param a string specifying the file name of the item's image
	*/
	public Item(String fileName) {
		
		this.fileName = fileName;	
	}
	
	/**
	* Retrieve the file name of the item's image
	*
	* @return a string specifying the file name of the item's image
	*/
	public String getFileName() {
		
		return fileName;
	}
}
