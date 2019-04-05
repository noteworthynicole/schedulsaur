import java.util.*;

public class Section extends Class{
	
	public Section(String name, ArrayList<Class> prerec) {
		super(name, prerec);
		// TODO Auto-generated constructor stub
	}
	public String name;
	public List<Class> prerec;
	public List<Times> times;
	public String prof;
	public String location;
	
	/*public Section(String name,List<Times> times, String prof, String location){
		this.name = name;
		this.prerec = prerec;
		this.times = times;
		this.prof = prof;
		this.location = location;
	}*/

}
