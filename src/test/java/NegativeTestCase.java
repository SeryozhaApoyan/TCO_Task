import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class NegativeTestCase {
    @Test(testName = "negative case")
    public void withoutCredentials(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginFailed();
    }
}
