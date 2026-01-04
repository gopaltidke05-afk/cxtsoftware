package pageObject.dashboard;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.base.BasePage;

public class DashboardPo extends BasePage {

    /**
     * DashboardPo
     *
     * @param driver driver
     */

    public DashboardPo(WebDriver driver) {
        super(driver);
    }
    By cxtLogo = By.cssSelector("[alt='CXT Software logo']");
    By headerBanner = By.xpath("//header//header[1]//div[@class='elementor-widget-container'][1]/a/img");
    By logisticsHeaderText  = By.xpath("//div[1]/div/h1[@class='elementor-heading-title elementor-size-default']");

    /**
     * clickOnMenuItem
     *
     * @param menuItemName menuItemName
     */
    public void clickOnMenuItem(String menuItemName){
        By menuItem = By.xpath("//nav[1]//ul/li[contains(@class,'menu-item')]//a[contains(text(),'" + menuItemName + "')]");
        selenium.click(menuItem);
    }

    /**
     * hoverOnProduct
     *
     * @param menuName menuName
     */
    public void hoverOnProduct(String menuName){
        By menuItemNames = By.xpath("//div[@class='elementor-widget-container']/nav[1]//a[contains(text(),'"+menuName+"')]");
        selenium.hover(menuItemNames);
        selenium.click(menuItemNames);
    }

    /**
     * verifyDashboardLogo
     *
     * @return true or false
     */
    public boolean verifyDashboardLogo() throws InterruptedException {
        wait.waitForVisible(cxtLogo);
        boolean logoPresent =  selenium.isPresent(cxtLogo);
        boolean bannerPresent = selenium.isPresent(headerBanner);
        return logoPresent && bannerPresent;
    }

    /**
     * getLogisticsAndCourierHeaderText
     *
     * @return get text
     * @throws InterruptedException InterruptedException
     */
    public String getLogisticsAndCourierHeaderText() throws InterruptedException {
        wait.waitForVisible(logisticsHeaderText);
        return selenium.getText(logisticsHeaderText).replace("\n"," ").trim();
    }
}
