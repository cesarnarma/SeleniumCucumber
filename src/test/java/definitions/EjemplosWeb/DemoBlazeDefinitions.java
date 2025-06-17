package definitions.EjemplosWeb;

import configs.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.demoblaze.HomeDM;
import pages.demoblaze.ProductosDM;

public class DemoBlazeDefinitions
{
    private final WebDriver driver = WebDriverManager.getDriver();

    @Then("valido que existe la categoria de {string}")
    public void valido_que_existe_la_categoria_de(String categoria)
    {
        Boolean test = HomeDM.getCategoria(driver,categoria).isDisplayed();
        Assert.assertTrue("La categoria <<"+categoria+">>no esta desplegada en el front!", test);
    }
    @When("ingreso a la categoria {string}")
    public void ingreso_a_la_categoria(String categoria) throws InterruptedException {
        HomeDM.getCategoria(driver, categoria).click();
        Thread.sleep(2000);
    }
    @Then("valido que no existan menos de {string} productos")
    public void valido_que_no_existan_menos_de_productos(String numProd)
    {
        int numeroProdEsperado = Integer.parseInt(numProd);
        int numeroProdFront = HomeDM.getProductos(driver).size();
        System.out.println("Se esperan :"+numeroProdEsperado+" Elementos");
        System.out.println("Se encuentran :"+numeroProdFront+" Elementos en el front");
        Assert.assertTrue("El numero de productos es menor al esperado", numeroProdFront >= numeroProdEsperado);
    }
    @Then("valido que no existan mas de {string} productos")
    public void valido_que_no_existan_mas_de_productos(String numProd)
    {
        int numeroProdEsperado = Integer.parseInt(numProd);
        int numeroProdFront = HomeDM.getProductos(driver).size();
        System.out.println("Se esperan :"+numeroProdEsperado+" Elementos");
        System.out.println("Se encuentran :"+numeroProdFront+" Elementos en el front");
        Assert.assertTrue("El numero de productos es mayor al esperado", numeroProdEsperado >= numeroProdFront);
    }
    @Then("valido que el nombre de la pestaña es {string}")
    public void valido_que_el_nombre_de_la_pestaña_es(String tituloEsperado)
    {
        String tituloReal = driver.getTitle();
        System.out.println("Se esperan :"+tituloEsperado+" como titulo");
        System.out.println("Se encuentra :"+tituloReal+" como titulo");
        Assert.assertEquals("Los titulos no coinciden",tituloEsperado, tituloReal);
    }
    @When("realizo click sobre el producto {string}")
    public void realizo_click_sobre_el_producto(String nombreProducto)
    {
        HomeDM.getProducto(driver, nombreProducto).click();

    }
    @Then("valido que la ficha corresponde a {string}")
    public void valido_que_la_ficha_corresponde_a(String tituloEsperado) throws InterruptedException
    {
        Thread.sleep(3000);
        String tituloReal = ProductosDM.getTituloProducto(driver).getText();
        System.out.println("Se esperan :"+tituloEsperado+" como titulo");
        System.out.println("Se encuentra :"+tituloReal+" como titulo del producto");
        Assert.assertEquals("Los titulos no coinciden",tituloEsperado, tituloReal);

    }
}
