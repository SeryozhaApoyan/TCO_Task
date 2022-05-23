package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static org.testng.Assert.assertTrue;

public class DashboardPage extends BasePage{
    public void switchToTab(int tabNumber){
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    @FindBy(css = "[href*='home'] div div div>span")
    private List<WebElement> statusElement;


    public void checkStatus(Statuses status){
        By statusBy = By.cssSelector("[href*='home'] div div div>span");
        wait.until(ExpectedConditions.numberOfElementsToBe(statusBy,2));
        switch (status) {
            case ONLINE:
                assertTrue(statusElement.get(0).getAttribute("class").equals("Online"));
                break;
            case AWAY:
                assertTrue(statusElement.get(0).getAttribute("class").equals("Away"));
                break;
            case INVISIBLE:
                assertTrue(statusElement.get(0).getAttribute("class").equals("Invisible"));
                break;
            default:
                throw new NoSuchElementException(status.name() + " can`t be found");
        }
    }
    public void isPageLoaded(Dashboards dashboards) {
        waitForPageURLContain(dashboards.getDisplayName().toLowerCase());
    }
}
