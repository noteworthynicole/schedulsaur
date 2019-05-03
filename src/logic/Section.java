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
	
	public Section(DoubleTimes times, List<String> fields) {
		super(fields.get(0));
		this.id = fields.get(1);
		this.type = fields.get(2);
		this.prof = fields.get(3);
		this.prerec = new ArrayList<>();
		this.times = times;
		this.location = fields.get(4);
		this.maxCapacity = getInteger(fields.get(5));
		this.enrolled = getInteger(fields.get(6));
		this.waitList = getInteger(fields.get(7));
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
	
	public int getMaxCapacity() {
		return maxCapacity;
	}

	public int getWaitList() {
		return waitList;
	}

	public int getEnrolled() {
		return enrolled;
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
	    } catch(Exception e) { 
	        return 0; 
	    }
	    return x;
	}

}
