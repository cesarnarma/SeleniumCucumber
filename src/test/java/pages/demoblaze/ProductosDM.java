package pages.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

public class ProductosDM
{
    // valida categorias de la pagina
    public static WebElement getTituloProducto(WebDriver driver)
    {
        return FactoryWebElements.initWithXpath(driver,"//h2[@class='name']");
    }
    // obtengo el valor del producto seleccionado
    public static WebElement getValorProducto(WebDriver driver)
    {
        return FactoryWebElements.initWithXpath(driver,"//h3[@class='price-container']");
    }
    // Presionar el boton add to cart
    public static WebElement getButton(WebDriver driver, String texto)
    {
        return FactoryWebElements.initWithXpath(driver,"//a[contains(@class, btn) and contains(text(), '"+texto+"')]");
    }

}
