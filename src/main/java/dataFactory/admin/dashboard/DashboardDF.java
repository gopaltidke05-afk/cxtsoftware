package dataFactory.admin.dashboard;


import dataObject.admin.dashboard.DashboardDO;

import java.util.ArrayList;
import java.util.List;

public class DashboardDF {

    public static DashboardDO getDashboardDO(){

        DashboardDO dashboardDO = new DashboardDO();
        dashboardDO.setLogisticsAndCourierHeaderText("Logistics & Courier Software");
        List<String> menuList = new ArrayList<>();
        menuList.add("Product");
        menuList.add("Support");
        menuList.add("Company");
        dashboardDO.setMenuList(menuList);

        List<String> menuItemList = new ArrayList<>();
        menuItemList.add("Features");
        menuItemList.add("Services");
        menuItemList.add("Integrations");
        dashboardDO.setMenuItem(menuItemList);


        return dashboardDO;
    }
}
