import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends Page {

    @FindBy(xpath = ".//label[@class='reg-error']")
    private WebElement loginErrorText;

    public boolean checkLoginErrorMessage() {
        return loginErrorText.getText().contains(Config.getSetting("incorrectLoginMessage"));
    }
}
