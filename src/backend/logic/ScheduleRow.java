package backend.logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleRow {
	
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

	@JsonCreator
	public ScheduleRow(@JsonProperty("className") String className,
			@JsonProperty("sec") String sec,
			@JsonProperty("classNum") String classNum,
			@JsonProperty("instructor") String instructor,
			@JsonProperty("open") Integer open,
			@JsonProperty("reserved") Integer reserved,
			@JsonProperty("taken") Integer taken,
			@JsonProperty("waitlist") Integer waitlist,
			@JsonProperty("status") String status,
			@JsonProperty("days") String days,
			@JsonProperty("start") String start,
			@JsonProperty("end") String end) {
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
