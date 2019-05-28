package logic;

import java.io.Serializable;

public final class ScheduleBlock implements Serializable {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = -1438795722467582123L;
/*
   * blocks contains a table of true/false values
   * gets from FrontEnd and Database
   * true = 1
   * false = 0
   * true / 1 means the time is open
   * false / 0 means the time is blocked
   */
   private boolean[][] blocks;
   private String[] days;
   private int availNum;
   private int studentId;
   
   public ScheduleBlock(int studentId, int availNum, String[] days, boolean[][] blocks) {
      this.blocks = blocks;
      this.days = days;
      this.availNum = availNum;
      this.studentId = studentId;
   }
   
   public boolean[][] getBlocks() {
	   return blocks;
   }
   
   public String[] getDays() {
	   return days;
   }
   
   public int getAvailNum() {
	   return availNum;
   }
   
   public int getStudentId() {
	   return studentId;
   }

   /* 
   * Transfers Boolean[]][] format from FrontEnd
   * to Database format in String[]
   */
   public String[] toDBFormat() {
      String[] hours = new String[7];
      StringBuilder bld = new StringBuilder();
      for (int i = 0; i < blocks.length; i++) {
         for (boolean b : blocks[i]) {
            if (b) {
               bld.append("1");
            } else {
               bld.append("0");
            }
         }
         hours[i] = bld.toString();
      }
      return hours;
   }

   /* 
   * Transfers String[] format from Database
   * to FrontEnd format in Boolean[][]
   */
   public boolean[][] toFEFormat(String[] hours) {
	   boolean[][] newBlocks = new boolean[7][15];
	   for (int i = 0; i < hours.length; i++) {
		   for (int j = 0; j < hours[i].length(); j++) {
			   char c = hours[i].charAt(j);
			   if (c == '1') {
				   newBlocks[i][j] = true;
			   } else {
				   newBlocks[i][j] = false;
			   }
		   }
	   }
	   return newBlocks;
   }

}