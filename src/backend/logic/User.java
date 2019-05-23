package logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	private String name;
	private String major;
	private String minor;
	
	private String catalogYear;
	private String planningQuarter;
	
	private int unitsPerQuarter;
	
	
	/* Annotations so that JSON strings can be mapped to User objects */
	@JsonCreator
	public User(@JsonProperty("name")String name,
			@JsonProperty("major") String major,
			@JsonProperty("minor") String minor,
			@JsonProperty("catalogYear") String catalogYear,
			@JsonProperty("planningQuarter") String planningQuarter,
			@JsonProperty("unitsPerQuarter") Integer unitsPerQuarter) {
		this.name = name;
		this.major = major;
		this.minor = minor;
		this.catalogYear = catalogYear;
		this.planningQuarter = planningQuarter;
		this.unitsPerQuarter = unitsPerQuarter;
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


	public int getUnitsPerQuarter() {
		return unitsPerQuarter;
	}


	public void setUnitsPerQuarter(int unitsPerQuarter) {
		this.unitsPerQuarter = unitsPerQuarter;
	}
	
}
