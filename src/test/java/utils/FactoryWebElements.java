package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FactoryWebElements
{

    public static WebElement initWithXpath(WebDriver driver, String xpath)
    {
        WebElement elemento = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            return elemento;
        }catch (Exception ex)
        {
            Assert.assertTrue("Elemento web no encontrado <<"+xpath+">>",false);
        }
        return elemento;
    }
    public static List<WebElement> initElementsWithXpath(WebDriver driver, String xpath)
    {
        List<WebElement> elementos = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            elementos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
            return elementos;
        }catch (Exception ex)
        {
            Assert.assertTrue("Elemento web no encontrados <<"+xpath+">>",false);
        }
        return elementos;
    }
}
