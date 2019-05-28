package logic;

import java.io.Serializable;

public class ScheduleRow implements Serializable{

		private static final long serialVersionUID = 1L;
		private String className;
		private String sec;
		private String classNum;
		private String instructor;
		private Integer open;
		private Integer reserved;
		private Integer taken;
		private Integer waitlist;
		private String status;
		private String days;
		private String start;
		private String end;


		public ScheduleRow(String[] fields) {
			this.setClassName(fields[0]);
			this.setSec(fields[1]);
			this.setClassNum(fields[2]);
			this.setInstructor(fields[3]);
			this.setOpen(Integer.parseInt(fields[4]));
			this.setReserved(Integer.parseInt(fields[5]));
			this.setTaken(Integer.parseInt(fields[6]));
			this.setWaitlist(Integer.parseInt(fields[7]));
			this.setStatus(fields[8]);
			this.setDays(fields[9]);
			this.setStart(fields[10]);
			this.setEnd(fields[11]);
		}
		
		@Override
		public String toString() {
			return className + " " + sec + " " + classNum + " " + instructor;
		}


		public String getClassName() {
			return className;
		}


		public void setClassName(String className) {
			this.className = className;
		}


		public String getSec() {
			return sec;
		}


		public void setSec(String sec) {
			this.sec = sec;
		}


		public String getClassNum() {
			return classNum;
		}


		public void setClassNum(String classNum) {
			this.classNum = classNum;
		}


		public String getInstructor() {
			return instructor;
		}


		public void setInstructor(String instructor) {
			this.instructor = instructor;
		}


		public Integer getOpen() {
			return open;
		}


		public void setOpen(Integer open) {
			this.open = open;
		}


		public Integer getReserved() {
			return reserved;
		}


		public void setReserved(Integer reserved) {
			this.reserved = reserved;
		}


		public Integer getTaken() {
			return taken;
		}


		public void setTaken(Integer taken) {
			this.taken = taken;
		}


		public Integer getWaitlist() {
			return waitlist;
		}


		public void setWaitlist(Integer waitlist) {
			this.waitlist = waitlist;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public String getDays() {
			return days;
		}


		public void setDays(String days) {
			this.days = days;
		}


		public String getStart() {
			return start;
		}


		public void setStart(String start) {
			this.start = start;
		}


		public String getEnd() {
			return end;
		}


		public void setEnd(String end) {
			this.end = end;
		}
}
