package Assignment1;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task4 extends BaseImplementation{
	// TODO Auto-generated method stub
    // Drag me to my target and drop on the target and verify the text.
	@Test(groups= {"mandatory","Assignment1"})
	 public void test4() throws IOException {
	    Task1 ob=new Task1();
	    Properties obj=ob.ReadObjectRepo();
	    WebDriver driver=ob.driver();
		driver.get("https://demoqa.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String dob=ob.ReadUserData("dob");
		WebElement element=driver.findElement(By.xpath(obj.getProperty("datepick")));
		element.sendKeys(dob);
		element.sendKeys(Keys.ENTER);
		System.out.println("Test Pass");
		driver.close();
		
		
		
	}

}

