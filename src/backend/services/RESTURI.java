package services;

public class RESTURI {
	
	private RESTURI() {
		throw new IllegalStateException("Utility class");
	}
	
	public static final String EXTERNAL_DOMAIN = "http://localhost:3000";
	
	public static final String GET_SAMPLE_USER = "/hello";
	public static final String POST_USER = "/user";
	
	public static final String GET_SAMPLE_BLOCK = "/avail";
	public static final String POST_BLOCK = "/block";
	
	/*
	* URIs for Schedulsaur
	*/
	
	public static final String SIGN_UP = "/Signup";
	public static final String ABOUT = "/About";
	public static final String DASHBOARD = "/Dashboard";
	public static final String HISTORY = "/CourseHistory";
	public static final String TIME_AVAIL = "/TimeAvailability";
	public static final String DESIRED = "/DesiredCourses";
	public static final String CREATE = "/CreateSchedules";
	public static final String SAVED = "/SavedSchedules";
	public static final String HELP = "/Help";
	
}
