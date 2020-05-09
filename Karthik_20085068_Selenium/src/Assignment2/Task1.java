package Assignment2;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Assignment1.BaseImplementation;

public class Task1 extends BaseImplementation{
	@Test
	public void test1() throws IOException, InterruptedException {
	Task1 ob=new Task1();
	Properties obj=ob.ReadObjectRepo();
	WebDriver driver=ob.driver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

}
