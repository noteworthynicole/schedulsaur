package logic;

import java.time.LocalTime;

public class DoubleTimes {
	private Times lecTimes;
	private Times labTimes;
	
	public DoubleTimes(String day, String startTime, String endTime) {
		this.lecTimes = new Times(day, startTime, endTime);
	}
	
	public Times getLecTimes() {
		return lecTimes;
	}
	
	public Times getLabTimes() {
		return labTimes;
	}
	
	public String getLecDay() {
		return lecTimes.getDay();
	}
	
	public LocalTime getLecStartTime() {
		return lecTimes.getStartTime();
	}
	
	public LocalTime getLecEndTime() {
		return lecTimes.getEndTime();
	}
	
	@Override
	   public String toString() {
	      return "DoubleTimes Lec: " + lecTimes + " Lab: " + labTimes;
	   }
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof DoubleTimes && this.lecTimes.equals(((DoubleTimes) other).getLecTimes())) {
			if(this.labTimes != null) {
				return this.labTimes.equals(((DoubleTimes) other).getLabTimes());
			}
			return (((DoubleTimes) other).getLabTimes()) == null;
		}
		return false;
	}
	
	public void setLabTime(Times time) {
		this.labTimes = time;
	}
	
	public boolean compatible(DoubleTimes other) {
		boolean result = Times.compatible(this.lecTimes, other.getLecTimes());
		result = result && Times.compatible(this.lecTimes, other.getLabTimes());
		result = result && Times.compatible(this.labTimes, other.getLecTimes());
		result = result && Times.compatible(this.labTimes, other.getLabTimes());
		return result;
	}

	public int compareTo(DoubleTimes other) {
		LocalTime t1 = getLecStartTime();
		LocalTime t2 = other.getLecStartTime();
		if(t1.equals(t2)) {
			return getLecDay().compareTo(other.getLecDay());
		}
		return t1.compareTo(t2);
	}
	
	@Override 
	public int hashCode() {
        int result = 31;
        result = result * lecTimes.hashCode();
        if(labTimes != null) {
        	result = result * labTimes.hashCode();
        }
        return result;
    }
	
	
}
