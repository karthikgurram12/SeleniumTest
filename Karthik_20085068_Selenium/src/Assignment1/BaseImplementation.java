package Assignment1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import au.com.bytecode.opencsv.CSVReader;

public class BaseImplementation {
	
	public WebDriver driver() throws IOException
	{
		WebDriver driver = null;
		if(ReadBrowserType().getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver_win32 (3)\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(ReadBrowserType().getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\chromedriver\\GeckoDriver.exe");
			driver=new FirefoxDriver();
		}
		return driver;
		
		
		
	}
	
	public String[] ReadData(String usertype) throws IOException {
		
		String[] str = null;
		CSVReader reader = new CSVReader(new FileReader(System.getProperty("user.dir")+"\\src\\Data\\data.csv"));

		  List<String[]> list=reader.readAll();
		  System.out.println("Total rows which we have is "+list.size());
		            
		 // create Iterator reference
		  Iterator<String[]>iterator= list.iterator();
		    
		 // Iterate all values 
		 while(iterator.hasNext()){
		     
		 str=iterator.next();
		   
		 if(str[0].equalsIgnoreCase(usertype))
		 {
			 break;
		 }
		 }
		 return str;
		
	}
	public Properties ReadObjectRepo() throws IOException
	{
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\Object_Repository\\ObjectReporitory.properties");
		obj.load(objfile);
		return obj;
	}
	public Properties ReadBrowserType() throws IOException
	{
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\Data\\browser.properties");
		obj.load(objfile);
		return obj;
	}
	public String ReadUserData(String value) throws IOException
	{
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\Data\\UserData.properties");
		obj.load(objfile);
		String str=obj.getProperty(value);
		return str;
	}
	public void RegisterOlay(String email,String pass,String confirmpass,String day,String month,String year) throws IOException
	{
		WebDriver driver=driver();
		driver.findElement(By.xpath(ReadObjectRepo().getProperty("Register"))).click();
	}

}
