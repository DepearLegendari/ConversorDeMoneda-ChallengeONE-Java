package com.conversor;

import java.util.Map;
import java.math.RoundingMode;

public class Conversor {
    private final ApiConsulta apiConsulta;

    public Conversor(ApiConsulta apiConsulta) {
        this.apiConsulta = apiConsulta;
    }
    /**
     * Convierte una cantidad desde ´from´ hacia otra usando la API
     * @param from moneda origen (ej "EUR")
     * @param to moneda destino (ej "MXN")
     * @param amount monto a convertir
     * @return monto convertido
     * @throws Exception si algo falla
     */

    public double convertir(String from, String to, double amount) throws Exception {
        // 1. Convertir a objeto DatosApi
        DatosApi datos = apiConsulta.obtenerDatos(from);

        // 3. Obtener MApa de tasas
        Map<String, Double> tasas = datos.getConversion_rates();

        // 4. Obtener tasa de destino
        Double tasaDestino = tasas.get(to.toUpperCase());

        if (tasaDestino == null) {
            throw new IllegalArgumentException("Moneda no encontrada: " + to);
        }

        // 5. Calcular resultados
        return amount * tasaDestino;
    }
}
