package definitions.EjemplosWeb;

import configs.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.demoblaze.CartDM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTablesDefinitions
{

    private final WebDriver driver = WebDriverManager.getDriver();

    @Given("le estoy pasando al datablable una columna")
    public void le_estoy_pasando_al_datablable_una_columna(DataTable dataTable)
    {
        /*forma 1 Leyendo la lista desde el item 1
        List<String> lenguajes = dataTable.asList(String.class);
        for(int i = 1; i<lenguajes.size();i++ )
        {
            System.out.println("El lenguaje es: "+lenguajes.get(i));
        }
        */

        /*Forma 2 quitando un elemento*/
        List<String> lenguajes = new ArrayList<>(dataTable.asList(String.class));
        lenguajes.remove(0);
        for(String lenguaje : lenguajes)
        {
            System.out.println("El lenguaje es: "+lenguaje);
        }
    }

    @Given("le estoy pasando al datablable dos columnas")
    public void le_estoy_pasando_al_datablable_dos_columnas(DataTable dataTable)
    {
        List<Map<String, String>> ubicaciones = dataTable.asMaps(String.class, String.class);

        for(Map<String, String> ubicacion: ubicaciones)
        {
            System.out.println("En el pais de "+ubicacion.get("Paises")+
                    " está la ciudad de "+ubicacion.get("Ciudades"));
        }

    }

    /*
    @When("ingreso los datos del cliente en el formulario")
    public void ingreso_los_datos_del_cliente_en_el_formulario(DataTable dataTable) throws InterruptedException {
        List<String> datos = new ArrayList<>(dataTable.asList(String.class));
        datos.remove(0);
        CartDM.getFieldFormPurchase(driver, "Name:").sendKeys(datos.get(0));
        CartDM.getFieldFormPurchase(driver, "Country:").sendKeys(datos.get(1));
        CartDM.getFieldFormPurchase(driver, "City:").sendKeys(datos.get(2));
        CartDM.getFieldFormPurchase(driver, "Credit card:").sendKeys(datos.get(3));
        CartDM.getFieldFormPurchase(driver, "Month:").sendKeys(datos.get(4));
        CartDM.getFieldFormPurchase(driver, "Year:").sendKeys(datos.get(5));
    }*/

    @When("ingreso los datos del cliente en el formulario")
    public void ingreso_los_datos_del_cliente_en_el_formulario(DataTable dataTable) throws InterruptedException
    {
        List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);

        for(Map<String, String> dato: datos)
        {
            Thread.sleep(1000);
            CartDM.getFieldFormPurchase(driver, dato.get("Campo")).sendKeys(dato.get("Dato"));
           // Thread.sleep(1000);
        }
    }


}

