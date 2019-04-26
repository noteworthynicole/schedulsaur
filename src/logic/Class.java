package logic;
import java.util.*;

public class Class {

	private String name;
	private List<Class> prerec;
	private int units = 4;
	
	public Class(String name, List<Class> prerec2){
		this.name = name;
		this.prerec = prerec2;
	}
	
	public Class(String name){
		this.name = name;
		this.prerec = new ArrayList<>();
	}
	
	public String getName() {
		return name;
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
