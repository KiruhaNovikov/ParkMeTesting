import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class TestBase extends Page {

    public HomePage homePage = new HomePage();
    public SearchResultPage searchResultPage = new SearchResultPage();

    @BeforeTest
    @BeforeMethod
    public void openHomePage() {
        driver.get("https://parkme.com/");
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
