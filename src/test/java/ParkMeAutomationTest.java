import org.testng.annotations.*;


public class ParkMeAutomationTest extends TestBase {

    @Test()//enabled = false)
    public void locationSearch() {
        homePage.searchCityByName();
        searchResultPage.correctSearchCity();
    }

    @Test()//enabled = false)
    public void login_positive() {
        page.login(
                Config.getSetting("correctUsernameBase64"),
                Config.getSetting("correctPasswordBase64"));
        page.checkifLoginCorrect();
        page.logout();
    }

    @Test()//enabled = false)
    public void login_negative(){
        page.login(
                Config.getSetting("incorrectUsername"),
                Config.getSetting("incorrectPassword"));
        loginPage.checkLoginErrorMessage();
    }

    @Test()//enabled = false)
    public void logout(){
        page.login(
                Config.getSetting("correctUsernameBase64"),
                Config.getSetting("correctPasswordBase64"));
        page.logout();
    }
}
