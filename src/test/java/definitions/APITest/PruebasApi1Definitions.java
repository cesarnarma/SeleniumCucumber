package definitions.APITest;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import utils.ApiRestUtils.ApiResponse;

public class PruebasApi1Definitions
{
    public static ApiResponse response = null;

    @Given("ejecuto el servicio {string} con el endpoint {string} y headers {string}")
    public void ejecuto_el_servicio_con_el_endpoint_y_headers(String servicio, String endpoint, String headers, DataTable dataTable)
    {
        String jsonBase = JsonUtils.obtieneJsonBase(servicio+".json");
        String url = ContantesAPI.getURL(endpoint);
        List<Map<String, String>> currencies = Utilidades.getListComplex(dataTable);
        //obtenemos la primera fila
        Set<String> primeraFila = currencies.get(0).keySet();
        List<String> nombresEncabezados = List.copyOf(primeraFila);

        for(Map<String, String> currency: currencies)
        {
            for(int i=0; i< nombresEncabezados.size(); i++)
            {
                jsonBase = JsonUtils.modificarJson(jsonBase, nombresEncabezados.get(i), currency.get(nombresEncabezados.get(i)));
            }
        }
        response = ApiRestUtils.enviarPost(Headers.getHesders(headers), jsonBase, url);
    }

    @Then("valido que la respuesta es {string}")
    public void valido_que_la_respuesta_es(String cod)
    {
        int codigoReal = response.getResponseCode();
        int codigoEsperado = Integer.parseInt(cod);
        Assertions.assertTrue(codigoEsperado == codigoReal, "El código del servicio no es el esperado" +
                "Se esperaba <<"+cod+">> pero se encuentra <<"+codigoReal+">>");
    }

}
