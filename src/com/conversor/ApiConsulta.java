package com.conversor;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsulta {
    // API Key
    private final String apiKey = "cc3bd21ee4455ed20662b529";
    // -------------------------------
    // 1️⃣ Método para obtener los datos JSON desde la API
    // -------------------------------
    public String obtenerJson(String monedaBase){
        try {
        // 1. Creamos el cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        // 2. Creamos la URL Dinámicamente
        String url = "https://v6.exchangerate-api.com/v6/"+ apiKey + "/latest/" +  monedaBase;

        // 3. Creamos la solicitud y guardamos la respuesta
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

            // 4. Enviamos la solicitud y guardamos la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body(); // Devuelve El JSON en texto

        }catch (Exception e){
            throw new RuntimeException("Error al consultar la API: " + e.getMessage());
        }
    }
    // -------------------------------
    // 2️⃣ Método para convertir el JSON a un objeto Java usando Gson
    // -------------------------------
    public DatosApi convertirJson(String Json){
        Gson gson = new Gson(); // Convierte texto JSON -> Objeto Java (DatosApi)
        return gson.fromJson(Json, DatosApi.class);// Convierte el Json en MONEDAS
    }
    // 3️⃣ Método final que usa los dos → ESTE usa tu clase Conversor
    public DatosApi obtenerDatos(String monedaBase){
       String json = obtenerJson(monedaBase);
       return convertirJson(json);
    }
}
