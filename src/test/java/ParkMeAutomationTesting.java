import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ParkMeAutomationTesting extends TestBase {

    @Test
    public void locationSearch() {
        HomePage home = new HomePage(driver);
        ResultPage result = home.searchCityName("New York");
        assertTrue(result.getCityName().contains("New York Parking"));
    }

    @Test
    public void logInToParkMe() {
        HomePage home = new HomePage(driver);
        LoginPage login = home.logInToParkMe("kiruha.testing@gmail.com", "08642QwErTy");
        assertTrue(login.loginCheck().contains("kiruha.testing"));
        LoginPage logout = home.logOutFromParkMe();
        assertTrue(logout.logoutCheck().contains("LOG IN"));
    }

}
