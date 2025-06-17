package definitions.EjemplosWeb;

import configs.WebDriverManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AsercionesDefinitions
{
    private final WebDriver driver = WebDriverManager.getDriver();

    @Then("valido que el titulo sea {string}")
    public void valido_que_el_titulo_sea(String mensaje) throws InterruptedException
    {
        Thread.sleep(2000);
        String tituloReal= driver.findElement(By.xpath("//div[contains(@class, 'login_logo')]")).getText();
        String tituloEsperado = mensaje;
        // Prueba AsseEquals
        //Assert.assertEquals("** Los mensajes no son iguales", tituloEsperado, tituloReal);

        //Prueba Asser True
        Assert.assertTrue("El resultado esperado es: "+mensaje+"\n" +
                "y el encontrado es: "+tituloReal, mensaje.equals(tituloReal));

    }
}


