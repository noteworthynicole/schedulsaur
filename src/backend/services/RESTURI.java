package services;

public class RESTURI {
	
	public static void main(String[] args) {
		
	}
	
	private RESTURI() {
		throw new IllegalStateException("Utility class");
	}
	
	public static final String EXTERNAL_DOMAIN = "http://localhost:3000";
	
	public static final String GET_SAMPLE_USER = "/hello";
	public static final String POST_USER = "/user";

}
