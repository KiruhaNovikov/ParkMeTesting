import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver = DriverBuilder.INSTANCE.getDriver();

    public HomePage(WebDriver driver) {
        Config.loadProperties("HomePage.properties");
        this.driver = driver;
    }

    public ResultPage searchCityName(String cityName) {
        driver.findElement(By.id(Config.getSetting("search_field"))).sendKeys(cityName);
        driver.findElement(By.xpath(Config.getSetting("search_button"))).click();

        return new ResultPage(driver);
    }

    public LoginPage logInToParkMe(String login, String password) {
        driver.findElement(By.xpath(".//*[@id='header_fullsize']/div/span[2]/div[1]/ul[1]/li[2]/a")).click();
        driver.findElement(By.id("id_username")).sendKeys(login);
        driver.findElement(By.id("id_password")).sendKeys(password);
        driver.findElement(By.id("login-btn")).click();

        return new LoginPage(driver);
    }

    public LoginPage logOutFromParkMe() {
        driver.findElement(By.xpath(".//*[@id='header_fullsize']/div[1]/span[2]/div/div/div[1]/span")).click();
        driver.findElement(By.xpath(".//*[@id='header_fullsize']/div[1]/span[2]/div/div/ul/li[5]/a")).click();

        return new LoginPage(driver);
    }
}
