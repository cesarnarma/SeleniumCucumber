package utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils
{
    static String rutaBaseJsons = "src\\test\\resources\\jsons\\";

    public static String obtieneJsonBase(String jsonName)
    {
        try {
            String json = new String(Files.readAllBytes(Paths.get(rutaBaseJsons+jsonName)));
            return json;
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    // Método de modificarJson
    public static String modificarJson(String json, String nodo, String nuevoValor) {
        try {
            DocumentContext documentContext = JsonPath.parse(json);
            documentContext.set(nodo, nuevoValor);
            return documentContext.jsonString(); // Asegúrate de que sea un JSON válido
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /*
    public static void main(String a[])
    {
        String json = obtieneJsonBase("prueba.json");
        String nuevoJson = modificarJson(json,"$.hola", "Juanito");
        System.out.println(nuevoJson);
    }
    */

}
