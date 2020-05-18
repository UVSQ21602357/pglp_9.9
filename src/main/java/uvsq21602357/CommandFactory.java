package uvsq21602357;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
	private final Map<String, Command> commands;
	
	private CommandFactory() {
		this.commands = new HashMap();
	}
	
	public void addCommand(String name, Command command) {
		this.commands.put(name, command);
	}
	
	public void executeCommand(String name) {
		if(this.commands.containsKey(name)) {
			this.commands.get(name).apply();
		}
	}
	
	public static CommandFactory init() {
		CommandFactory cf = new CommandFactory();
		cf.addCommand("Créer", () -> );
		cf.addCommand("Déplacer", () -> );
		cf.addCommand("Supprimer", () -> );
		cf.addCommand("Grouper", () -> );
		cf.addCommand("Afficher", () -> );
		return cf;
	}

}
