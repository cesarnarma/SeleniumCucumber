package utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ApiRestUtils {
    public static void main(String[] args) {
        // Puedes probar el código aquí.
    }

    public static String enviarGet(Map<String, String> headers, String apiUrl) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(apiUrl);
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
            HttpResponse response = httpClient.execute(httpGet);
            return responseToString(response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static ApiResponse enviarPost(Map<String, String> headers, String jsonBody, String apiUrl) {
        try {
            // Aquí enviamos el JSON como cadena directamente
            ApiResponse response = sendPostRequest(apiUrl, jsonBody, headers);
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static ApiResponse sendPostRequest(String apiUrl, String jsonBody, Map<String, String> headers) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); // Asegúrate de establecer el Content-Type

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        // Escribir el cuerpo de la solicitud
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonBody.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Obtener el código de respuesta
        int responseCode = connection.getResponseCode();

        StringBuilder responseContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                responseContent.append(responseLine.trim());
            }
        } catch (IOException e) {
            try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), "utf-8"))) {
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    responseContent.append(errorLine.trim());
                }
            }
        } finally {
            connection.disconnect();
        }

        return new ApiResponse(responseCode, responseContent.toString());
    }

    private static String responseToString(HttpResponse response) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        }
    }

    public static class ApiResponse {
        private final int responseCode;
        private final String responseContent;

        public ApiResponse(int responseCode, String responseContent) {
            this.responseCode = responseCode;
            this.responseContent = responseContent;
        }

        public int getResponseCode() {
            return responseCode;
        }

        public String getResponseContent() {
            return responseContent;
        }
    }
}


