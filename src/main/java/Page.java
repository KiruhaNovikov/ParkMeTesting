import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Page {

    public static WebDriver driver = DriverBuilder.INSTANCE.getDriver();

    protected Page() {
        Config.loadProperties("Page.properties");
        PageFactory.initElements(driver, this);
    }
}
