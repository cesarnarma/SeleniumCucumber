package pages.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;
import java.util.List;

public class HomeDM
{
    // valida categorias de la pagina
    public static WebElement getCategoria(WebDriver driver, String categoria)
    {
        return FactoryWebElements.initWithXpath(driver,"//a[@id='itemc' and contains(text(),'"+categoria+"')]");
    }
    // valida categorias de la pagina
    public static WebElement getProducto(WebDriver driver, String producto)
    {
        return FactoryWebElements.initWithXpath(driver,"//a[@class='hrefch'and contains(text(),'"+producto+"')]");
    }
    // valida cantidad minima de productos
    public static List<WebElement> getProductos(WebDriver driver)
    {
        return FactoryWebElements.initElementsWithXpath(driver,"//div[@class='card-block']");
    }


}
