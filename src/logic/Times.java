package logic;

import java.time.LocalTime;

public class Times {

	private LocalTime startTime;
	private LocalTime endTime;
	private String day;
	
	public Times(String day, String startTime, String endTime) {
		if(!startTime.contains("N/A")) {
			this.startTime = LocalTime.parse(startTime.substring(0, 5));
			if(startTime.contains("PM") && this.startTime.getHour() != 12) {
				this.startTime = this.startTime.plusHours(12);
			}
			this.endTime = LocalTime.parse(endTime.substring(0, 5));
			if(endTime.contains("PM") && this.endTime.getHour() != 12) {
				this.endTime = this.endTime.plusHours(12);
			}
		}
		this.day = day;
	}
	
	public Times(String day, LocalTime startTime, LocalTime endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getDay() {
		return day;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	
	@Override
	   public String toString() {
	      return "(Time " + day + " " + startTime + " " + endTime + ")";
	   }

	@Override
	public boolean equals(Object other) {
		return other instanceof Times && this.day.equals(((Times) other).getDay()) 
				&& this.startTime.equals(((Times) other).getStartTime()) 
				&& this.endTime.equals(((Times) other).getEndTime());
	}
	
	@Override
	public int hashCode() {
        int result = 31;
        result = result * day.hashCode();
        if(startTime != null) {
        	result = result * (startTime.getHour() + startTime.getMinute());
        }
        if(endTime != null) {
        	result = result * (endTime.getHour() + endTime.getMinute());
        }
        return result;
	}
	
	public static boolean compatible(Times time1, Times time2) {
		if(time1 == null || time2 == null) {
			return true;
		}
		return (localToInt(time1.getEndTime()) <= localToInt(time2.getStartTime()) || 
				localToInt(time2.getEndTime()) <= localToInt(time2.getStartTime()));
	}
	
	public static int localToInt(LocalTime time) {
		return (time.getHour() * 60) + time.getMinute();
	}
}
