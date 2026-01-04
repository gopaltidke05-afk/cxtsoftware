package dashboard;

import baseTest.BaseTest;
import dataFactory.admin.dashboard.DashboardDF;
import dataObject.admin.dashboard.DashboardDO;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObject.dashboard.DashboardPo;

public class DashboardTest extends BaseTest {


    @Test
    public void verifyDashboardHoverAndNavigation() throws InterruptedException {
        //Page-Object
        DashboardPo dashboardPo = new DashboardPo(driver);

        //Data
        DashboardDO dashboardData = DashboardDF.getDashboardDO();

        Reporter.log("Step 1: Verify that user successfully navigate to Dashboard page");
        Assert.assertEquals(dashboardPo.getLogisticsAndCourierHeaderText(),dashboardData.getLogisticsAndCourierHeaderText(),"Logistics and Courier Header text is not matched");
        Assert.assertTrue(dashboardPo.verifyDashboardLogo(),"Dashboard logo or banner is not present");

        Reporter.log("Step 2: Move hover on product then click on click request button");
        dashboardPo.hoverOnProduct(dashboardData.getMenuList().get(0));
        dashboardPo.clickOnMenuItem(dashboardData.getMenuItem().get(0));
    }
    //failed Test case
    @Test
    public void verifyDashboard() throws InterruptedException {
        //Page-Object
        DashboardPo dashboardPo = new DashboardPo(driver);

        //Data
        DashboardDO dashboardData = DashboardDF.getDashboardDO();

        Reporter.log("Step 1: Verify that user successfully navigate to Dashboard page");
        Assert.assertEquals(dashboardPo.getLogisticsAndCourierHeaderText(),dashboardData.getLogisticsAndCourierHeaderText(),"Logistics and Courier Header text is not matched");
        Assert.assertTrue(dashboardPo.verifyDashboardLogo(),"Dashboard logo or banner is not present");

        Reporter.log("Step 2: Move hover on product then click on click request button");
        dashboardPo.hoverOnProduct(dashboardData.getMenuList().get(0));
        dashboardPo.clickOnMenuItem(dashboardData.getMenuItem().get(0));

        //failed
        Assert.assertEquals(dashboardPo.getLogisticsAndCourierHeaderText(),"","Logistics and Courier Header text is not matched");

    }
}
