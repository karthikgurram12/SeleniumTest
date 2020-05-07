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

public class Task4 extends BaseImplementation{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       // Drag me to my target and drop on the target and verify the text.
		Task4 ob=new Task4();
		Properties obj=ob.ReadObjectRepo();
		WebDriver driver=ob.driver();
		driver.get("https://demoqa.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String dob="11/12/1998";
		WebElement element=driver.findElement(By.id(obj.getProperty("datepick")));
		element.sendKeys(dob);
		element.sendKeys(Keys.ENTER);
		System.out.println("Test Pass");
		driver.close();
		
		
		
	}

}

