package pages;

import base.BaseUIHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    private final int TIME_OUT = 30;
    private final int SLEEP = 2;

    protected FluentWait<WebDriver> wait;


    public BasePage(String pageURL) {
        driver = BaseUIHelper.getDriver();
        driver.get(pageURL);
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT), Duration.ofSeconds(SLEEP))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIME_OUT));
        driver.manage().window().maximize();
    }

    public BasePage() {
        driver = BaseUIHelper.getDriver();
        PageFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT), Duration.ofSeconds(SLEEP))
                .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIME_OUT));
        driver.manage().window().maximize();
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void waitForPageURLContain(String url){
        wait.until(ExpectedConditions.urlContains(url));
    }

    public void waitForElements(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}
