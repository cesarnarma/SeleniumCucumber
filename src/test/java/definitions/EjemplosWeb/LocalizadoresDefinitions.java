package definitions.EjemplosWeb;

import configs.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.saucedemo.HomeSauce;

public class LocalizadoresDefinitions
{
    WebDriver driver = WebDriverManager.getDriver();

    @Given("estoy en la web de {string}")
    public void estoy_en_la_web_de(String url)
    {
        driver.get(url);

    }

    @When("ingreso el username {string}")
    public void ingreso_el_username(String userName) throws InterruptedException
    {
        Thread.sleep(2000);
        //WebElement inputNombre  = driver.findElement(By.id("user-name"));
        //inputNombre.sendKeys(userName);
        //Misma prueba pero con localizadores XPATH
        //driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(userName);

        HomeSauce.getInputUserName(driver).sendKeys(userName);
    }

    @And("ingreso el password {string}")
    public void ingreso_el_password(String password) throws InterruptedException
    {
        Thread.sleep(2000);
        //driver.findElement(By.id("password")).sendKeys(password);
        //Misma prueba pero con localizadores XPATH
        //driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(password);

        HomeSauce.getInputPassword(driver).sendKeys(password);
    }

    @And("presiono el boton Login")
    public void presiono_el_boton_login()
    {
        //driver.findElement(By.className("submit-button")).click();
        //Misma prueba pero con localizadores XPATH
        //driver.findElement(By.xpath("//input[contains(@class,'submit')]")).click();

        HomeSauce.getButtonSubmit(driver).click();
    }

    @Then("valido que me he logeado en el sitio de ejemplo")
    public void valido_que_me_he_logeado_en_el_sitio_de_ejemplo() throws InterruptedException
    {
        Thread.sleep(3000);
        Assert.assertTrue("No se ha realizado el login",driver.findElement(By.xpath("//span[contains(text(),'Products')]")).isDisplayed());
    }
}


