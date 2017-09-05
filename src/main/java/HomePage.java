import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;


public class HomePage extends Page {

    @FindBy(id = "input-destination")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@id='search_header']/span/button")
    private WebElement searchButton;


    // TODO: need to resolve the issue with not used return values
    public SearchResultPage searchCityByName() {
        searchField.sendKeys(Config.getSetting("testCity"));
        searchButton.click();
        return new SearchResultPage();
    }
}
