package logic;

import java.io.Serializable;

public class Schedule implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8199449646849222720L;
	private ScheduleRow[] rows;
	private ScheduleBlock time;
	
	public Schedule(ScheduleRow[] rows, ScheduleBlock time) {
		this.setRows(rows);
		this.setTime(time);
	}

	public ScheduleRow[] getRows() {
		return rows;
	}

	public void setRows(ScheduleRow[] rows) {
		this.rows = rows;
	}

	public ScheduleBlock getTime() {
		return time;
	}

	public void setTime(ScheduleBlock time) {
		this.time = time;
	}

}
