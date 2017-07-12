import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String loginCheck() {
        return driver.findElement(By.xpath(".//*[@id='header_fullsize']/div[1]/span[2]/div/span")).getText();
    }

    public String loginErrorMessage() {
        return driver.findElement(By.xpath(".//*[@id='login']/div/div[3]/label")).getText();
    }

    public String logoutCheck() {
        return driver.findElement(By.xpath(".//*[@id='header_fullsize']/div/span[2]/div[1]/ul[1]/li[2]/a")).getText();
    }
}
