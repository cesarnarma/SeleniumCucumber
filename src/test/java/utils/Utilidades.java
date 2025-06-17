package utils;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class Utilidades {

    public static List<String> getListSimple(DataTable dataTable)
    {
        List<String> lista = dataTable.asList(String.class);
        return lista;
    }

    public static List<Map<String, String>> getListComplex(DataTable dataTable)
    {
        List<Map<String, String>> lista = dataTable.asMaps(String.class, String.class);
        return lista;
    }

    public static String getProperties(String property)
    {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("config.properties"))
        {
            properties.load(input);
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void ingresarTextoLento(WebElement input, String palabra)
    {
        char[] arreglo = palabra.toCharArray();
        for(int i = 0; i<palabra.length(); i++)
        {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(601) + 900;
            input.sendKeys(arreglo[i]+"");
            try {
                Thread.sleep(numeroAleatorio);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
