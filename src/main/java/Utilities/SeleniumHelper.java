package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumHelper {

    WebDriver driver;
    Actions actions;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void type(By locator, String value) {
        find(locator).clear();
        find(locator).sendKeys(value);
    }

    public void hover(By locator) {
        actions.moveToElement(find(locator)).perform();
    }

    public void selectCheckbox(By locator) {
        if (!find(locator).isSelected()) {
            find(locator).click();
        }
    }

    public void selectRadio(By locator) {
        find(locator).click();
    }

    public boolean isPresent(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }


}
