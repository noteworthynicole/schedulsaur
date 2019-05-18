package logic;
import java.util.*;

public final class Section extends Class{
	
	private String num; //unique 4 numbers
	private String type; //lab or lec
	private Section lab; //if only lab, this is null
	private DoubleTimes times;
	private List<Class> prerec;
	private String prof;
	private String location;
	private int maxCapacity = 0;
	private int enrolled = 0;
	private int waitList = 0;
	private int id = 0;
	
	public Section(DoubleTimes times, List<String> fields) {
		super(fields.get(0));
		this.num = fields.get(1);
		this.type = fields.get(2);
		this.prof = fields.get(3);
		this.prerec = new ArrayList<>();
		this.times = times;
		this.location = fields.get(4);
		this.maxCapacity = getInteger(fields.get(5));
		this.enrolled = getInteger(fields.get(6));
		this.waitList = getInteger(fields.get(7));
		this.id = getInteger(fields.get(8));
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNum() {
		return this.num;
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
		} 
		catch(Exception e) { 
			return 0; 
		}
		return x;
	}
	
	//Only available if maxCapacity is greater than 0 and enrolled is less than maxCapacity
	public boolean isAvailable() {
		return maxCapacity > 0 && this.enrolled < this.maxCapacity;
	}

}