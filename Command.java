package myclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import enums.CommandWord;
/*
* @author Brian Mukeswe
* @contact b.mukeswe@sms.ed.ac.uk
*
*/

public class Command {
	
	private CommandWord command;
	private List<String> parameters = new ArrayList<>();
	
	public Command(CommandWord command) {
		this.command = command;
	}
	
	// Give parameters to the command
	public void setParameters(Iterator<String> parameters) {
		if (parameters != null) {
			if (parameters.hasNext() == true) {
				this.parameters.add(parameters.next());
			}
		}
	}

	// Retrieve the parameters of the command
	public Iterator<String> getParameters(){
		
		if (parameters.isEmpty() == false) {
			return parameters.iterator();
		}
		else {
			return null;
		}
	}
	
	// Retrieve the name of the command
	public CommandWord getCommandWord() {
		
		return command;
	}

}
