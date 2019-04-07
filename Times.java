import java.util.Arrays;

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
	      return "(Time " + day + " " + startTime + " " + endTime + ")";
	   }
}
