package test;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
class TestSelenium {
	String driverDir = "Drivers/chromedriver";
	String driverProp = "webdriver.chrome.driver";
	String VAL = "value";
	String disabled = "disabled";


	@Test
	void testSaveDashboard() {
		String dashboardSave = "//*[@id=\"root\"]/div/div/div[3]/div/div[2]/div[2]/button[2]";
		String dashboardEdit = "//*[@id=\"root\"]/div/div/div[3]/div/div[2]/div[2]/button[1]";
		String dashboardInputMajor = "//*[@id=\"type0\"]";
		String dashboardMajor = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div[2]/div/div[2]/div[1]/span";
		
		System.setProperty(driverProp,driverDir);   
		WebDriver driver = new ChromeDriver();
		driver.get("localhost:3000/DashBoard");
		
		driver.findElement(By.xpath(dashboardEdit)).click();
		driver.findElement(By.xpath(dashboardInputMajor)).sendKeys("Computer Science");	
		driver.findElement(By.xpath(dashboardSave)).click();
		
		WebElement majorBox = driver.findElement(By.xpath(dashboardMajor));
		String value = majorBox.getAttribute(VAL);

		assertTrue(value.equals("ComputerScience"));
		
	}
	
	@Test
	void testCourseHistory() {
		String checkBox = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div/div[2]/div/div/div[2]/div[1]/label/span/span";
		String checkBox2 = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div/div[2]/div/div/div[7]/div[1]/label/span/span";
		String checkBox3 = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div/div[1]/div/div/div[7]/div[1]/label/span/span";
		String desiredCourses = "//*[@id=\"root\"]/div/div/div[2]/a[4]";
		String desiredBox = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div/div[2]/div/div/div[7]/div[1]/label";
		String desiredBox2 = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div/div[1]/div/div/div[6]/div[1]/label/span";
		String desiredBox3 = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div/div[1]/div/div/div[2]/div[1]/label/span";
		
		System.setProperty(driverProp,driverDir);   
		WebDriver driver = new ChromeDriver();
		driver.get("localhost:3000/CourseHistory");
		
		driver.findElement(By.xpath(checkBox)).click();
		driver.findElement(By.xpath(checkBox2)).click();
		driver.findElement(By.xpath(checkBox3)).click();
		driver.findElement(By.xpath(desiredCourses)).click();
		
		WebElement desired = driver.findElement(By.xpath(desiredBox));
		String value = desired.getAttribute(disabled);
		
		WebElement desired2 = driver.findElement(By.xpath(desiredBox2));
		String value2 = desired2.getAttribute(disabled);

		WebElement desired3 = driver.findElement(By.xpath(desiredBox3));
		String value3 = desired3.getAttribute(disabled);
		
		assertTrue(value.equals(true));
		assertTrue(value2.equals(true));
		assertTrue(value3.equals(true));

		
	}
	
	@Test
	void testTimeAvailability() {
		String timeField = "//*[@id=\"root\"]/div/div/div[3]/div/div[2]/div[1]/div[2]/table/tbody/tr[3]/td[5]";
		String timeField2 = "//*[@id=\"root\"]/div/div/div[3]/div/div[2]/div[1]/div[2]/table/tbody/tr[3]/td[6]";
		String timeField3 = "//*[@id=\"root\"]/div/div/div[3]/div/div[2]/div[1]/div[2]/table/tbody/tr[3]/td[7]";
		String save = "//*[@id=\"root\"]/div/div/div[3]/div/div[2]/div[2]/button[2]";
		String confirm = "//*[@id=\"root\"]/div/div/div[3]/div/div[2]/div[2]/div[2]/div/div/form/button";
		String noOptions = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div/ul";
		
		System.setProperty(driverProp,driverDir);   
		WebDriver driver = new ChromeDriver();
		driver.get("localhost:3000/TimeAvailability");
		
		driver.findElement(By.xpath(timeField)).click();
		driver.findElement(By.xpath(timeField2)).click();
		driver.findElement(By.xpath(timeField3)).click();
		driver.findElement(By.xpath(save)).click();
		driver.findElement(By.xpath(confirm)).click();
		
		WebElement listElem = driver.findElement(By.xpath(noOptions));
		String value = listElem.getAttribute(VAL);
		assertTrue(value.equals(null));
		
	}

	@Test
	void saveSchedule() {
		String saveSchedule = "//*[@id=\"root\"]/div/div/div[3]/div/div[2]/button";
		String emptyList = "//*[@id=\"root\"]/div/div/div[3]/div/div[1]/div/div[1]";
		
		System.setProperty(driverProp,driverDir);   
		WebDriver driver = new ChromeDriver();
		driver.get("localhost:3000/CreateSchedules");
		
		driver.findElement(By.xpath(saveSchedule)).click();
		
		WebElement listElem = driver.findElement(By.xpath(emptyList));
		String value = listElem.getAttribute(VAL);
		assertTrue(value.equals(null));
		
	}
	

}
