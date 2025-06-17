
package configs;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
public class WebDriverManager
{
    public static WebDriver driver = null;
    //Activa esta variable si no haz configurado tu variable de entorno
    //Si ese es el caso debes comentar la llamada al metodo getBroser()
    //private static final String BROWSER = "MOZILLA";

    public static WebDriver getDriver()
    {
        //String BROWSER = getBrowser();

        if(driver == null)
        {
            // if(BROWSER.equals("CHROME"))
            //{

           // System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--window-size=1300,600");
            options.addArguments("--start-maximized");
            //options.addArguments("--headless");
           // options.addArguments("--no-sandbox");
           // options.addArguments("--disable-web-security");
            //options.addArguments("start-fullscreen");

            //io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
           // driver =  new ChromeDriver(options);
            driver = new FirefoxDriver();

            /*}
            else if(BROWSER.equals("MOZILLA"))
            {
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\webdrivers\\geckodriver.exe");
                //FirefoxOptions options = new FirefoxOptions();
                //options.addArguments("--window-size=1920,1080");

                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }*/
        }
        return driver;
    }

    /*
     * Obtiene el valor de la variable de entorno BROWSER
     * */
    private static String getBrowser()
    {
        String browser = null;
        browser = System.getenv("BROWSER");
        return browser;
    }

}
