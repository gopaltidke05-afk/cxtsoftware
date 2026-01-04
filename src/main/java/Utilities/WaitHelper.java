package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitHelper {

    WebDriver driver;
    WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForVisible(By locator) {
        wait.until(d -> d.findElement(locator).isDisplayed());
    }

    /**
     * waitForHeaderToBeStable
     *
     * @param driver driver
     * @param headerLocator headerLocator
     */
    public void waitForHeaderToBeStable(WebDriver driver, By headerLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(driver1 -> {
            String text1 = driver1.findElement(headerLocator).getText();
            try {
                Thread.sleep(500); // short internal wait
            } catch (InterruptedException e) {}
            String text2 = driver1.findElement(headerLocator).getText();
            return text1.equals(text2) && !text1.isEmpty();
        });
    }

    public void waitLoader(){
        wait.until(driver ->
                driver.findElements(By.cssSelector("[aria-busy='true']")).isEmpty()
        );
    }

}
