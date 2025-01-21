package Controlador;

import static MiLibreria.MyAPI.*;
import Model.F1;
import java.util.ArrayList;
import java.util.Scanner;

/*
CONTROLADOR ¿QUE ES?

Se encarga de controlar, recibe las órdenes del usuario y se encarga de 
solicitar los datos al modelo y de comunicárselos a la vista.
*/

//IMPORTANTE:
//La parte de "El usuario debe definir el tamaño del array al intentar crear una
//entidad por primera vez" NO se hace

public class Controlador {
    
//------------------------------------------------
// case 1
    public static void crearEntidad() {

//OBLIGATORIOS:
        //PILOTO
        String piloto = notString("[~] Introduce el nombre del piloto: ", "[X] Error. Inserta otro parametro");
        
        // SI el valor ESTÁ repetido:
        //con foreach recorreremos el arrayList
        for(F1 f1 : pilotoTodo){
            
            //filtraremos el nombre del piloto para ver si está repetido
            if (f1.getPiloto().equalsIgnoreCase(piloto)) {
                
                System.out.println("[X] Piloto " + piloto + " ya existe ");
                
                //pondremos return para que finalice la creación si vemos que realmente está repetido
                return;
            }
        }
        
        //MODELO ACTUAL
        String modeloAcual = notString("[~] Introduce su modelo de coche: ", "[X] Error. Inserta otro parametro");

        //VICTORIAS
        int victorias = notInt("[~] Introduce cuantas victorias tiene (num postivo): ", "[X] Error. Inserta otro parametro");

//OPCIONALES:
        //EQUIPO
        String equipo = optionalString("[~] Quieres introducir un equipo? (S/N)", "[~] Introduce el equipo del piloto: ", "[X] Error. Inserta otro parametro");

        //AÑO DE FABRICACIÓN
        int yearFabrication = optionalInt("[~] Quieres introducir el anyo de fabricacion? (S/N)", "[~] Introduce el anyo de fabricacion del coche del piloto: ", "[X] Error. Inserta otro parametro");

        //VELOCIDAD MAX.
        double velocidadMaxima = optionalDouble("[~] Quieres introducir la velocidad maxima del coche del piloto? (S/N)", "[~] Introduce la velocidad maxima del coche del piloto: ", "[X] Error. Inserta otro parametro");

        //EN ACTIVO O NO
        boolean actividad = optionalBoolean("[~] Quieres introducir si esta activo o no el piloto? (S/N)", "[~] Introduce si el piloto esta activo actualmente (true/false): ", "[X] Error. Inserta otro parametro");

//creamos la entidad
        F1 F1_entidad = new F1(piloto, modeloAcual, victorias, equipo, yearFabrication, velocidadMaxima, actividad); 

        pilotoTodo.add(F1_entidad);
        //System.out.println("Entidades existentes: " + contador);

        System.out.println("--------------------------");
        System.out.println("[OK] Entidad creada");
        System.out.println("--------------------------");

//mostraremos los datos
        System.out.println("Piloto: " + F1_entidad.getPiloto());
        System.out.println("Modelo de coche actual: " + F1_entidad.getModeloAcual());
        System.out.println("Victorias: " + F1_entidad.getVictorias());
        System.out.println("Ultimo equipo: " + F1_entidad.getEquipo());
        System.out.println("Fecha de fabricacion del coche: " + F1_entidad.getYearFabrication());
        System.out.println("Velocidad Max. del coche: " + F1_entidad.getVelocidadMaxima());
        System.out.println("Actividad: " + F1_entidad.isActividad());
        
        //Uno de los metodos adicionales:
        System.out.println("[adicional] " + F1_entidad.getPiloto() + " tiene mas de 15 victorias? " + F1_entidad.muchasVictorias());
        
        //Segundo de los metodos adicionales:
        System.out.println(F1_entidad.actividadPiloto());
    }
    
    
    
    
//crearemos las dos arraylist que utilizaremos
//la PRIMERA: será la que usaremos para las entidades que creará el usuario
    private static ArrayList<F1> pilotoTodo = new ArrayList<>();
    
//la SEGUNDA: será la que usaremos para las entidades ya predefinidas
    private static ArrayList<F1> pilotoTodoDefault = new ArrayList<>();
    
    
    
    
//------------------------------------------------
// case 2
    public static void buscarEntidad() {
        //en este caso usaremos la propiedad get (ya explicado en el modelo)
        
        //antes de nada, comprobaremos si la array tiene algún valor/piloto dentro
        //en caso de que no tenga, nos dirá que no hay y saldrá automaticamente de buscarEntidad
        if (pilotoTodo.isEmpty()) {
            
            System.out.println("[X] No hay pilotos");
            return;
        }

        //mostramos el tamaño de la lista para que el usuario sepa las posiciones que hay en ese momento
        //para ello usaremos "size", lo cual nos devuelve el tamaño maximo de la arraylist actual
        System.out.println("[~] Hay " + pilotoTodo.size() + " pilotos en la lista");

        //pedimos la posición del piloto que quiere
        //para ello inicializamos la variable "posPiloto"
        int posPiloto = askForIntBetween(0, pilotoTodo.size() - 1, "[~] Introduce la posicion del piloto (entre 0 y " + (pilotoTodo.size() - 1) + "): ");

        //llamamos a esa posicion desde la arraylist
        F1 f1 = pilotoTodo.get(posPiloto);

        //mostramos la información del piloto
        System.out.println("--------------------------");
        System.out.println("[OK] Piloto " + f1.getPiloto() + " encontrado:");
        System.out.println("--------------------------");

        System.out.println("Piloto: " + f1.getPiloto());
        System.out.println("Modelo de coche actual: " + f1.getModeloAcual());
        System.out.println("Victorias: " + f1.getVictorias());
        System.out.println("Equipo: " + f1.getEquipo());
        System.out.println("Anyo de fabricacion: " + f1.getYearFabrication());
        System.out.println("Velocidad maxima: " + f1.getVelocidadMaxima());
        System.out.println("Activo: " + f1.isActividad());
    }

//------------------------------------------------
// case 3
    public static void modificarEntidad() {
        //en este caso usaremos la propiedad set (ya explicado en el modelo)
        
        //antes de nada, comprobaremos si la array tiene algún valor/piloto dentro
        //en caso de que no tenga, nos dirá que no hay y saldrá automaticamente de modificarEntidad
        if (pilotoTodo.isEmpty()) {
            
            System.out.println("[X] No hay pilotos");
            return;
        }

        //mostramos el tamaño de la lista para que el usuario sepa las posiciones que hay en ese momento
        //para ello usaremos "size", lo cual nos devuelve el tamaño maximo de la arraylist actual
        System.out.println("[~] Hay " + pilotoTodo.size() + " pilotos en la lista");

        //pedimos la posición del piloto que quiere
        //para ello inicializamos la variable "posPiloto"
        int posPiloto = askForIntBetween(0, pilotoTodo.size() - 1, "[~] Introduce la posicion del piloto a modificar (entre 0 y " + (pilotoTodo.size() - 1) + "): ");

        //llamamos a esa posicion desde la arraylist
        F1 f1 = pilotoTodo.get(posPiloto);
        
        System.out.println("[!] Solo podras modificar los parametros opcionales ");

        boolean exit = false;

        do {
            System.out.println("- -------------------------------- -");
            System.out.println("[OK] Piloto " + f1.getPiloto() + " encontrado");
            System.out.println("- -------------------------------- -");
                
            //mostraremos las opciones para modificar
                
            System.out.println("-            [1] Equipo            -");
            System.out.println("-     [2] Anyo de fabricacion      -");
            System.out.println("-       [3] Velocidad maxima       -");
            System.out.println("-         [4] Actividad            -");
            System.out.println("-            [5] Salir             -");
            System.out.println("- -------------------------------- -");

            // Pedimos la opción del menú
            int opcionMenu = askForIntBetween(1, 5, "[~] Elija una opcion del menu (1-5): ");

            switch (opcionMenu) {
                
                case 1:
                    //entraremos en "modificarEnt" para verificar que todo sea correcto antes de realizar la modificación
                    modificarEnt(f1, "equipo", "[~] Modifica el equipo de " + f1.getPiloto() + ": ");
                    break;

                case 2:
                    modificarEnt(f1, "anyo", "[~] Modifica el anyo de fabricacion del coche de " + f1.getPiloto() + ": ");
                    break;

                case 3:
                    modificarEnt(f1, "velocidad", "[~] Modifica la velocidad maxima de " + f1.getPiloto() + ": ");
                    break;

                case 4:
                    modificarEnt(f1, "actividad", "[~] Modifica si " + f1.getPiloto() + " esta activo o no (true/false): ");
                    break;

                case 5:
                    System.out.println("- Has salido del programa");
                    exit = true;
                    break;

                default:
                    System.out.println("[X] Opcion incorrecta, introduce un numero de la tabla");
            }
        } while (!exit);

        System.out.println("- -------------------------------- -");
        System.out.println("[OK] Piloto modificado");
    }

//------------------------------------------------
// case 4
    public static void borrarEntidad() {
        //en este caso usaremos la propiedad remove
        
        //antes de nada, comprobaremos si la array tiene algún valor/piloto dentro
        //en caso de que no tenga, nos dirá que no hay y saldrá automaticamente de borrarEntidad
        if (pilotoTodo.isEmpty()) {
            
            System.out.println("[X] No hay pilotos");
            return;
        }

        //mostramos el tamaño de la lista para que el usuario sepa las posiciones que hay en ese momento
        //para ello usaremos "size", lo cual nos devuelve el tamaño maximo de la arraylist actual
        System.out.println("[~] Hay " + pilotoTodo.size() + " pilotos en la lista");

        //pedimos la posición del piloto que quiere
        //para ello inicializamos la variable "posPiloto"
        int posPiloto = askForIntBetween(0, pilotoTodo.size() - 1, "[~] Introduce la posicion del piloto (entre 0 y " + (pilotoTodo.size() - 1) + "): ");

        //llamamos a esa posicion desde la arraylist y la eliminamos
        F1 f1 = pilotoTodo.remove(posPiloto);
        
        //PREGUNTA: si yo llamo a pedro (por ejemplo) despues de eliminarlo, no 
        //deberia de dar error tras decirle que me ponga el nombre del piloto?
        //ya que despues de todo, ese piloto en esa posicion ya no existe, por ende no
        //tiene una direccion a la que acceder y sacar el nombre.
        //aun así funciona
        System.out.println("- -------------------------------- -");
        System.out.println("[OK] Piloto " + f1.getPiloto() + " eliminado");
    }
    
//------------------------------------------------
// case 5
    
