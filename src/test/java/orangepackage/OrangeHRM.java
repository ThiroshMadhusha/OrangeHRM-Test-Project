package orangepackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		//open browser url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//getURl Command in terminal
		String url = driver.getCurrentUrl();
		System.out.println("Page URL Is : " + url);
		
		//Get the Title of the Page
		String title = driver.getTitle();
		System.out.println("Page Title : " + title);
		
		/**
		 *DOM and Page Source Different --> When using the browser, when we provide the url and hit the enter button
		 *Browser sent the request to the server. And server send the respose.
		 *The first response is server send to the browser is "PageSource"
		 *Server send to the data to the browser, Some JavaScript animation play on DOM
		
		 */
		//Get WebPage Source Code
		String page = driver.getPageSource();
		System.out.println("Page Source : " + page);
		
		/**
		 * In selenium we cannot handle direcly elements on webpage
		 * We need to switch to handle other windows
		 * window handler gives numeric values of page, it dynamically generate value, always it changed
		 * Window Handler : 701FAD4CFE86B0759D13CB59A92F5386
		 */
		//Get Windows Handler
		//It is used to get handle of a single window, it returns the String values
		String windowHandle = driver.getWindowHandle();
		System.out.println("Window Handler : " + windowHandle);
		
		Thread.sleep(5000);
		//Open New Window by Clicking Link
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		
		Set<String> windowhandles = driver.getWindowHandles();
		
		for(String window : windowhandles) {
			System.out.println(window);
		}
		
		Thread.sleep(4000);
		
		driver.close();
	}

}
