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

import com.relevantcodes.extentreports.LogStatus;

import Assignment1.BaseImplementation;

public class Task1 extends BaseImplementation {
	@Test(groups = { "mandatory", "Assignment3" })
	public void test1() throws IOException, InterruptedException {
		logger=extent.startTest("Assignment3.Task1");
		Task1 ob = new Task1();
		Properties obj = ob.ReadObjectRepo();
		WebDriver driver = ob.driver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.log(LogStatus.INFO, "selecting trip round trip option");
		driver.findElement(By.xpath(obj.getProperty("tripoption"))).click();
		driver.findElement(By.id(obj.getProperty("FromCity"))).click();
		driver.findElement(By.xpath(obj.getProperty("FirstOptioninfromcity"))).click();
		driver.findElement(By.xpath(obj.getProperty("ToCity"))).click();
		driver.findElement(By.xpath(obj.getProperty("secondoptionintocity"))).click();
		driver.findElement(By.xpath(obj.getProperty("Departure"))).click();
		driver.findElement(By.xpath(obj.getProperty("SelectDate"))).click();
		String DepartDate = ob.ReadUserData("DepartDate");
		String ReturnDate = ob.ReadUserData("ReturnDate");
		String DepartMonth = ob.ReadUserData("DepartMonth");
		logger.log(LogStatus.INFO, "iterating using month,selecting the required month and coming out of loop using break");
		while (true) {
			String month = driver.findElement(By.xpath(obj.getProperty("SelectDate"))).getText();
			System.out.println(month);
			if (month.equalsIgnoreCase(DepartMonth)) {
				System.out.println("Choosed");
				break;
			} else {
				driver.findElement(By.xpath(obj.getProperty("NavigateIcon"))).click();
			}
		}
		logger.log(LogStatus.INFO, "selecting return date.");
		List<WebElement> date = driver.findElements(By.xpath(obj.getProperty("datevalue")));
		// for selecting depature date
		logger.log(LogStatus.INFO, "selecting depature date");
		for (WebElement e : date) {
			if (e.getText().contains(DepartDate)) {
				e.click();
				break;
			}
		}
		// for selecting return date.
		logger.log(LogStatus.INFO, "selecting return date.");
		for (WebElement e : date) {
			if (e.getText().contains(ReturnDate)) {
				e.click();
				break;
			}
		}

		driver.findElement(By.xpath(obj.getProperty("SearchButton"))).click();
		// Assert.assertTrue(condition, message);
		logger.log(LogStatus.INFO, "price sort validation");
		String pricesort1 = driver.findElement(By.xpath(obj.getProperty("upwardsort"))).getText();
		String pricesort2 = driver.findElement(By.xpath(obj.getProperty("returnsort"))).getText();
		Assert.assertTrue(((pricesort1.contains("Price")) && pricesort2.contains("Price")));
		logger.log(LogStatus.INFO, "book and continue");
		driver.findElement(By.xpath(obj.getProperty("Viewfare"))).click();
		driver.findElement(By.xpath(obj.getProperty("BookButton"))).click();
		driver.findElement(By.xpath(obj.getProperty("continuebookingbutton"))).click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		logger.log(LogStatus.INFO, "review page validation");
		System.out.println("No. of tabs: " + tabs.size());
		if (tabs.size() > 1)
			System.out.println("review page is opened!");
		else
			System.out.println("review page is not opened!");
		driver.close();
		logger.log(LogStatus.PASS, "test case passed");

	}

}
