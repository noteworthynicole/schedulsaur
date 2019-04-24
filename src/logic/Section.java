package logic;
import java.util.*;

public final class Section extends Class{
	
	private String id; 
	private String type;
	private Section lab;
	private List<Times> times;
	private List<Class> prerec;
	private String prof;
	private String location;
	
	public Section(String name, String id, String type, List<Class> prerec, String prof, Times times, String location) {
		super(name);
		this.id = id;
		this.type = type;
		this.prof = prof;
		this.prerec = prerec;
		this.times = new ArrayList<>();
		this.times.add(times);
		this.location = location;
	}
	
	public Section(String name, String id, String type, String prof, Times times, String location) {
		super(name);
		this.id = id;
		this.type = type;
		this.prof = prof;
		this.prerec = new ArrayList<>();
		this.times = new ArrayList<>();
		this.times.add(times);
		this.location = location;
	}
	
	public List<Class> getPrerec(){
		return prerec;
	}
	
	public Section getLab() {
		return lab;
	}
	
	public String getType() {
		return type;
	}
	
	public List<Times> getTimes(){
		return times;
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
