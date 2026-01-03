package pageObject.base;

import Utilities.SeleniumHelper;
import Utilities.WaitHelper;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected SeleniumHelper selenium;
    protected WaitHelper wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelper(driver);
        wait = new WaitHelper(driver);
    }



}
