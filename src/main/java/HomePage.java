import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.apache.commons.codec.binary.Base64;


public class HomePage extends Page {

    @FindBy(id = "input-destination")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@id='search_header']/span/button")
    private WebElement searchButton;

    @FindBy(xpath = ".//a[@class='uppercase nav-link header-log-in']")
    private WebElement loginPageButtonLink;

    @FindBy(id = "id_username")
    private WebElement usernameField;

    @FindBy(id = "id_password")
    private WebElement passwordField;

    @FindBy(id = "login-btn")
    private WebElement loginButton;

    @FindBy(xpath = ".//div[@class='header-toggle header-name-toggle nav-link uppercase' and @data-toggle='dropdown']")
    private WebElement logoutSpan;

    @FindBy(xpath = ".//a[@class='header-sign-out']")
    private WebElement logoutButton;

    @FindBy(xpath = ".//span[@class='header-email']")
    private WebElement successfulLogin;

    // TODO: move crypto to correct place
    private String decrypt(String encryptedString) {
        byte[] byteArray = Base64.decodeBase64(encryptedString.getBytes());
        return new String(byteArray);
    }

    // TODO: need to resolve the issue with not used return values
    public SearchResultPage searchCityByName() {
        searchField.sendKeys(Config.getSetting("testCity"));
        searchButton.click();
        return new SearchResultPage();
    }

    public boolean checkifLoginCorrect() {
        return successfulLogin.getText().contains(decrypt(Config.getSetting("correctUsernameBase64")));
    }

    // TODO: need to move login logout method to Page class as it is static
    public void login() {
        loginPageButtonLink.click();
        usernameField.sendKeys(decrypt(Config.getSetting("correctUsernameBase64")));
        passwordField.sendKeys(decrypt(Config.getSetting("correctPasswordBase64")));
        loginButton.click();
    }

    public void login_negative() {
        loginPageButtonLink.click();
        usernameField.sendKeys(Config.getSetting("incorrectUsername"));
        passwordField.sendKeys(Config.getSetting("incorrectPassword"));
        loginButton.click();
    }

    public void logout() {
        logoutSpan.click();
        logoutButton.click();
    }
}
