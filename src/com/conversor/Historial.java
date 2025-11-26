package com.conversor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Historial {

    private final List<String> registros = new ArrayList<>();

    // Agregar una conversión al historial
    public void agregar(String from, String to, double cantidad, double resultado){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String registro = "[" + ahora.format(formato) + "] "
                + cantidad + " " + from.toUpperCase()
                + "->" + resultado + " " + to.toUpperCase();

        registros.add(registro);
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

}
