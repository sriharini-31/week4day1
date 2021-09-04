package week4day1Assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrame {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Locate click me button inside a frame and take a screenshot of the button
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='wrapframe']/iframe"));
		driver.switchTo().frame(frame1);
		WebElement clickBtnFrm1 = driver.findElement(By.id("Click"));
		File src1 = clickBtnFrm1.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/ClickMe.png");
		FileUtils.copyFile(src1, dst);
		Thread.sleep(1000);
		clickBtnFrm1.click();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();

		// Find the number of frames
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeList.size());

	}


}
