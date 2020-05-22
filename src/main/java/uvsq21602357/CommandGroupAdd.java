package uvsq21602357;

public class CommandGroupAdd implements Command{
	
	public String NomF;
	public String NomG;
	
	public CommandGroupAdd(String str, String s) {
		this.NomG = str;
		this.NomF = s;
	}
	
	public void execute() {
		
	}
}
