import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;


public enum DriverBuilder {
    INSTANCE;

    private WebDriver driver;

    DriverBuilder(){
        String driverName = System.getProperty("driverName");
        if (driverName.equals("phantomjs")){
            try{
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs");
                driver = new PhantomJSDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }catch (Exception e){
                throw new ExceptionInInitializerError(e);
            }
        } else if (driverName.equals("chromedriver")){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            ChromeOptions options = new ChromeOptions();
            try{
                driver = new ChromeDriver();
                options.addArguments("--headless");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }catch (Exception e){
                throw new ExceptionInInitializerError(e);
            }
        } else{
            throw new ExceptionInInitializerError("No driver initialized " +
                    "under driverName. Use mvn test -DdriverName=chromedriver or similar");
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
