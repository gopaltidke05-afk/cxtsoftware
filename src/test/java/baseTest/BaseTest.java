package baseTest;

import Utilities.AllureUtils;
import Utilities.ScreenshotUtil;

import Utilities.WaitHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.testng.AllureTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTest {

    protected WebDriver driver;

    /**
     * setup
     *
     * @param method method
     * @throws Exception Exception
     */
    @BeforeMethod
    public void setup(Method method) throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cxtsoftware.com/");

        //For Headless
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");   // latest chrome
//        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//
//        WebDriver driver = new ChromeDriver(options);

        WaitHelper waitHelper = new WaitHelper(driver);

        waitHelper.waitLoader();

//        By dashboardHeader = By.xpath("//h1[contains(text(),'Logistics')]");
//
//       // waitHelper.waitForPageLoad(driver);
//        waitHelper.waitForHeaderToBeStable(driver, dashboardHeader);

        //.waitForHeaderToBeStable

        //VideoRecorderUtil.startRecording(method.getName());
    }

    /**
     * tearDown
     *
     * @param result result
     * @throws Exception Exception
     */
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtil.takeScreenshot(driver, result.getName());
            AllureUtils.takeScreenshot(driver);

        }
        //  driver.quit();
        //  if (ITestResult.FAILURE == result.getStatus()) {
        //  ScreenshotUtil.takeScreenshot(driver, result.getName());
        //   }
        // VideoRecorderUtil.stopRecording();
          driver.quit();
    }
}
