package logic;

import java.util.*;
import java.util.logging.*;

import org.mvel2.MVEL;

public class Catalog extends Class{
	
	private static final Logger logger = Logger.getLogger("Catalog");

	private String nameDescr;
	private String credit;
	private String terms;
	private String prereqs;
	private int id; 
	
	public Catalog(List<String> fields){
		super(fields.get(0));
		this.nameDescr = fields.get(1);
		this.setUnits(Integer.parseInt(fields.get(2).substring(0, 1)));
		this.credit = fields.get(3);
		this.terms = fields.get(4);
		if(fields.get(5).isEmpty()) {
			this.prereqs = "true";
		}else {
			this.prereqs = fields.get(5);
		}
		this.id = Integer.parseInt(fields.get(6));
	}
	
	@Override
   public String toString() {
      return this.getEqualName() + " " + nameDescr + " " + prereqs;
   }
	
   public boolean getPrereq(List<String> classesTaken) {
	   while(prereqs.matches(".*\\d.*")){
		   prereqs = replaceWithBoolean(classesTaken);
	   }
		return (boolean) MVEL.eval(prereqs);
   }
   
   private String replaceWithBoolean(List<String> classesTaken) {
	   String[] split = prereqs.split("( )"); 
	   for(int i = 0; i < split.length; i++) {
		   if(!split[i].contains("true") && !split[i].contains("false") 
				   && !split[i].contains("|") && !split[i].contains("&")) {
			   String potentialClass = split[i] + " " + split[i + 1];
			   if(classesTaken.contains(potentialClass)) {
				   return prereqs.replace(potentialClass, "true");
			   }else {
				   return prereqs.replace(potentialClass, "false");
			   }
		   }
	   }
	   return prereqs;
   }
	
}
