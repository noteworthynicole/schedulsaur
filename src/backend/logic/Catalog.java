package logic;

import java.util.*;

import org.mvel2.MVEL;

public class Catalog extends Class{
	
	private static String digits = ".*\\d.*";

	private String nameDescr;
	private String credit;
	private String terms;
	private String prereqs;
	
	public Catalog(List<String> fields){
		super(fields.get(0));
		this.nameDescr = fields.get(1);
		this.setUnits(Integer.parseInt(fields.get(2).substring(0, 1)));
		this.credit = fields.get(3);
		this.terms = fields.get(4);
		if(fields.get(5).isEmpty()) {
			this.prereqs = "true";
		}else {
			this.prereqs = fields.get(5).trim().replaceAll("[\\u00A0\\u2007\\u202F]+", " ");
		}
		this.setId(Integer.parseInt(fields.get(6)));
	}
	
	@Override
   public String toString() {
      return this.getEqualName() + " " + nameDescr + " " + prereqs;
   }
	
   public boolean getPrereq(List<String> classesTaken) {
	   while(prereqs.matches(digits)){
		   prereqs = replaceWithBoolean(classesTaken);
	   }
		return (boolean) MVEL.eval(prereqs);
   }
   
   private String replaceWithBoolean(List<String> classesTaken) {
	   String noParen = prereqs.replace("(", "").replace(")", "");
	   String[] split = noParen.split(" "); 
	   for(int i = 0; i < split.length; i++) {
		   if(!split[i].contains("true") && !split[i].contains("false") 
				   && !split[i].contains("|") && !split[i].contains("&")
				   && !split[i].contains("or") && !split[i].contains("and")) {
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
   
   public String getCredit() {
	   return credit;
   }
   
   public String getTerms() {
	   return terms;
   }
	
}
