package pages.abstracta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

public class HomeAbs
{
    // Busco etiquetas del menu inferior cualquier etiqueta
    public static WebElement getItemMenuFooter(WebDriver driver, String item)
    {
        return FactoryWebElements.initWithXpath(driver,"//li//child::a[text()='"+item+"']");
    }


}
