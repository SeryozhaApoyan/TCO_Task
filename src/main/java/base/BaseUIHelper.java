package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUIHelper {
    private static WebDriver driver;


    public static WebDriver getDriver(){
        if(driver == null){
            setUpDriver();
        }
        return driver;
    }

    private static void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


}