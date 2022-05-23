package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void login(){
        emailAddress.sendKeys("partner_agent1@mail.com");
        password.sendKeys("123456");
        submit.submit();
    }
}
