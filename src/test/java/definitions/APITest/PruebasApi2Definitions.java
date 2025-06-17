package definitions.APITest;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import utils.Utilidades;

import java.util.ArrayList;

public class PruebasApi2Definitions {

    @Then("valido que el body response tiene los campos correctos")
    public void valido_que_el_body_response_tiene_los_campos_correctos(DataTable dataTable)
    {
        ArrayList<String> lista = new ArrayList<>(Utilidades.getListSimple(dataTable));
        lista.remove(0); //solo si se ha especificado un encabezado en la tabla
        String jsonRespuesta = PruebasApi1Definitions.response.getResponseContent();
        for(String nodo : lista)
        {
            String valorNodo = JsonPath.read(jsonRespuesta, "$."+nodo).toString();
            Assertions.assertTrue(valorNodo != null, "El nodo <<"+nodo+">> no existe en la respuesta: "+jsonRespuesta);
        }
    }

    @Then("valido que el body response indica que para una conversion de {int} el resultado es correcto")
    public void valido_que_el_body_response_indica_que_para_una_conversion_de_el_resultado_es_correcto(Integer amount)
    {
        String jsonRespuesta = PruebasApi1Definitions.response.getResponseContent();
        int exchangeRate = JsonPath.read(jsonRespuesta, "$.exchangeRate");
        int totalCambio = amount * exchangeRate;

        int convertedAmount = JsonPath.read(jsonRespuesta, "$.convertedAmount");
        System.out.println("el servicio retorna <<"+convertedAmount+">> y la multiplicacion es <<"+totalCambio+">>");

        Assertions.assertTrue(totalCambio == convertedAmount, "Los montos no son iguales. " +
                "el servicio retorna <<"+convertedAmount+">> y la multiplicacion es <<"+totalCambio+">>");
    }

    @Then("valido que la respuesta incluye el mensaje {string}")
    public void valido_que_la_respuesta_incluye_el_mensaje(String msg_esperado) {
        String jsonRespuesta = PruebasApi1Definitions.response.getResponseContent();
        String msg_error = JsonPath.read(jsonRespuesta, "$.error");
        Assertions.assertTrue(msg_error.equals(msg_esperado), "El mensaje de respuesta no es correcto");
    }

}
