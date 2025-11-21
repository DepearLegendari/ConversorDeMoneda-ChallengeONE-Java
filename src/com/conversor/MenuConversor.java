package com.conversor;

import java.util.Scanner;

public class MenuConversor {
    private final Conversor conversor;
    private final Scanner scanner = new Scanner(System.in);

    //Lista de monedas populares
    private final String[][] monedas = {
            {"USD", "Dólar Estadounidense"},
            {"MXN", " Peso Mexicano"},
            {"EUR", "Euro"},
            {"JPY", "Yen Japonés"},
            {"GBP", "Libra Esterlina"},
            {"CAD", "Dólar Canadiense"},
            {"BRL", "Real Brasileño"},
            {"COP", "Peso Colombiano"},
            {"CLP", "PEso Chileno"},
            {"ARS", "Peso Argentino"},
    };

    public MenuConversor(Conversor conversor) {
        this.conversor = conversor;
    }
    // Método para seleccionar una moneda
    private String elegirMoneda(String mensaje){
        System.out.println("\n" + mensaje);
        System.out.println("Elige una opción: ");

        for (int i = 0; i < monedas.length; i++){
            System.out.println((i + 1) + ")" + monedas[i][0] + " - " + monedas[i][1]);
        }

        System.out.println("Opción: ");
        String opcionTxt = scanner.nextLine().trim();

        if (opcionTxt.isEmpty()) {
            System.out.println("❌ Ingresa un número.");
            return null;
        }

        int opcion;
        try {
        opcion =Integer.parseInt(opcionTxt);
        }catch (NumberFormatException e){
            System.out.println("❌ Opción inválida.");
            return null;
        }

        if (opcion < 1 || opcion > monedas.length){
            System.out.println("❌ Opción fuera de rango.");
            return null;
        }
        return monedas[opcion-1][0];  // Regresamos el código ISO
    }


    public void iniciar () {

        System.out.println("==============================");
        System.out.println("     CONVERSOR DE MONEDAS     ");
        System.out.println("==============================");

        boolean continuar = true;

        while (continuar) {
            try{
                // 1. Seleccionar DIVISA de monedas Base
                String from = elegirMoneda("Selecciona la moneda Origen");
                if (from == null) continue;
                // 2. Moneda destino
                String to = elegirMoneda("Selecciona la moneda destino");
                if (to ==  null) continue;
                // 3. Monto
                System.out.println("\nIngresa el monto a convertir: ");
                String montoTxt = scanner.nextLine().trim();

                if (montoTxt.isEmpty()) {
                    System.out.println("❌ Debes ingresar un monto válido.");
                    continue;
                }

                double amount = Double.parseDouble(montoTxt);
                // 4. Conversión
                double resultado = conversor.convertir(from, to, amount);


                // 5. Resultado
                System.out.println("\n==============================");
                System.out.println(amount + " " + from + " equivale a: "
                        + "👉  " + resultado + " " + to);
                System.out.println("==============================");

            }catch (NumberFormatException e){
                System.out.println("❌ Monto inválido. Por favor ingresa un número.");
            }catch (IllegalArgumentException e){
                System.out.println("❌ " + e.getMessage());
            }catch (Exception e){
                System.out.println("⚠ Error inesperado: " + e.getMessage());
            }

            // Preguntar si quiere continuar
            System.out.println("¿Deseas realizar otra conversión? (S/N): ");
            String respuesta = scanner.nextLine( ).trim().toLowerCase();

            if (!respuesta.equals("s")){
                continuar = false;
            }
        }

        System.out.println("\nGracias por usar el conversor");

    }
}