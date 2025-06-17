package pages.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

import java.util.List;

public class CartDM
{
    // Busco producto en el carrito
    public static WebElement getProductInCart(WebDriver driver, String producto)
    {
        return FactoryWebElements.initWithXpath(driver,"//td[contains(text(), '"+producto+"')]");
    }
    // Buscar el valor del producto
    public static List<WebElement> getValueOfProductInCart(WebDriver driver, String producto)
    {
        return FactoryWebElements.initElementsWithXpath(driver,"//td[contains(text(), '"+producto+"')]//following-sibling::td");
    }
    // Buscar el valor del producto
    public static List<WebElement> getValueOfProductInCart(WebDriver driver)
    {
        return FactoryWebElements.initElementsWithXpath(driver,"//tr[@class='success']//child::td[3]");
    }
    // Busco el total de los productos
    public static WebElement getTotalValueInCart(WebDriver driver)
    {
        return FactoryWebElements.initWithXpath(driver,"//h3[@id='totalp']");
    }
    // Busco el boton Place Order
    public static WebElement getButtonPlaceOrderInCart(WebDriver driver, String tituloButton)
    {
        return FactoryWebElements.initWithXpath(driver,"//button[contains(text(),'"+tituloButton+"')]");
    }
    // Busco el titulo Place Order
    public static WebElement getModalForTitle(WebDriver driver)
    {
        return FactoryWebElements.initWithXpath(driver,"//div[@class='modal-content']//child::div[@class='modal-header']//h5[text()='Place order']");
        //h5[@class='modal-title' and text()='Place order']
    }
    // Busca cada elemento del formulario de purchase
    public static WebElement getFieldFormPurchase(WebDriver driver, String campo)
    {
        return FactoryWebElements.initWithXpath(driver,"//label[text()='"+campo+"']//following-sibling::input");
    }
    // Busca el mensaje Thank you for your purchase!
    public static WebElement getTitleMessagePurchase(WebDriver driver, String titulo)
    {
        return FactoryWebElements.initWithXpath(driver,"//h2[text()='"+titulo+"']");
    }

}

