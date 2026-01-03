package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    private static String testFolder = "src/main/resources/failedTests";
    private static int screenshotCounter = 0;

    public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            // Create folder if not exists
            Files.createDirectories(Paths.get(testFolder));

            screenshotCounter++;
            String fileName = String.format("%03d_%s_%s.png",
                    screenshotCounter,
                    testName.replaceAll("[^a-zA-Z0-9]", "_"),
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"))
            );

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), Paths.get(testFolder + "/" + fileName));

            System.out.println("Screenshot saved: " + testFolder + "/" + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
