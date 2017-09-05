import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResultPage extends Page {

    @FindBy(xpath = ".//div[@class='module-header nearby-lots-header']/div[@class='left']")
    private WebElement cityName;

    public boolean correctSearchCity() {
        return cityName.getText().contains(Config.getSetting("testCityCheck"));
    }
}
