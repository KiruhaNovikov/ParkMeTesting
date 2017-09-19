import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;


public class Page {

    @FindBy(xpath = ".//div[@class='header-toggle header-name-toggle nav-link uppercase' and @data-toggle='dropdown']")
    private WebElement logoutSpan;

    @FindBy(xpath = ".//a[@class='header-sign-out']")
    private WebElement logoutButton;

    @FindBy(xpath = ".//a[@class='uppercase nav-link header-log-in']")
    private WebElement loginPageButtonLink;

    @FindBy(id = "id_username")
    private WebElement usernameField;

    @FindBy(id = "id_password")
    private WebElement passwordField;

    @FindBy(id = "login-btn")
    private WebElement loginButton;

    @FindBy(xpath = ".//span[@class='header-email']")
    private WebElement successfulLogin;

    public static WebDriver driver = DriverBuilder.INSTANCE.getDriver();


    protected Page() {
        Config.loadProperties("Page.properties");
        PageFactory.initElements(driver, this);
    }

    private String decrypt(String encryptedString) {
        byte[] byteArray = Base64.decodeBase64(encryptedString.getBytes());
        return new String(byteArray);
    }

    @Step("Step to login to ParkMe website")
    public void login(String userName, String passwd) {
        loginPageButtonLink.click();
        usernameField.sendKeys(decrypt(userName));
        passwordField.sendKeys(decrypt(passwd));
        loginButton.click();
    }

    public boolean checkifLoginCorrect() {
        return successfulLogin.getText().contains(decrypt(Config.getSetting("correctUsernameBase64")));
    }

    @Step("Step to logout from the web site")
    public void logout() {
        logoutSpan.click();
        logoutButton.click();
    }
}
