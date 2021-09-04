package week4day1;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Simple Alert
		driver.findElement(By.xpath("//button[text()=\"Alert Box\"]")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String text = alert.getText();
		System.out.println(text);
		alert.accept();

		// Confirmation Alert
		driver.findElement(By.xpath("//button[text()=\"Confirm Box\"]")).click();
		alert.dismiss();
		String print = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		if (print.contains("OK")) {
			System.out.println("Pressed Ok!");
		} else {
			System.out.println("Cancel button pressed");
		}

		// Prompt Alert
		driver.findElement(By.xpath("//button[text()=\"Prompt Box\"]")).click();
		Thread.sleep(1000);
		alert.sendKeys("Edu");
		alert.accept();
		String print2 = driver.findElement(By.xpath("//p[@id=\"result1\"]")).getText();
		System.out.println(print2);

	}
}
