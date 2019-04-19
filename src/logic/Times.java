package logic;
public class Times {

	public String startTime;
	public String endTime;
	public String day;
	
	public Times(String day, String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}
	
	@Override
	   public String toString() {
	      return "Time " + day + " " + startTime + " " + endTime + ")";
	   }
	
	public boolean overlap(Times other) {
		if(this.day.contains(other.day) || other.day.contains(this.day)) {
			//need a better way to extract the time ... function to convert the string to an 24hr int?
			//if this.start is equal to other.start or this.end is equal to other.end -> true
			//if this.end is before other.start or other.end is before this.start -> false (double check this)
			return true;
		}
		return false;
	}
}
