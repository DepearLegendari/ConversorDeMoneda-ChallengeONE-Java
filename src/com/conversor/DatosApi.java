package com.conversor;

import java.util.Map;
// Clase modelo que representa la respuesta JSON de exchangeRate-API
// Gson mapeará automáticamente las propiedades JSON a los campos de esta clase.
public class DatosApi {
    private String base_code;

    // JSON:"conversion_rates"
    private Map<String, Double> conversion_rates;

    // GSON - accesibilidad para mapear los datos
    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}
