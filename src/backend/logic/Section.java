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
	
	public Section(DoubleTimes times, List<String> fields) {
		super(fields.get(0), getInteger(fields.get(8)));
		this.num = fields.get(1);
		this.type = fields.get(2);
		this.prof = fields.get(3);
		this.prerec = new ArrayList<>();
		this.times = times;
		this.location = fields.get(4);
		this.maxCapacity = getInteger(fields.get(5));
		this.enrolled = getInteger(fields.get(6));
		this.waitList = getInteger(fields.get(7));
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
	      return super.toString() + " Section " + type + " " + times + " " + prof + " " + location;
		}
		return super.toString() + " Section " + type + " " + times + " " + prof + " " + location + ", Lab " + lab.toString(); 
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
	
	//Only available if maxCapacity is greater than 0 and enrolled is less than maxCapacity
	public boolean isAvailable() {
		return maxCapacity > 0 && this.enrolled < this.maxCapacity;
	}
	
	public void addToScheduleRow(List<ScheduleRow> rows) {
		String status;
		if(this.enrolled < this.maxCapacity) {
			status = "open";
		}else {
			status = "closed";
		}
		String open;
		if(this.maxCapacity - this.enrolled >= 0) {
			open = String.valueOf(this.maxCapacity - this.enrolled);
		}else {
			open = "0";
		}
		String[] fields = new String[12];
		fields[0] = this.getName();
		fields[1] = this.type;
		fields[2] = this.num;
		fields[3] = this.prof;
		fields[4] = String.valueOf(open);
		fields[5] = "0"; //No way to know reserved seats -\"_"/-
		fields[6] = String.valueOf(this.enrolled);
		fields[7] = String.valueOf(this.waitList);
		fields[8] = status;
		fields[9] = this.getLecTimes().getDay();
		fields[10] = this.getLecTimes().getScheduleStart();
		fields[11] = this.getLecTimes().getScheduleEnd();
		rows.add(new ScheduleRow(fields));
		if(this.lab != null) {
			this.lab.addToScheduleRow(rows);
		}
	}

}