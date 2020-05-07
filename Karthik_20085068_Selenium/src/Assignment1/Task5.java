package Assignment1;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Task5 extends BaseImplementation{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       // Drag me to my target and drop on the target and verify the text.
		Task5 ob=new Task5();
		Properties obj=ob.ReadObjectRepo();
		WebDriver driver=ob.driver();
		driver.get("https://demoqa.com/selectmenu/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement speed1=driver.findElement(By.xpath(obj.getProperty("selectspeed")));
		List<WebElement> l=driver.findElements(By.xpath(obj.getProperty("speeddropdownselect")));
		for(WebElement e:l)
		{
			if(e.getText().equalsIgnoreCase("Fast"))
				e.click();
		}
		driver.findElement(By.xpath(obj.getProperty("speeddropdownselect"))).click();
		System.out.println("Selected speed: "+speed1.getText());
		WebElement file=driver.findElement(By.xpath(obj.getProperty("selectfile")));
		Select f=new Select(file);
		f.selectByIndex(1);
		WebElement number=driver.findElement(By.xpath(obj.getProperty("selectnumber")));
		Select no=new Select(number);
		no.selectByVisibleText("5");
		WebElement title=driver.findElement(By.xpath(obj.getProperty("selecttitle")));
		Select ti=new Select(title);
		ti.selectByValue("Mrs.");
		driver.close();
		
		
		
	}

}

