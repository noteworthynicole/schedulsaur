package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Times;

public class TestTimeBlock {

	@Test
	public void createTime1() {
		Times myTime = new Times(1, 9);
		assertTrue(myTime.toString().contains("M"));
	}
	
	@Test
	public void createTime2() {
		Times myTime = new Times(1, 7);
		assertTrue(myTime.toString().contains("7") && myTime.toString().contains("8"));
	}
	
	@Test
	public void createTime3() {
		Times myTime = new Times(5, 15);
		assertTrue(myTime.toString().contains("F"));
	}
	
	@Test
	public void createTime4() {
		Times myTime = new Times(4, 12);
		assertTrue(myTime.toString().contains("12") && myTime.toString().contains("13"));
	}
	
	

}
