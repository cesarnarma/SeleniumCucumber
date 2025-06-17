package pages.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

public class HomeSauce
{
    // **** PAGINA DE INICIO LOCALIZADORES *****
    // Campo: Usuario
    public static WebElement getInputUserName(WebDriver driver)
    {
        return FactoryWebElements.initWithXpath(driver,"//input[@placeholder='Username']");
    }
    // Campo: Contraseña
    public static WebElement getInputPassword(WebDriver driver)
    {
        return FactoryWebElements.initWithXpath(driver,"//input[@data-test='password']");
    }
    // Boton: Ingresar
    public static WebElement getButtonSubmit(WebDriver driver)
    {
        return FactoryWebElements.initWithXpath(driver,"//input[contains(@class,'submit')]");
    }
}

