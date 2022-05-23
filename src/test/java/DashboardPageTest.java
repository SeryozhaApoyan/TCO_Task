import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class DashboardPageTest {
    private DashboardsPage dashboardsPage;
    private DashboardPage dashboardPage;
    @BeforeMethod
    public void setup(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        dashboardsPage = new DashboardsPage();
        dashboardsPage.isPageLoaded();
    }
    @Test(testName = "check status")
    public void checkStatus(){
        Dashboards dashboard = Dashboards.PARTNER;
        Statuses status = Statuses.ONLINE;
        dashboardsPage.setStatus(status);
        dashboardsPage.selectDashboard(dashboard);
        dashboardPage = new DashboardPage();
        dashboardPage.isPageLoaded(dashboard);
        dashboardPage.switchToTab(1);
        dashboardPage.checkStatus(status);
    }
}
