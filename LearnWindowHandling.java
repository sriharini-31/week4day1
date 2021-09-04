package week4day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandling {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandleList = new ArrayList<String>(windowHandlesSet);
		windowHandleList.get(1); // Window Handle of the Child Window
		driver.switchTo().window(windowHandleList.get(1));
		System.out.println(driver.getTitle());
		String emailId = driver.findElement(By.xpath("//a[text()=' flights@irctc.co.in']")).getText();
		System.out.println("Customer Care Email Id is : " + emailId);

		driver.switchTo().window(windowHandleList.get(0)).close();

	}

}
