package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fin;
	public static Properties prop;
	
	public TestBase() throws IOException {
		
		fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(fin);
	}
	
	public static void initialize() {
		
		if(prop.getProperty("browser").equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\eclipse-workspace\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if(prop.getProperty("browser").equals("opera")) {
			
			System.setProperty("webdriver.opera.driver", "C:\\Users\\Dell\\eclipse-workspace\\operadriver.exe");
			driver = new OperaDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
