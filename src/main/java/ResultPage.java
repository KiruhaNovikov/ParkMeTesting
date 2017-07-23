import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {

    WebDriver driver = DriverBuilder.INSTANCE.getDriver();

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCityName() {
        return driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div[2]/div[1]")).getText();
    }
}
