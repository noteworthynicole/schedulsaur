package logic;

import java.io.Serializable;


public class ScheduleRow implements Serializable {
	
	/**
	 *  In order to implement Serializable
	 */
	private static final long serialVersionUID = -8593901929846593946L;

	private String className;
	private String sec;
	private String classNum;
	private String instructor;
	private Integer open;
	private Integer reserved;
	private Integer taken;
	private Integer waitlist;
	private String status;
	private String days;
	private String start;
	private String end;

	
	public ScheduleRow(String className, String sec, String classNum, String instructor,
						Integer open, Integer reserved, Integer taken, Integer waitlist,
						String status, String days, String start, String end) {
		this.setClassName(className);
		this.setSec(sec);
		this.setInstructor(instructor);
		this.setOpen(open);
		this.setReserved(reserved);
		this.setTaken(taken);
		this.setWaitlist(waitlist);
		this.setStatus(status);
		this.setDays(days);
		this.setStart(start);
		this.setEnd(end);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSec() {
		return sec;
	}

	public void setSec(String sec) {
		this.sec = sec;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public Integer getOpen() {
		return open;
	}

	public void setOpen(Integer open) {
		this.open = open;
	}

	public Integer getReserved() {
		return reserved;
	}

	public void setReserved(Integer reserved) {
		this.reserved = reserved;
	}

	public Integer getTaken() {
		return taken;
	}

	public void setTaken(Integer taken) {
		this.taken = taken;
	}

	public Integer getWaitlist() {
		return waitlist;
	}

	public void setWaitlist(Integer waitlist) {
		this.waitlist = waitlist;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
}

