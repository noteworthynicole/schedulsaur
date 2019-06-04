package logic;

public class Class {

	private String name;
	private int units = 4;
	private int id = 0;
	
	public Class(String name){
		this.name = name;
	}
	
	public Class(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getClassNum() {
		return this.getEqualName().split(" ")[1];
	}
	
	public String getEqualName() {
		if(this.name != null && this.name.length() >= 7) {
			return this.name.substring(0, 7);
		}
		return this.name;
	}
	
	public int getUnits() {
		return units;
	}
	
	public void setUnits(int units) {
		this.units = units;
	}
	
	@Override 
	public int hashCode() {
		int result = 31;
		result = result * this.name.hashCode();
		result = result * this.units;
		return result;
	}
	
	@Override
	public String toString() {
		return "Class " + name;
		
	}
		
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Class && this.getEqualName().equals(((Class)obj).getEqualName()) && this.units == ((Class)obj).getUnits();
	}
}
