package week4day1Assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FrameScreenShot {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input"))
				.sendKeys("Selenium WebDriver practice is required");

		// Nested frame3
		WebElement frame3 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();

		//To come out of all the frames
		driver.switchTo().defaultContent();

		// Locate frame2 on home page
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		WebElement dropDown = driver.findElement(By.id("animals"));
		Select dropDownSelect = new Select(dropDown);
		dropDownSelect.selectByIndex(1); // Baby Cat should be selected

	}


}
