import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Statuses;
import pages.DashboardsPage;


public class DashboardsPageTest {
    private DashboardsPage dashboardsPage;
    @BeforeMethod
    public void setup(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        dashboardsPage = new DashboardsPage();
        dashboardsPage.isPageLoaded();
    }
    @Test(testName = "change status")
    public void changeDashboardStatus(){
        Statuses status = Statuses.ONLINE;
        dashboardsPage.setStatus(status);
        dashboardsPage.checkStatus(status);
    }
}
