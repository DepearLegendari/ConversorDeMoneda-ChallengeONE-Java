🌎💱 Conversor de Monedas — Challenge ONE Java Back End

Proyecto realizado con amor, disciplina y la guía divina de Karen 💜

Este proyecto es un Conversor de Monedas en Java, diseñado como parte del programa
Oracle Next Education (ONE) en colaboración con Alura LATAM.

El sistema permite:

✔ Consultar en tiempo real las tasas de cambio desde la API ExchangeRate
✔ Convertir entre múltiples monedas
✔ Validar entradas del usuario
✔ Mostrar menús interactivos
✔ Procesar JSON con Gson
✔ Estructurar el código con orientación a objetos

====================================================================================================

📌 Tecnologías utilizadas

Java 17+

Gson (Google)

HttpClient

ExchangeRate API

IntelliJ IDEA

POO (Programación Orientada a Objetos)

====================================================================================================

🧩 Arquitectura del proyecto

El proyecto está dividido en clases limpias:

Clase           Función
ApiConsulta	    Se conecta a la API y obtiene el JSON
DatosApi	    Representa el modelo de respuesta JSON
Conversor	    Realiza toda la lógica de conversión
MenuConversor	Interfaz con el usuario (menú dinámico)
Principal	    Punto de entrada del programa

====================================================================================================

🔁 Flujo de Conversión

1️⃣ El usuario selecciona la moneda origen y destino
2️⃣ El sistema válida entradas
3️⃣ Se consulta la API usando HttpClient
4️⃣ La respuesta JSON se transforma en objeto Java con Gson
5️⃣ Se calcula la conversión usando las tasas recibidas
6️⃣ Se muestra el resultado final formateado

====================================================================================================

💹 Monedas disponibles (versión básica)

USD – Dólar estadounidense

MXN – Peso mexicano

ARS – Peso argentino

BRL – Real brasileño

CLP – Peso chileno

COP – Peso colombiano

EUR – Euro

Con soporte para más monedas mediante la API 🌍.

====================================================================================================

✨ EXTRA PLUS — Implementaciones premium

Funcionalidad Extra	Estado
🕒 Historial de conversiones	✔ Planificado
📅 Registro con fecha y hora	✔ Planificado
📁 Guardar historial en archivo	✔ Planificado
🌍 Lista interactiva de monedas (para usuarios que no conocen abreviaturas)	✔ En progreso
🏷️ Formato profesional de resultados	✔ Implementado

====================================================================================================

▶️ Ejecución desde consola (opcional)
javac -cp gson.jar src/com/conversor/*.java
java -cp src:gson.jar com.conversor.Principal

====================================================================================================

🤝 Autor

Iván E. S. Matías.
Desarrollador Back End – ONE & Alura LATAM
GitHub: https://github.com/DepearLegendari