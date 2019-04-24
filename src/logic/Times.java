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
	
	public boolean overlap(Times other) {
		if(this.day.contains(other.day) || other.day.contains(this.day)) {
			//Compare to returns negative is less, positive if greater
			//if endtime of this is before the starttime of the other or vice versa they don't overlap
			//FIX THIS!!
			return (other.startTime.compareTo(this.endTime) < 1 && other.endTime.compareTo(this.endTime) < 1)
					|| (this.startTime.compareTo(other.endTime) < 1 && this.endTime.compareTo(other.endTime) < 1);
		}
		//need a better way to extract the time ... function to convert the string to an 24hr int?
		//if this.start is equal to other.start or this.end is equal to other.end -> true
		//if this.end is before other.start or other.end is before this.start -> false (double check this)
		return false;
	}
}
