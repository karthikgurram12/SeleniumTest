package Assignment1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

public class Task2 extends BaseImplementation{
		// TODO Auto-generated method stub
		//Please fill this contact form using CSS and Xpath.
	WebDriver driver=null;
	@Test(groups= {"mandatory","Assignment1"})
public void test2() throws IOException {
    Task1 ob=new Task1();
	Properties obj=ob.ReadObjectRepo();
	 driver=ob.driver();
	driver.get("https://demoqa.com/html-contact-form/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	String fn="",sn="",country="",subject="";	
	String[] str=ob.ReadData("normal");
	fn=str[1];sn=str[2];country=str[3];subject=str[4];
	System.out.println(str.length);
	driver.findElement(By.xpath(obj.getProperty("firstname"))).sendKeys(fn);
	driver.findElement(By.xpath(obj.getProperty("secondname"))).sendKeys(sn);
	driver.findElement(By.xpath(obj.getProperty("country"))).sendKeys(country);
	driver.findElement(By.xpath(obj.getProperty("subjectLine"))).sendKeys(subject);
	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
	driver.findElement(By.linkText(obj.getProperty("googlelink"))).sendKeys(selectLinkOpeninNewTab);
	driver.findElement(By.linkText(obj.getProperty("googlelink2"))).sendKeys(selectLinkOpeninNewTab);
	driver.findElement(By.xpath(obj.getProperty("Submitbutton"))).click();
	System.out.println("Test pass");	 
	}
	@AfterTest
	public void driverclose()
	{
		driver.close();
	}

}
