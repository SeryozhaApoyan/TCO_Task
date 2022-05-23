import org.testng.annotations.Test;
import pages.*;

public class LoginPageTest {
    LoginPage loginPage;
    DashboardsPage dashboardsPage;

    @Test(testName = "TCO Login Page test")
    public void checkLogin() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.login();
        dashboardsPage = new DashboardsPage();
        dashboardsPage.isPageLoaded();
    }
}
