package logic;
import java.util.*;

public final class Section extends Class{
	
	public String id; 
	public String type;
	public Section lab;
	public List<Times> times;
	public String prof;
	public String location;
	
	public Section(String name, String id, String type, ArrayList<Class> prerec, String prof, Times times, String location) {
		super(name);
		this.id = id;
		this.type = type;
		this.prof = prof;
		this.times = new ArrayList<Times>();
		this.times.add(times);
		this.location = location;
	}
	
	public Section(String name, String id, String type, String prof, Times times, String location) {
		super(name);
		this.id = id;
		this.type = type;
		this.prof = prof;
		this.times = new ArrayList<Times>();
		this.times.add(times);
		this.location = location;
	}
	
	@Override
	   public String toString() {
		if(lab == null) {
	      return super.toString() + " Section " + id + " " + type + " " + times + " " + prof + " " + location;
		} else {
			return super.toString() + " Section " + id + " " + type + " " + times + " " + prof + " " + location + ", Lab " + lab.toString(); 
		}
	   }
	
	public void addClass(Section lab) {
		this.lab = lab;
		times.addAll(lab.times);
	}

}
