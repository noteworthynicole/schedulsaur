package logic;
import java.util.*;

public class Class {

	public String name;
	public List<Class> prerec;
	
	public Class(String name, List<Class> prerec2){
		this.name = name;
		this.prerec = prerec2;
	}
	
	public Class(String name){
		this.name = name;
		this.prerec = new ArrayList<>();
	}
	@Override
	   public String toString() {
		if(!prerec.isEmpty()) {
	      return "Class " + name + " " + Arrays.toString(prerec.toArray());
		} else {
			return "Class " + name;
		}
	   }
}
