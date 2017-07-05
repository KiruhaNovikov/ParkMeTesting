import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ParkMeAutomationTesting {

    private WebDriver driver;

    @BeforeTest
    public void openParkMeHomePage() {
        /*FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();*/
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://parkme.com/");
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void locationSearch() {
        HomePage home = new HomePage(driver);
        ResultPage result = home.searchCityName("New York");
        assertTrue(result.getCityName().contains("New York Parking"));
    }

    @Test
    public void logInToParkMe() {
        HomePage home = new HomePage(driver);
        LoginPage login = home.logInToParkMe("kiruha.testing@gmail.com", "08642QwErTy");
        assertTrue(login.loginCheck().contains("kiruha.testing"));
        LoginPage logout = home.logOutFromParkMe();
        assertTrue(logout.logoutCheck().contains("ВОЙТИ"));
    }

}
