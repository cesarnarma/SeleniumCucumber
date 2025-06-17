package configs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.ReportUtils;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "definitions",
        tags = "@featurePruebasDemoBlaze or @featureBBDD",
        //publish = true
        plugin = {"json:src/test/resources/cucumber.json","html:src/test/resources/reportes/cucumber_report.html"}
)
public class RunCucumber {

    public RunCucumber()
    {

    }
    @AfterClass
    public static void after_all() throws IOException
    {
        ReportUtils.crearReporteExtent();

        if(WebDriverManager.driver != null)
        {
            WebDriverManager.driver.quit();
        }
    }
}
