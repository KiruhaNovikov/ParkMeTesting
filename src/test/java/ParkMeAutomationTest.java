import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ParkMeAutomationTest extends TestBase {

    @Test//(enabled = false)
    public void locationSearch() {
        HomePage home = new HomePage(driver);
        ResultPage result = home.searchCityName("New York");
        assertTrue(result.getCityName().contains("New York Parking"));
    }

    @Test//(enabled = false)
    public void logInToParkMe() {
        HomePage home = new HomePage(driver);
        LoginPage login = home.logInToParkMe("kiruha.testing@gmail.com", "08642QwErTy");
        assertTrue(login.loginCheck().contains("kiruha.testing"));
        LoginPage logout = home.logOutFromParkMe();
        login = home.logInToParkMe("kiruha.testing", "08642QwErTy");
        assertTrue(login.loginErrorMessage().contains("Please enter a valid email address"));
        //logout = home.logOutFromParkMe();
        //assertTrue(logout.logoutCheck().contains("LOG IN"));
    }

}
