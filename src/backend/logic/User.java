package logic;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 *  needed to implement Serializable
	 */
	private static final long serialVersionUID = -4730815592596337568L;
	private String id;
	private String name;
	private String major;
	private String minor;
	private String catalogYear;
	private String planningQuarter;
	private String unitsThisQuarter;
	private String email;
	private String password;
	private String previousClasses;
	
	
	// requred by for JsonMapping
	public User() {}
	
	public User(String[] fields) {
		this.id = fields[0];
		this.name = fields[1];
		this.major = fields[2];
		this.minor = fields[3];
		this.catalogYear = fields[4];
		this.planningQuarter = fields[5];
		this.unitsThisQuarter = fields[6];
		this.email  = fields[7];
		this.password = fields[8];
		this.previousClasses = fields[9];
	}
	
	public User(String id, String name, String major, String minor, String catalogYear, 
				String unitsPerQuarter, String unitsThisQuarter) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.minor = minor;
		this.catalogYear = catalogYear;
		this.planningQuarter = unitsPerQuarter;
		this.unitsThisQuarter = unitsThisQuarter;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getCatalogYear() {
		return catalogYear;
	}

	public void setCatalogYear(String catalogYear) {
		this.catalogYear = catalogYear;
	}

	public String getPlanningQuarter() {
		return planningQuarter;
	}

	public void setPlanningQuarter(String planningQuarter) {
		this.planningQuarter = planningQuarter;
	}

	public String getUnitsThisQuarter() {
		return unitsThisQuarter;
	}

	public void setUnitsThisQuarter(String unitsThisQuarter) {
		this.unitsThisQuarter = unitsThisQuarter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPreviousClasses() {
		return previousClasses;
	}

	public void setPreviousClasses(String previousClasses) {
		this.previousClasses = previousClasses;
	}
	
	public String[] getAllFields() {
		return new String[] {id, name, major, minor, catalogYear, planningQuarter, unitsThisQuarter, email, password, previousClasses};
	}
	
	public String[] getSubsetFields() {
		return new String[] {name, major, minor, catalogYear, planningQuarter, unitsThisQuarter};
	}
	
}
