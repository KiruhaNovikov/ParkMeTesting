import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends Page {

    @FindBy(xpath = ".//*[@id='login']/div/div[3]/label")
    private WebElement loginErrorText;

    public boolean checkLoginErrorMessage() {
        return loginErrorText.getText().contains(Config.getSetting("incorrectLoginMessage"));
    }
}
