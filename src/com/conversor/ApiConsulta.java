package com.conversor;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsulta {


    private final String apiKey = "cc3bd21ee4455ed20662b529";

    public String obtenerDatos(String monedaBase){
        // 1. Creamos el cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        // 2. Creamos la URL Dinámicamente
        String url = "https://v6.exchangerate-api.com/v6/"+ apiKey + "/latest/" +  monedaBase;

        // 3. Creamos la solicitud y guardamos la respuesta
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        try {
            // 4. Enviamos la solicitud y guardamos la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body(); // Devuelve El JSON en texto

        }catch (Exception e){
            throw new RuntimeException("Error al consultar la API: " + e.getMessage());
        }
    }
    public DatosApi obtenerDatosApi(String monedaBase){
        String json = obtenerDatos(monedaBase);
        Gson gson = new Gson();
        // Convierte el texto JSON a un objeto Java
        DatosApi datos = gson.fromJson(json, DatosApi.class);
        return datos;
    }

}
