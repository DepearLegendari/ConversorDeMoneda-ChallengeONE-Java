🌎💱 Conversor de Monedas — Challenge ONE Java Back End


Este proyecto es un Conversor de Monedas en Java, diseñado como parte del programa
Oracle Next Education (ONE) en colaboración con Alura LATAM.

El sistema permite:

✔ Consultar en tiempo real las tasas de cambio desde la API ExchangeRate.

✔ Convertir entre múltiples monedas.

✔ Validar entradas del usuario.

✔ Mostrar menús interactivos.

✔ Procesar JSON con Gson.

✔ Estructurar el código con orientación a objetos.

---------- NUEVOS PROCESOS AGREGADOS 25 NOV 2025 ------------

✔ Conversión en tiempo real

✔ Historial de conversiones

✔ Lista de monedas ampliada

✔ Flujo continuo de conversiones

✔ Código comentado paso a paso para principiantes

============================================================================================

📌 Tecnologías utilizadas


Java 17+

Gson (Google)

HttpClient (Java)

ExchangeRate API

IntelliJ IDEA

POO (Programación Orientada a Objetos)

============================================================================================

🧩 Arquitectura del proyecto


El proyecto está dividido en clases limpias:

        (Clase)           (Función.)
        
        ApiConsulta	    Se conecta a la API y obtiene el JSON.
        
        DatosApi	    Representa el modelo de respuesta JSON.
        
        Conversor	    Realiza toda la lógica de conversión.
        
        MenuConversor	Interfaz con el usuario (menú dinámico).
        
        Histirual       Registro de Historial
        
        Principal	    Punto de entrada del programa.

============================================================================================

🔁 Flujo de Conversión


1️⃣ El usuario selecciona la moneda origen y destino.

2️⃣ El sistema válida entradas.

3️⃣ Se consulta la API usando HttpClient.

4️⃣ La respuesta JSON se transforma en objeto Java con Gson.

5️⃣ Se calcula la conversión usando las tasas recibidas.

6️⃣ Se muestra el resultado final formateado.

7️⃣ Registro de historial

8️⃣ Preguntar si desea otra conversión

============================================================================================

💹 Monedas disponibles (versión básica)


USD – Dólar estadounidense

MXN – Peso mexicano

ARS – Peso argentino

BRL – Real brasileño

CLP – Peso chileno

COP – Peso colombiano

EUR – Euro

JPY - Yen japonés

GBP - Libra esterlina

CAD - Dólar canadiense

AUD - Dólar australiano

NZD - Dólar neozelandés

CHF - Franco suizo

CNY - Yuan chino

KRW - Won surcoreano

SEK - Corona sueca

NOK - Corona noruega

DKK - Corona danesa

BRL - Real brasileño

PEN - Sol peruano

UYU - Peso uruguayo

Con soporte para más monedas mediante la API 🌍.

============================================================================================

✨ Historial de Conversiones

El programa almacena todas las conversaciones realizadas durante la sesión en la clase
Historial, indicando:
    
    * Fecha
    
    * Hora
     
    * Moneda origen
     
    * moneda destino
     
    * Monto ingresado 
    
    * Resultado


============================================================================================

⭐ Próximas mejoras (Extras del proyecto)

    * Guardar historial en archivo .txt
    
    * Colores ANSI en la consola
    
    * Ejecutable .jar
    
    * Búsqueda por nombre de moneda
     
    * Diagramas UML
     
    * Interfaz gráfica (Swing / JavaFX)

============================================================================================

▶️ Ejecución desde consola (opcional)


javac -cp gson.jar src/com/conversor/*.java

java -cp src:gson.jar com.conversor.Principal

============================================================================================

🤝 Autor


Iván E. S. Matías.

Desarrollador Back End – ONE & Alura LATAM.

GitHub: https://github.com/DepearLegendari