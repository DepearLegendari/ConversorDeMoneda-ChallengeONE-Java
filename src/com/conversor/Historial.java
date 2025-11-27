package com.conversor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Historial {
    // Registro en Memoria
    private final List<String> registros = new ArrayList<>();
    // Formato de Fecha/hora para los registros
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Agregar una conversión al historial
     *
     * @param from        Código moneda origen (USD)
     * @param to          Código moneda destino (MXN)
     * @param cantidad    Monto original
     * @param resultado   Resultado de la Conversión
     */
    public void agregar(String from, String to, double cantidad, double resultado){
        LocalDateTime ahora = LocalDateTime.now();

        String registro = "[" + ahora.format(formato) + "] "
                + String.format("%.2f",cantidad) + " " + from.toUpperCase()
                + "->" + String.format("%.2f",resultado) + " " + to.toUpperCase();

        registros.add(registro); // queda en memoria
    }

    // Mostrar historial
    public void mostrar() {
        if (registros.isEmpty()) {
            System.out.println("📭 Aún no hay conversiones registradas.");
            return;
        }

        System.out.println("\n HISTORIAL DE CONVERSIONES:");
        registros.forEach(r -> System.out.println(" - " + r));
    }

    /**
     * Guarda todo el historial actual al archivo (remplazamos el archivo entero).
     * Util para sobreescribir con el estado actual.
     *
     * @param ruta del archivo ("historia_conversiones.txt")
     */
    public void guardarUltimoEnArchivo(String ruta) {
        try {
            if (registros.isEmpty()) return; // Nada que guardar

            Path path = Path.of(ruta);
            String ultimo = registros.get(registros.size() - 1) + System.lineSeparator();

            // Se crea el archivo si no existe y escribe en modo append
            Files.writeString(
                    path,
                    ultimo,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (Exception e) {
            System.out.println("⚠ Error guardando historial: " + e.getMessage());
        }
    }
}
