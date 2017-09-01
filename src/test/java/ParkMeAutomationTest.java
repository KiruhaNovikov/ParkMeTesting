import org.testng.annotations.*;


public class ParkMeAutomationTest extends TestBase {

    // TODO: need to redesign methods to be more generic
    // TODO: discuss test design methods in our scope
    @Test()//enabled = false)
    public void locationSearch() {
        homePage.searchCityByName();
        searchResultPage.correctSearchCity();
    }

    @Test()//enabled = false)
    public void login_positive() {
        homePage.login();
        homePage.checkifLoginCorrect();
        homePage.logout();
    }

    @Test()//enabled = false)
    public void login_negative(){
        homePage.login_negative();
        loginPage.checkLoginErrorMessage();
    }

    @Test()//enabled = false)
    public void logout(){
        homePage.login();
        homePage.logout();
    }
}
