package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BasePage{
    private static final String url = "https://chat1.site/login";
    public LoginPage() {
        super(url);
    }

    @FindBy(css = "[name = 'email']")
    private WebElement emailAddress;

    @FindBy(css = "[name = 'password']")
    private WebElement password;

    @FindBy(css = "[type = 'submit']")
    private WebElement submit;

    @FindBy(css = "[class = 'Error']")
    public WebElement loginFailed;

    public void login(){
        emailAddress.sendKeys("partner_agent1@mail.com");
        password.sendKeys("123456");
        submit.submit();
    }

    public void loginFailed() {
        submit.submit();
        wait.until(ExpectedConditions.visibilityOf(loginFailed));
        String actualMsg = loginFailed.getText();
        Assert.assertEquals(actualMsg, "Login failed, wrong user credentials.");
    }
}
