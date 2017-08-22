import org.testng.annotations.*;


public class ParkMeAutomationTest extends TestBase {

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
        homePage.checkLoginErrorMessage();
    }

    @Test()//enabled = false)
    public void logout(){
        homePage.login();
        homePage.logout();
    }
}
