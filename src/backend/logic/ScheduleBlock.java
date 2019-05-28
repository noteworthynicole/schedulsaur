package logic;

public final class ScheduleBlock {
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
      for (int i = 0; i < blocks.length; i++) {
         String avail = "";
         for (boolean b : blocks[i]) {
            if (b) {
               avail += "1";
            } else {
               avail += "0";
            }
         }
         hours[i] = avail;
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