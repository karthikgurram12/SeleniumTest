package Assignment1;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task5 extends BaseImplementation {
	@Test(groups = { "mandatory", "Assignment1" })
	public void test5() throws IOException {
		// TODO Auto-generated method stub
		// Drag me to my target and drop on the target and verify the text.
		logger = extent.startTest("test5");
		Task1 ob = new Task1();
		Properties obj = ob.ReadObjectRepo();
		WebDriver driver = ob.driver();
		driver.get("https://demoqa.com/selectmenu/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement speed = driver.findElement(By.xpath(obj.getProperty("selectspeed")));
		speed.click();
		// we can't able to select options from dropdown if the dropdown type is "span",
		// so used below code
		List<WebElement> l = driver.findElements(By.xpath(obj.getProperty("speeddropdownselect")));
		for (WebElement e : l) {
			if (e.getText().equalsIgnoreCase(ob.ReadUserData("speed")))
				e.click();
		}
		System.out.println(speed.getText());
		Assert.assertTrue(speed.getText().equalsIgnoreCase(ob.ReadUserData("speed")));

		WebElement file = driver.findElement(By.xpath(obj.getProperty("selectfile")));
		file.click();
		List<WebElement> fl = driver.findElements(By.xpath(obj.getProperty("filedropdownselect")));
		for (WebElement e : fl) {
			if (e.getText().equalsIgnoreCase(ob.ReadUserData("file")))
				e.click();
		}
		System.out.println(file.getText());
		Assert.assertTrue(file.getText().equalsIgnoreCase(ob.ReadUserData("file")));

		WebElement no = driver.findElement(By.xpath(obj.getProperty("selectnumber")));
		no.click();
		List<WebElement> nl = driver.findElements(By.xpath(obj.getProperty("numberdropdownselect")));
		for (WebElement e : nl) {
			if (e.getText().equalsIgnoreCase(ob.ReadUserData("number")))
				e.click();
		}
		System.out.println(no.getText());
		Assert.assertTrue(no.getText().equalsIgnoreCase(ob.ReadUserData("number")));

		WebElement title = driver.findElement(By.xpath(obj.getProperty("selecttitle")));
		title.click();
		List<WebElement> tl = driver.findElements(By.xpath(obj.getProperty("titledropdownselect")));
		for (WebElement e : tl) {
			if (e.getText().equalsIgnoreCase(ob.ReadUserData("title")))
				e.click();
		}
		Assert.assertTrue(title.getText().equalsIgnoreCase(ob.ReadUserData("title")));
		System.out.println("Test Pass");
		driver.close();
		logger.log(LogStatus.PASS, "test case passed");

	}

}
