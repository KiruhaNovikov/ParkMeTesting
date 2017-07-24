import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestBase {

    WebDriver driver = DriverBuilder.INSTANCE.getDriver();

    @BeforeTest
    public void openParkMeHomePage() {
        driver.get("https://parkme.com/");
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
