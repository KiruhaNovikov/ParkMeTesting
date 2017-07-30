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
        } else{
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            try{
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }catch (Exception e){
                throw new ExceptionInInitializerError(e);
            }
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
