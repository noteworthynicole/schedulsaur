package logic;
import java.util.*;

public final class Section extends Class{
	
	private String id; //class department, number, and section
	private String type; //lab or lec
	private Section lab; //if only lab, this is null
	private DoubleTimes times;
	private List<Class> prerec;
	private String prof;
	private String location;
	private int maxCapacity = 0;
	private int enrolled = 0;
	private int waitList = 0;
	
	public Section(String name, String id, String type, List<Class> prerec, String prof, DoubleTimes times, String location) {
		super(name);
		this.id = id;
		this.type = type;
		this.prof = prof;
		this.prerec = prerec;
		this.times = times;
		this.location = location;
	}
	
	public Section(String name, String id, String type, String prof, DoubleTimes times, 
			String location, String maxCapacity, String enrolled, String waitList) {
		super(name);
		this.id = id;
		this.type = type;
		this.prof = prof;
		this.prerec = new ArrayList<>();
		this.times = times;
		this.location = location;
		this.maxCapacity = getInteger(maxCapacity);
		this.enrolled = getInteger(enrolled);
		this.waitList = getInteger(waitList);
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
	
	public static int getInteger(String s) {
		int x;
	    try { 
	       x = Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return 0; 
	    } catch(NullPointerException e) {
	        return 0;
	    }
	    return x;
	}

}
