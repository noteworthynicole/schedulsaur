package logic;
import java.util.*;

public class Class {

	public String name;
	public ArrayList<Class> prerec;
	
	public Class(String name, ArrayList<Class> prerec){
		this.name = name;
		this.prerec = prerec;
	}
	
	public Class(String name){
		this.name = name;
		this.prerec = new ArrayList<Class>();
	}
	@Override
	   public String toString() {
	      return "Class " + name + " " + Arrays.toString(prerec.toArray());
	   }
}
