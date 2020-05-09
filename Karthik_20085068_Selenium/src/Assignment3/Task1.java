package Assignment3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
	//selecting trip round trip option
	driver.findElement(By.xpath(obj.getProperty("tripoption"))).click();
	driver.findElement(By.id(obj.getProperty("FromCity"))).click();
    driver.findElement(By.xpath(obj.getProperty("FirstOptioninfromcity"))).click();
    driver.findElement(By.xpath(obj.getProperty("ToCity"))).click();
    driver.findElement(By.xpath(obj.getProperty("secondoptionintocity"))).click();
    driver.findElement(By.xpath(obj.getProperty("Departure"))).click();
        driver.findElement(By.xpath(obj.getProperty("SelectDate"))).click();
        String DepartDate=ob.ReadUserData("DepartDate");
        String ReturnDate=ob.ReadUserData("ReturnDate");
        String DepartMonth=ob.ReadUserData("DepartMonth");
        System.out.println(DepartDate);
       while(true)
        {
          String month=driver.findElement(By.xpath(obj.getProperty("SelectDate"))).getText();
          System.out.println(month);
          if(month.equalsIgnoreCase(DepartMonth)) {
              System.out.println("Choosed");
              break;
          }
          else
          {
          driver.findElement(By.xpath(obj.getProperty("NavigateIcon"))).click();
        }
        }
         List<WebElement> date= driver.findElements(By.xpath(obj.getProperty("datevalue")));
         //for selecting depature date
         for(WebElement e:date)
         {
             if(e.getText().contains(DepartDate)) {
                 e.click();
                 break;
             }
         }
         //for selecting return date.
         for(WebElement e:date)
         {
             if(e.getText().contains(ReturnDate)) {
                 e.click();
                 break;
             }
         }
         
        driver.findElement(By.xpath(obj.getProperty("SearchButton"))).click();
      //  Assert.assertTrue(condition, message);
       String pricesort1= driver.findElement(By.xpath(obj.getProperty("upwardsort"))).getText();
       String pricesort2= driver.findElement(By.xpath(obj.getProperty("returnsort"))).getText();
       Assert.assertTrue(((pricesort1.contains("Price"))&&pricesort2.contains("Price")));
       
        driver.findElement(By.xpath(obj.getProperty("Viewfare"))).click();
        driver.findElement(By.xpath(obj.getProperty("BookButton"))).click();
        driver.findElement(By.xpath(obj.getProperty("continuebookingbutton"))).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("No. of tabs: " + tabs.size());
        if(tabs.size()>1)
        	System.out.println("review page is opened!");
        else
        	System.out.println("review page is not opened!");
        driver.close();
}

}
