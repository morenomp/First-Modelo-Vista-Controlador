# 📌 **Resumen de la Práctica**
Esta práctica consiste en la gestión de vehículos de Fórmula 1 (entre 2021-2024) mediante el uso de ArrayLists para almacenar datos como:

    El [nombre] del piloto.
    Su [modelo actual] de coche.
    El número de [victorias] totales.
    El último [equipo] en el que estuvo.
    El [año de fabricación] del último coche que tuvo.
    La [velocidad máxima] que alcanza el último coche que tuvo.
    Y finalmente si está en [activo] o no.

Lo que podremos hacer con la aplicación será:

    Crear entidad
    Buscar entidad
    Modificar la entidad
    Borrar entidad
    Buscar una entidad predefinida

Esta última funcionalidad consta de otra ArrayList con datos ya implementados. Con ella buscaremos pilotos y todos sus datos.

# **Modelo Vista Controlador**
El programa sigue una estructura basada en el Modelo Vista Controlador (MVC) para organizar el código de una manera eficiente y mucho más organizada. ¿Pero que son cada uno de ellos?

🔴## **MODELO**

    · Representa los datos y la lógica .
    · Contiene las clases que manejan la información y sus relaciones.
    · Por ejemplo: En esta práctica, sería la clase F1, que almacena información sobre pilotos y coches.
    
🔵## **VISTA**

    · Se encarga de la interfaz de usuario y la presentación de la información.
    · Recibe los datos del modelo y los muestra de manera adecuada.
    · Por ejemplo: En esta práctica, la consola actúa como la vista, mostrando mensajes y solicitando datos al usuario.
    
🟡## **CONTROLADOR**

    · Actúa como un intermediario entre la Vista y el Modelo.
    · Recibe las entradas del usuario, las procesa y actualiza el Modelo.
    · Por ejemplo: En esta práctica, Controlador gestiona la creación, búsqueda, modificación y eliminación de vehículos y pilotos.
