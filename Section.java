import java.util.*;

public class Section extends Class{
	
	public String id; 
	public String type;
	public Times times;
	public String prof;
	public String location;
	
	public Section(String name, String id, String type, ArrayList<Class> prerec, String prof, Times times, String location) {
		super(name, prerec);
		this.type = type;
		this.prof = prof;
		this.times = times;
		this.location = location;
	}
	
	public Section(String name, String id, String type, String prof, Times times, String location) {
		super(name);
		this.type = type;
		this.prof = prof;
		this.times = times;
		this.location = location;
	}
	
	@Override
	   public String toString() {
	      return super.toString() + " Section " + id + " " + type + " " + times + " " + prof + " " + location;
	   }

}
