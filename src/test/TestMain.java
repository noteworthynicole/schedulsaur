package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import logic.Main;

public class TestMain {
	
	@SuppressWarnings("static-access")
	@Test
	public void testMain() throws FileNotFoundException {
		Main main = new Main();
		String[] args = {"testfile.csv"};
		main.main(args);
		assertTrue(true);
	}

}