    //en este caso que añadí para hacerlo algo más complejo e interesante el código,
    //llamaremos al piloto a través del nombre y no de la posición como podría hacer
    //al igual que en "buscarEntidad"
    
    public static void buscarEntidadDefault() {
        //en esta opcional hemos creado un buscador de entidades/pilotos ya predefinidas en la arrayList
        
        Scanner consola = new Scanner(System.in);
        System.out.println("[~] En esta opcional hemos creado un buscador de entidades/pilotos ya predefinidas en la arrayList");
        System.out.println("[~] Introduce el nombre de un piloto: ");
        //System.out.println("[~] Quieres ver la lista de nombres antes? (S/N)");

        String namePiloto = consola.nextLine();
        boolean validation = false;

        //recorremos todos los elementos de la arraylist "pilotoTodoDefault". 
        //Hablamos de que entrará en "F1", y nos mirará si el piloto que queremos está,
        //ese piloto que queremos, es "f1". 
        for (F1 f1 : pilotoTodoDefault) {

            //llamaremos el nombre del piloto de la lista, y lo compararemos con el 
            //nombre introducido por el usuario 
            if (f1.getPiloto().equalsIgnoreCase(namePiloto)) {

                System.out.println("--------------------------");
                System.out.println("[OK] " + namePiloto + " encontrado:");
                System.out.println("--------------------------");

                System.out.println("Piloto: " + f1.getPiloto());
                System.out.println("Modelo de coche actual: " + f1.getModeloAcual());
                System.out.println("Victorias: " + f1.getVictorias());
                System.out.println("Equipo: " + f1.getEquipo());
                System.out.println("Anyo de fabricacion: " + f1.getYearFabrication());
                System.out.println("Velocidad maxima: " + f1.getVelocidadMaxima());
                System.out.println("Activo: " + f1.isActividad());

                //acabará la busqueda y nos devolverá al menú
                validation = true;
                break;
                
            } 
        }
        
        // Si no se encontró el piloto después del bucle
        if (!validation) {
            
            System.out.println("[X] Piloto no encontrado");
            
        }
    }
//------------------------------------------------
// case 5 parte "add"
    
