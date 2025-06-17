package definitions.EjemplosWeb;

import configs.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.demoblaze.CartDM;
import pages.demoblaze.ProductosDM;

import java.util.List;

public class DemoBlaze2Definitions
{
    private final WebDriver driver = WebDriverManager.getDriver();
    private int costoProducto = 0;

    @When("obtengo el valor del producto seleccionado")
    public void obtengo_el_valor_del_producto_seleccionado()
    {
        String valorTemp = ProductosDM.getValorProducto(driver).getText();
        //System.out.println("El valor que viene es:"+valorTemp);
        String valorReal = valorTemp.split(" ")[0].replace("$","");
        //int costo = Integer.parseInt(valorReal);
        //System.out.println("el valor real de entero es :"+costo);
        this.costoProducto = Integer.parseInt(valorReal);

    }
    @When("presiono el boton {string}")
    public void presiono_el_boton(String texto)
    {
        ProductosDM.getButton(driver, texto).click();

    }
    @When("presiono aceptar sobre el alert")
    public void presiono_aceptar_el_alert() throws InterruptedException {
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);

    }
    @When("presiono el menu {string}")
    public void presiono_el_menu(String menu)
    {
        ProductosDM.getButton(driver, menu).click();
    }
    @Then("valido que el producto añadido sea {string}")
    public void valido_que_el_producto_añadido_sea(String titulo)
    {
        CartDM.getProductInCart(driver, titulo);
    }
    @Then("valido que el costo del producto {string} es el correcto")
    public void valido_que_el_costo_del_producto_es_el_correcto(String producto) throws InterruptedException {
        Thread.sleep(3000);
        int valorEnCarro = Integer.parseInt(CartDM.getValueOfProductInCart(driver, producto).get(0).getText());
        Assert.assertTrue("Los valores no coinciden", this.costoProducto == valorEnCarro);
    }
    @Then("valido que el total sea correcto segun la suma de los valores del carrito")
    public void valido_que_el_total_sea_correcto_segun_la_suma_de_los_valores_del_carrito() {
        List<WebElement> listaValores = CartDM.getValueOfProductInCart(driver);
        int totalParcial = 0;
        for (WebElement e : listaValores) {
            totalParcial = totalParcial + Integer.parseInt(e.getText());
        }
        int totalReal = Integer.parseInt(CartDM.getTotalValueInCart(driver).getText());
        Assert.assertTrue("Los totales no coinciden. La suma es<<" + totalParcial + ">>" + " y el front muestra<<" + totalReal + ">>", totalParcial == totalReal );
    }
    @When("realizo click sobre el boton {string}")
    public void realizo_click_sobre_el_boton(String titulo) throws InterruptedException {
        Thread.sleep(3000);
        CartDM.getButtonPlaceOrderInCart(driver, titulo).click();

    }
    @Then("valido que se muesta el formulario de compra")
    public void valido_que_se_muesta_el_formulario_de_compra()
    {
        CartDM.getModalForTitle(driver);
    }
    @When("ingreso {string} en el campo {string}")
    public void ingreso_en_el_campo(String dato, String campo) throws InterruptedException
    {
        Thread.sleep(2000);
        CartDM.getFieldFormPurchase(driver, campo).sendKeys(dato);
    }
    @Then("valido que se muestra el mensaje de exito {string}")
    public void valido_que_se_muestra_el_mensaje_de_exito(String titulo)
    {
        CartDM.getTitleMessagePurchase(driver, titulo);
    }
    @Then("valido que se muestra el mensaje de error {string}")
    public void valido_que_se_muestra_el_mensaje_de_error(String mensaje) throws InterruptedException
    {
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String mensajeAlert = alert.getText();
        Thread.sleep(3000);
        System.out.println("El alert dice: "+mensajeAlert);
        Assert.assertTrue("El mensaje del alert no es el esperado <<"+mensajeAlert+">>",mensaje.equals(mensajeAlert));
    }
}
