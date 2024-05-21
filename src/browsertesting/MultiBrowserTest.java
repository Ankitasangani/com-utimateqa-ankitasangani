package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Project-5 - ProjectName : com-utimateqa
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */

public class MultiBrowserTest {

    // static variables
    static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) {

        // Nested if else to launch the browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //Open baseUrl
        driver.get(baseUrl);

        // Maximise the browser window
        driver.manage().window().maximize();

        System.out.println("The title of the page: " + driver.getTitle());  // get the title of the page
        System.out.println("The current URL:  " + driver.getCurrentUrl());  //get the current Url of the page
        System.out.println("The page source: " + driver.getPageSource());  // get page source

        driver.findElement(By.linkText("Sign In")).click();  // Click on ‘Sign In’ link
        System.out.println("Get current URl:" + driver.getCurrentUrl());  // get the current Url of the page
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com"); // Enter the email to email field
        driver.findElement(By.id("user[password]")).sendKeys("Prime123"); // Enter the password to password field
        driver.findElement(By.className("g-recaptcha")).click(); // Click on Login Button

        driver.navigate().to(baseUrl);  // Navigate to base Url
        driver.navigate().forward();   // forward the page
        driver.navigate().back();     // Navigate back
        driver.navigate().refresh(); // Refresh the page

        driver.close(); // close the current window where Selenium automation is running

    }
}
