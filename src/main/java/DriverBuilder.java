import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public enum DriverBuilder {
    INSTANCE;

    private WebDriver driver;

    DriverBuilder(){
        System.setProperty("webdriver.chrome.driver", "chromedriver"); // needed to be manually set for vkhalin
        try{
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (Exception e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
