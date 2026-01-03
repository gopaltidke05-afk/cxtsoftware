package baseTest;

import Utilities.ScreenshotUtil;
import Utilities.VideoRecorderUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

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
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        }
        VideoRecorderUtil.stopRecording();
      //  driver.quit();
    }
}
