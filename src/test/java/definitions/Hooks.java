package definitions;

import configs.WebDriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Hooks
{
    @BeforeAll
    public static void before_all()
    {
        if(WebDriverManager.driver != null) {
            File folder = new File("src/test/resources/screenshots");
            if (folder.exists() && folder.isDirectory()) {
                File[] files = folder.listFiles();
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            } else {
                System.out.println("La carpeta de screenshots no existe.");
            }
        }
    }

    @AfterStep
    public static void captureScreenshotAfterStep(Scenario scenario) throws InterruptedException {
        if(WebDriverManager.driver != null)
        {
            Thread.sleep(1000);
            System.out.println("tomando captura");
            String nombreScenario = scenario.getName();
            try {
                byte[] screenshot = ((TakesScreenshot) WebDriverManager.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", nombreScenario);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
