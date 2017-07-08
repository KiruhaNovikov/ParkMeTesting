import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by bogdansivodedov on 7/5/17.
 */
public class TestBase {

    WebDriver driver;

    @BeforeTest
    public void openParkMeHomePage() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
        /*ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://parkme.com/");
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
