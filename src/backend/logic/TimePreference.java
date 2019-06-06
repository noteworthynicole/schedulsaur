package logic;

import java.io.Serializable;

public class TimePreference implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2252774678801624385L;
	private String studentId;
	private String availNum;
	private String timeName;
	
	public TimePreference() {}
	
	public TimePreference(String studentId, String availNum, String timeName) {
		this.studentId = studentId;
		this.availNum = availNum;
		this.timeName = timeName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getAvailNum() {
		return availNum;
	}

	public void setAvailNum(String availNum) {
		this.availNum = availNum;
	}

	public String getTimeName() {
		return timeName;
	}

	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}
	
	public String[] getAllFields() {
		return new String[] {studentId, availNum, timeName};
	}
	
}
