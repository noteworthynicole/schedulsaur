package logic;

import java.time.LocalTime;

public class Times {

	public LocalTime startTime;
	public LocalTime endTime;
	public String day;
	
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
	
	@Override
	   public String toString() {
	      return "Time " + day + " " + startTime + " " + endTime + ")";
	   }
	
	public boolean overlap(Times other) {
		if(this.day.contains(other.day) || other.day.contains(this.day)) {
			//Compare to returns negative is less, positive if greater
			//if endtime of this is before the starttime of the other or vice versa they don't overlap
			//FIX THIS!!
			if(other.startTime.compareTo(this.endTime) < 1 || this.startTime.compareTo(other.endTime) < 1) {
				return true;
			}
			//need a better way to extract the time ... function to convert the string to an 24hr int?
			//if this.start is equal to other.start or this.end is equal to other.end -> true
			//if this.end is before other.start or other.end is before this.start -> false (double check this)
			return false;
		}
		return false;
	}
}
