import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


public class TestBase {

    WebDriver driver;

    @BeforeTest
    public void openParkMeHomePage() {
        FirefoxDriverManager.getInstance().setup();
        driver = new ChromeDriver();
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
