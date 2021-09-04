package week4day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LearnFrame {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement frame = driver.findElement(By.xpath("//div[@id='iframewrapper']/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		Alert confirmAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		// confirmAlert.accept(); // To ok
		confirmAlert.dismiss(); // To cancel
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if (text.contains("OK")) {
			System.out.println("Ok Button pressed");
		} else {
			System.out.println("Cancel button pressed");
		}

	}

}
