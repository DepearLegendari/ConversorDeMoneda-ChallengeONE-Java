package com.conversor;
// Incluye: selección de monedas, historial y ejecución de conversiones paso a paso.
import java.util.Scanner;

public class MenuConversor {
    // Instancia del conversor que realiza las operaciones matemáticas
    private final Conversor conversor;
    private final Scanner scanner = new Scanner(System.in);
    private final Historial historial = new Historial();

    //Lista de monedas populares
    private final String[][] monedas = {
            //{Código ISO, Nombre completo}

            {"USD", "Dólar Estadounidense"},
            {"MXN", " Peso Mexicano"},
            {"EUR", "Euro"},
            {"JPY", "Yen Japonés"},
            {"GBP", "Libra Esterlina"},
            {"CAD", "Dólar Canadiense"},
            {"NZD", "Dólar Neozelandés"},
            {"CHF", "Franco Suizo"},
            {"CNY", "Yuan Chino"},
            {"KRW", "Won Surcoreano"},
            {"SEK", "Corona Sueca"},
            {"MOK", "Corona Noruega"},
            {"Dkk", "Corona Danesa"},
            {"BRL", "Real Brasileño"},
            {"COP", "Peso Colombiano"},
            {"CLP", "PEso Chileno"},
            {"ARS", "Peso Argentino"},
            {"PEN", "Sol Peruano"},
            {"UYU", "Peso Uruguayo"}
    };

    public MenuConversor(Conversor conversor) {
        this.conversor = conversor;
    }
    // Método para seleccionar una moneda
    private String elegirMoneda(String mensaje) {
        System.out.println("\n" + mensaje);
        System.out.println("Elige una opción: ");

        for (int i = 0; i < monedas.length; i++) {
            System.out.println((i + 1) + ") " + monedas[i][0] + " - " + monedas[i][1]);
        }

        System.out.print("Opción: ");
        String opcionTxt = scanner.nextLine().trim();

        int opcion;
        try {
            opcion = Integer.parseInt(opcionTxt);
        } catch (NumberFormatException e){
            System.out.println("❌ Opción inválida.");
            return null;
        }

        if (opcion < 1 || opcion > monedas.length){
            System.out.println("❌ Opción fuera de rango.");
            return null;
        }

        return monedas[opcion-1][0];  // Regresamos el código ISO
    }

    // Método principal del Menú: muestra opciones y controla el flujo del programa

    public void iniciar () {
        boolean continuar = true;

        while (continuar) {
            System.out.println("==============================");
            System.out.println("     CONVERSOR DE MONEDAS     ");
            System.out.println("==============================");
            System.out.println("1) Realizar conversión");
            System.out.println("2) Ver historial de conversion");
            System.out.println("3) Salir");
            System.out.print("Selecciona una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    realizarConversion();
                    break;
                case "2":
                    historial.mostrar();
                    break;
                case "3":
                    continuar = false;
                    break;
                default:
                    System.out.println("❌ Opción invalida");
            }
        }

        System.out.println("Gracias por usar el conversor");
    }

    private void realizarConversion() {

        boolean continuarConversion = true;

        while (continuarConversion) {
            try{
                // 1. Seleccionar DIVISA de monedas Base
                String from = elegirMoneda("Selecciona la moneda Origen:");
                if (from == null) return;
                // 2. Moneda destino
                String to = elegirMoneda("Selecciona la moneda destino:");
                if (to == null) return;
                // 3. Monto
                System.out.print("\nIngresa el monto a convertir: ");
                String montoTxt = scanner.nextLine().trim();

                if (montoTxt.isEmpty()) {
                    System.out.println("❌ Debes ingresar un monto válido.");
                    return;
                }
                // 4. Conversión
                // VARIABLE donde guardaremos el monto convertido a número
                double amount;
                try {
                    amount = Double.parseDouble(montoTxt);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Monto inválido. Por favor ingresa un número.");
                    return;
                }
                // Llamamos al conversor para obtener el resultado final
                double resultado = conversor.convertir(from, to, amount);
                // 5. Resultado
                System.out.println("\n==============================");
                System.out.println(amount + " " + from + " equivale a: ");
                System.out.println("👉  " + resultado + " " + to);
                System.out.println("==============================");
                // 6. Selección, validación, cálculo y guardado en el historial
                historial.agregar(from, to, amount, resultado);
                // Preguntar al usuario si desea realizar otra conversión
                System.out.print("¿Deseas realizar otra conversión? (S/N): ");
                String respuesta = scanner.nextLine( ).trim().toLowerCase();

                if (!respuesta.equals("s")) {
                    return; // Finaliza este método y vuelve el menú principal
                }

            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            } catch (Exception e) {
                // Este Bloque captura cualquier error inesperado
                System.out.println("⚠ Error inesperado: " + e.getMessage());
            }
        }
    }
}