package logic;
import java.util.*;

public final class Section extends Class{
	
	private String id; 
	private String type;
	private Section lab;
	private DoubleTimes times;
	private List<Class> prerec;
	private String prof;
	private String location;
	
	public Section(String name, String id, String type, List<Class> prerec, String prof, DoubleTimes times, String location) {
		super(name);
		this.id = id;
		this.type = type;
		this.prof = prof;
		this.prerec = prerec;
		this.times = times;
		this.location = location;
	}
	
	public Section(String name, String id, String type, String prof, DoubleTimes times, String location) {
		super(name);
		this.id = id;
		this.type = type;
		this.prof = prof;
		this.prerec = new ArrayList<>();
		this.times = times;
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
	
	public Times getLecTimes(){
		if(times != null) {
			return times.getLecTimes();
		}
		return null;
	}
	
	public DoubleTimes getTimes() {
		return times;
	}
	
	@Override
	   public String toString() {
		if(lab == null) {
	      return super.toString() + " Section " + id + " " + type + " " + times + " " + prof + " " + location;
		}
		return super.toString() + " Section " + id + " " + type + " " + times + " " + prof + " " + location + ", Lab " + lab.toString(); 
	   }
	
	public void addClass(Section lab) {
		this.lab = lab;
		if(times != null) {
			times.setLabTime(lab.getLecTimes());
		}
	}

}
