import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResultPage extends Page {

    @FindBy(xpath = "html/body/div[2]/div[2]/div[2]/div[2]/div[1]")
    private WebElement cityName;


    public boolean correctSearchCity() {
        return cityName.getText().contains("New York Parking");
    }
}
