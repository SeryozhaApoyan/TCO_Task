import base.BaseUIHelper;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    @AfterMethod
    public void tearDown(){
        BaseUIHelper.getDriver().quit();
    }
}
