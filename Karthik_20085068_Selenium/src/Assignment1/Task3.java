package Assignment1;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task3 extends BaseImplementation{

		// TODO Auto-generated method stub
       // Drag me to my target and drop on the target and verify the text.
		@Test
		public void test3() throws IOException {
		Task1 ob=new Task1();
		Properties obj=ob.ReadObjectRepo();
		WebDriver driver=ob.driver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		 WebElement drag = driver.findElement(By.id(obj.getProperty("Dragme")));
		 WebElement drop = driver.findElement(By.id(obj.getProperty("Drophere"))); 
		 act.dragAndDrop(drag, drop).perform();
		 String textTo = drop.getText();
		 if(textTo.equals("Dropped!")) {
		 System.out.println("TEST PASS");
		}else {
		System.out.println("TEST FAIL");
		}
		 driver.close();
		
	}

}
