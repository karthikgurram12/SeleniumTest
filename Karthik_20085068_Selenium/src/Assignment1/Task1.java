package Assignment1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 extends BaseImplementation{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
       //Create a xpath or Css path for this Selectable Item and Click on each of the Items and print the Item Name
		Task1 ob=new Task1();
		Properties obj=ob.ReadObjectRepo();
		WebDriver driver=ob.driver();
		driver.get("https://demoqa.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		List<WebElement> list=driver.findElements(By.xpath(obj.getProperty("SelectableItem")));
		for (WebElement webElement : list) {
            String name = webElement.getText();
            System.out.println(name);
		}
		System.out.println("Test Pass");
		driver.close();
	}

}
