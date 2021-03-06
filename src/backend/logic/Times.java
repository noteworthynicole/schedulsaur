package logic;

import java.time.LocalTime;
import java.util.*;

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
		}else {
			this.startTime = LocalTime.of(0, 0);
			this.endTime = LocalTime.of(0, 0);
		}
		this.day = day;
	}
	
	public Times(String day, LocalTime startTime, LocalTime endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
    public Times(int day, int startTime){
        this.startTime = LocalTime.of(startTime, 0);
        this.endTime = LocalTime.of(startTime + 1, 0);
        this.day = daysOfTheWeek.get(day);
    }

    private static Map<Integer, String> daysOfTheWeek = new HashMap<>();
    
    static {
      daysOfTheWeek.put(1, "M");
      daysOfTheWeek.put(2, "T");
      daysOfTheWeek.put(3, "W");
      daysOfTheWeek.put(4, "R");
      daysOfTheWeek.put(5, "F");
    }
    
    protected static final Map<Character, Integer> daysToIndex = new HashMap<>();
    
    static {
      daysToIndex.put('M', 1);
      daysToIndex.put('T', 2);
      daysToIndex.put('W', 3);
      daysToIndex.put('R', 4);
      daysToIndex.put('F', 5);
    }
	
	public String getDay() {
		return day;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	private String getAM(int hour) {
		if(hour >= 12) {
			return "PM";
		}else {
			return "AM";
		}
	}
	
	public String getScheduleStart() {
		int hour = this.startTime.getHour();
		String milit = getAM(hour);
		if(hour > 12) {
			hour = hour - 12;
		}
		int minutes = this.startTime.getMinute();
		return hour + ":" + minutes + " " + milit;
	}

	public String getScheduleEnd() {
		int hour = this.endTime.getHour();
		String milit = getAM(hour);
		int minutes = this.endTime.getMinute();
		return hour + ":" + minutes + " " + milit;
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
		if(commonDays(time1.getDay(), time2.getDay())) {
			return (localToInt(time1.getEndTime()) <= localToInt(time2.getStartTime()) || 
				localToInt(time2.getEndTime()) <= localToInt(time2.getStartTime()));
		}
		return true;
	}
	
	private static int localToInt(LocalTime time) {
		return (time.getHour() * 60) + time.getMinute();
	}
	
	private static boolean commonDays(String day1, String day2) {
		if(day1.contains("N/A") || day2.contains("N/A")) {
			return true;
		}
		for(int i=0; i<day1.length(); i++) {
			if(day2.contains(day1.substring(i, i+1))) {
				return true;
			}
		}
		return false;
	}
	
	
}
