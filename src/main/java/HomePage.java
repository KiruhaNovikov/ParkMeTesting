import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.apache.commons.codec.binary.Base64;


public class HomePage extends Page {

    @FindBy(id = "input-destination")
    private WebElement searchField;

    @FindBy(xpath = ".//*[@id='search_header']/span/button")
    private WebElement searchButton;

    @FindBy(xpath = ".//*[@id='header_fullsize']/div/span[2]/div[1]/ul[1]/li[2]/a")
    private WebElement loginPageButtonLink;

    @FindBy(id = "id_username")
    private WebElement usernameField;

    @FindBy(id = "id_password")
    private WebElement passwordField;

    @FindBy(id = "login-btn")
    private WebElement loginButton;

    @FindBy(xpath = ".//*[@id='header_fullsize']/div[1]/span[2]/div/div/div[1]/span")
    private WebElement logoutSpan;

    @FindBy(xpath = ".//*[@id='header_fullsize']/div[1]/span[2]/div/div/ul/li[5]/a")
    private WebElement logoutButton;

    @FindBy(xpath = ".//*[@id='header_fullsize']/div[1]/span[2]/div/span")
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
