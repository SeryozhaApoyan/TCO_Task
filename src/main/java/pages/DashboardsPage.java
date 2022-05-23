package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.*;

import java.util.List;
import java.util.NoSuchElementException;


public class DashboardsPage extends BasePage {

    private final String URL = "https://chat1.site/partners";

    @FindBy(css = "[class *= 'MuiListItemText-root']")
    private List<WebElement> dashboards;

    @FindBy(css = "[class='MuiIconButton-label']")
    private List<WebElement> statusDropdownElement;

    @FindBy(css = "[class*='status']")
    private List<WebElement> statuses;

    @FindBy(css = "[class='MuiIconButton-label'] span")
    private List<WebElement> statusIndicator;

    public void setStatus(Statuses status) {
        waitForElements(statusDropdownElement);
        click(statusDropdownElement.get(1));
        switch (status) {
            case ONLINE:
                click(statuses.get(0));
                break;
            case AWAY:
                click(statuses.get(1));
                break;
            case INVISIBLE:
                click(statuses.get(2));
                break;
            default:
                throw new NoSuchElementException(status.name() + " can`t be found");
        }

    }

    public void checkStatus(Statuses status){
        switch (status) {
            case ONLINE:
                assertTrue(statusIndicator.get(1).getAttribute("class").contains("Online"));
                break;
            case AWAY:
                assertTrue(statusIndicator.get(1).getAttribute("class").contains("Away"));
                break;
            case INVISIBLE:
                assertTrue(statusIndicator.get(1).getAttribute("class").contains("Invisible"));
                break;
            default:
                throw new NoSuchElementException(status.name() + " can`t be found");
        }
    }

    public void isPageLoaded() {
        waitForPageURLContain("partners");
        assertEquals(driver.getCurrentUrl(), URL);
    }

    public void selectDashboard(Dashboards dashboard){
        waitForElements(dashboards);
        for (WebElement dashboardElement: dashboards ) {
            if(dashboardElement.getText().equals(dashboard.getDisplayName())){
                click(dashboardElement);
                return;
            }
        }
    }

}
