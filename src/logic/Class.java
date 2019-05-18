package logic;
import java.util.*;

public class Class {

	private String name;
	private List<Class> prerec;
	private int units = 4;
	
	public Class(String name, List<Class> prerec2){
		this.name = name;
		this.prerec = prerec2;
	}
	
	public Class(String name){
		this.name = name;
		this.prerec = new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
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
		if(!prerec.isEmpty()) {
			return "Class " + name + " " + Arrays.toString(prerec.toArray());
		} else {
			return "Class " + name;
		}
	}
		
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Class && this.getEqualName().equals(((Class)obj).getEqualName()) && this.units == ((Class)obj).getUnits();
	}
}
