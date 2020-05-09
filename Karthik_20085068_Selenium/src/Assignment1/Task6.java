package Assignment1;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task6 {
	
	@Test
	@Parameters({ "sUsername", "sPassword" })
	public void test6() throws IOException {
	Task1 ob=new Task1();
	Properties obj=ob.ReadObjectRepo();
	WebDriver driver=ob.driver();
	driver.get("https://demoqa.com/controlgroup/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//horizental rental car
	WebElement ct=driver.findElement(By.id(obj.getProperty("cartype")));
    ct.click();
    List<WebElement> l=driver.findElements(By.xpath(obj.getProperty("selectcartype")));
	for(WebElement e:l)
	{
		if(e.getText().equalsIgnoreCase(ob.ReadUserData("cartype")))
			e.click();
	}
	Assert.assertTrue(ct.getText().equalsIgnoreCase(ob.ReadUserData("cartype")));
	//selecting standard in horizental buy now
	WebElement standardcheck=driver.findElement(By.xpath(obj.getProperty("standardcar1")));
	if(!(standardcheck.isSelected()))
		standardcheck.click();
	//checking the insurance checkbox
	WebElement insurancecheck=driver.findElement(By.xpath(obj.getProperty("insurance1")));
	if(!(insurancecheck.isSelected()))
		insurancecheck.click();
	WebElement horizentalspin=driver.findElement(By.id(obj.getProperty("horizentalspinner")));
	horizentalspin.sendKeys(ob.ReadUserData("hnoofcars"));
	driver.findElement(By.xpath(obj.getProperty("horizentalbuynow"))).click();
	//vertical rental car
	WebElement ct2=driver.findElement(By.id(obj.getProperty("cartype2")));
    ct2.click();
    List<WebElement> l2=driver.findElements(By.xpath(obj.getProperty("selectcartype2")));
	for(WebElement e:l2)
	{
		if(e.getText().equalsIgnoreCase(ob.ReadUserData("cartype2")))
			e.click();
	}
	Assert.assertTrue(ct2.getText().equalsIgnoreCase(ob.ReadUserData("cartype2")));
	//selecting Automatic in horizental buy now
	WebElement automaticcheck1=driver.findElement(By.xpath(obj.getProperty("automaticcar2")));
	if(!(automaticcheck1.isSelected()))
		automaticcheck1.click();
	WebElement insurancecheck1=driver.findElement(By.xpath(obj.getProperty("insurance2")));
	if(!(insurancecheck1.isSelected()))
		insurancecheck1.click();
	WebElement verticalspin=driver.findElement(By.id(obj.getProperty("verticalspinner")));
	verticalspin.sendKeys(ob.ReadUserData("vnoofcars"));
	driver.findElement(By.xpath(obj.getProperty("verticalbuynow"))).click();
	driver.close();
	}

}
