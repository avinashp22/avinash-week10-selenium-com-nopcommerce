import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;


public class ComNopcommerce {
    static String browser = "chrome"; // choose browser
    static WebDriver driver; // declare globally

    public static void main(String[] args)   {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        String baseURL = "https://demo.nopcommerce.com/"; // set base url
        driver.get(baseURL);  // get base url
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //give implicit wait to driver

        System.out.println(driver.getTitle()); // print tile
        System.out.println(driver.getCurrentUrl()); // print current url
        System.out.println(driver.getPageSource()); // print page source
        String loginURL = "https://demo.nopcommerce.com/login?returnUrl=%2F"; // store new url
        driver.navigate().to(loginURL); // tell driver to navigate to this new url
        driver.navigate().back(); // go back a page to home page
        driver.navigate().forward();// go forward to login page
        System.out.println(driver.getCurrentUrl()); // print current url
        driver.navigate().refresh(); // refresh url

        WebElement email = driver.findElement(By.id("Email"));    //find email field and enter email by ID
        email.sendKeys("avi@patel.com");   // type into box, action

        WebElement password = driver.findElement(By.id("Password"));       //find password field and enter password by ID
        password.sendKeys("Halllo123");    // type into box, action

        WebElement loginLink = driver.findElement(By.className("button-1 login-button")); // hover to login button
        loginLink.click(); // click on login link


        driver.quit();  // close browser
    }
}