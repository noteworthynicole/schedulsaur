package logic;

import org.mvel2.MVEL;

public class Prerequisites {
	
	public static void main(String[] args) {
		System.out.println(MVEL.eval("((true && false) || true) && true"));
	}
	
	//for each class, access their prerequisites
	//go to the user's account and access their list of prerequisites
	//replace the class with either true or false depending on if the user has taken the class
	//remove classes that don't meet prerequisites
}