    public static void initDefault(){
        //Le daremos todos los adatos a todas las entidades, en función del orden del constructor
        
//activos
        pilotoTodoDefault.add(new F1("Max Verstappen", "Red Bull RB19", 63, "Red Bull", 2024, 372.5, true));
        pilotoTodoDefault.add(new F1("Sergio Perez", "Red Bull RB19", 6, "Red Bull", 2024, 372.5, true));
        
        pilotoTodoDefault.add(new F1("Lewis Hamilton", "Mercedes W15", 105, "Mercedes", 2024, 372.5, true));
        pilotoTodoDefault.add(new F1("George Russell", "Mercedes W15", 3, "Mercedes", 2024, 372.5, true));
        
        pilotoTodoDefault.add(new F1("Alex Albon", "Williams FW45", 0, "Williams", 2024, 372.5, true));
        pilotoTodoDefault.add(new F1("Franco Colapinto", "No ha competido en F1", 0, "No ha competido", 0, 0.0, false));
        
        pilotoTodoDefault.add(new F1("Lando Norris", "McLaren MCL38", 4, "McLaren", 2024, 372.5, true));
        pilotoTodoDefault.add(new F1("Oscar Piastri", "McLaren MCL38", 2, "McLaren", 2024, 372.5, true));
        
        pilotoTodoDefault.add(new F1("Kevin Magnussen", "Haas VF-23", 0, "Haas", 2024, 372.5, true));
        pilotoTodoDefault.add(new F1("Nico Hulkenberg", "Haas VF-23", 0, "Haas", 2024, 372.5, true));
        
        pilotoTodoDefault.add(new F1("Charles Leclerc", "Ferrari SF-24", 8, "Ferrari", 2024, 372.5, true));
        pilotoTodoDefault.add(new F1("Carlos Sainz", "Ferrari SF-24", 4, "Ferrari", 2024, 372.5, true));
        
        pilotoTodoDefault.add(new F1("Lance Stroll", "Aston Martin AMR24", 0, "Aston Martin", 2024, 372.5, true));
        pilotoTodoDefault.add(new F1("Fernando Alonso", "Aston Martin AMR24", 32, "Aston Martin", 2024, 372.5, true));
        
        pilotoTodoDefault.add(new F1("Liam Lawson", "No ha competido en F1", 0, "No ha competido", 0, 0.0, false));
        pilotoTodoDefault.add(new F1("Yuki Tsunoda", "AlphaTauri AT05", 0, "AlphaTauri", 2024, 372.5, true));
        
        pilotoTodoDefault.add(new F1("Esteban Ocon", "Alpine A524", 0, "Alpine", 2024, 372.5, true));
        pilotoTodoDefault.add(new F1("Pierre Gasly", "Alpine A524", 0, "Alpine", 2024, 372.5, true));
        
        pilotoTodoDefault.add(new F1("Valtteri Bottas", "Alfa Romeo C43", 10, "Alfa Romeo", 2024, 372.5, true));
        pilotoTodoDefault.add(new F1("Guanyu Zhou", "Alfa Romeo C43", 0, "Alfa Romeo", 2024, 372.5, true));
        
//NO activos
        pilotoTodoDefault.add(new F1("Daniel Ricciardo", "AlphaTauri AT05", 8, "AlphaTauri", 2024, 372.5, false));
        pilotoTodoDefault.add(new F1("Logan Sargeant", "Williams FW45", 0, "Williams", 2024, 372.5, false));
        pilotoTodoDefault.add(new F1("Nyck de Vries", "AlphaTauri AT05", 0, "AlphaTauri", 2024, 372.5, false));
        
        pilotoTodoDefault.add(new F1("Nicholas Latifi", "Williams FW44", 0, "Williams", 2022, 372.5, false));
        pilotoTodoDefault.add(new F1("Mick Schumacher", "Haas VF-22", 0, "Haas", 2022, 372.5, false));
        pilotoTodoDefault.add(new F1("Sebastian Vettel", "Aston Martin AMR23", 53, "Aston Martin", 2022, 372.5, false));
       
        pilotoTodoDefault.add(new F1("Kimi Raikkonen", "Alfa Romeo C41", 21, "Alfa Romeo", 2021, 372.5, false));
        pilotoTodoDefault.add(new F1("Antonio Giovinazzi", "Alfa Romeo C41", 0, "Alfa Romeo", 2021, 372.5, false));
        pilotoTodoDefault.add(new F1("Nikita Mazepin", "Haas VF-21", 0, "Haas", 2021, 372.5, false));

    }
}
