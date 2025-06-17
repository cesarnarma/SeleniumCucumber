package definitions.BBDDTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.SqlUtils;

import java.util.ArrayList;

public class BBDDefinitions {

    private ArrayList<ArrayList<String>> resultados = null;

    @Given("realizo la consulta para ID {int}")
    public void realizo_la_consulta_para_id(Integer id)
    {
        String query = "SELECT nombre, apellido_materno FROM automatizacion.usuarios where idusuarios = "+id+";";
        String[] columnas = {"nombre", "apellido_materno"};
        resultados = SqlUtils.obtenerResultadosQuery(query, columnas);
    }

    @Then("valido que el nombre sea {string} y el apellido materno es {string}")
    public void valido_que_el_nombre_sea_y_el_apellido_materno_es(String nombreRes, String apellidoMaternoRes)
    {
        String nombre = resultados.get(0).get(0);
        String apellido_materno = resultados.get(0).get(1);
        System.out.println("El nombre es <"+nombre+"> y el apellido materno es <"+apellido_materno+">");
        Assert.assertTrue("El nombre no es correcto", nombreRes.equals(nombre));
        Assert.assertTrue("El apellido no es correcto", apellidoMaternoRes.equals(apellido_materno));
    }

    @Given("realizo la consulta para verificar el tipo de usuario para ID {int}")
    public void realizo_la_consulta_para_verificar_el_tipo_de_usuario_para_id(Integer id) {
        String query = "SELECT tipo FROM automatizacion.usuarios where idusuarios = "+id+";";
        String[] columnas = {"tipo"};
        resultados = SqlUtils.obtenerResultadosQuery(query, columnas);
    }

    @Then("valido el tipo de usuario pars el ID es {string}")
    public void valido_el_tipo_de_usuario_pars_el_id_es(String tipoEsperado) {
        String tipo = resultados.get(0).get(0);
        System.out.println("tipo esperado es <"+tipoEsperado+"> y encontrado en la BBDD es  <"+tipo+">");
        Assert.assertTrue("El tipo no es correcto", tipoEsperado.equals(tipo));
    }

}

