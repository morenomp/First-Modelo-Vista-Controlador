package MiLibreria;

import Model.F1;
import java.util.Scanner;

//Con MyAPI nos referimos a nuestra propia libreria

public class MyAPI {
    
/**
     * 
     * @param min introducimos el número mínimo
     * @param max introducimos el número máximo
     * @param msg introducimos un mensaje
     * @return retornará el numero del usuario
     */
    
    
    public static int askForIntBetween(int min, int max, String msg) {
        
        Scanner consola = new Scanner(System.in);
        //inicializamos lo que será el numero introducido por el usuario
        int numb;

        do {
            
            System.out.println(msg);
            
            try {
                
                numb = consola.nextInt();
                
                //SI el numero está entre los delimitados
                if (numb >= min && numb <= max) {
                    
                    //nos devolverá el numero (que llamará al caso correspondiente)
                    return numb;
                    
                } else {
                    
                    //SI NO nos devolverá el siguiente mensaje
                    System.out.println("[X] Introduzca un numero entre " + min + " y " + max);
                    
                }
            } catch (Exception e) {
                
                e.printStackTrace(); // para que nos imprima directamente el error
                System.out.println("[catch] Valor incorrecto. Introduzca un numero entre " + min + " y " + max);
                consola.nextLine(); // para romper el bucle
                
            }
        } while (true);
    }

//-------------------------
    
    /**
     * todos los casos siguientes tienen los mismos parámetros
     * @param msg introducimos un mensaje
     * @param error introducimos un mensaje de error
     * @return retornará el valor introducido por el usuario, una vez pasado por los "filtros"
     */
    
    //creamos notString para verificar que el contenido introducido es un string
    //PROBLEMA: Si el usuario pone cualquier cosa incluyendo cosas como numeros, 
    //simbolos o espacios las aceptará
    
    public static String notString(String msg, String error) {
        
        Scanner consola = new Scanner(System.in);
        String piloto;
        
        do {
            
            System.out.println(msg); //llamará al mensaje inicial
            piloto = consola.nextLine();
            
            if (piloto.isEmpty()) { //pero antes verificará
                
                System.out.println(error); //SI NO es igual llamará al mensaje de error
            }          
            
        } while (piloto.isEmpty());
        
        return piloto;
    }
    
    //creamos notInt para verificar que el contenido introducido es un entero
    public static Integer notInt(String msg, String error) {
        
        Scanner consola = new Scanner(System.in);
        int piloto = 0;
        int num = 0;
        boolean exit = false;

        do {
            try {
                System.out.println(msg); //llamará al mensaje inicial
                piloto = consola.nextInt();

                if (piloto >= num) { //SI piloto es mayor o igual a 0, será correcto

                    exit = true;

                } else{

                    System.out.println(error); //SI NO es igual llamará al mensaje de error

                }   
            } catch (Exception e) {
                
                System.out.println("[X] Introduce un numero entero ");
                consola.nextLine();
            }
        } while (!exit);
        
        return piloto;
    }
    
    //creamos notDouble para verificar que el contenido introducido es un numero
    public static Double notDouble(String msg, String error) {
        
        Scanner consola = new Scanner(System.in);
        double piloto = 0.0;
        double num = 0;
        boolean exit = false;

        do {
            try {
                System.out.println(msg); //llamará al mensaje inicial
                piloto = consola.nextDouble();

                if (piloto >= num) { //SI piloto es mayor o igual a 0, será correcto

                    exit = true;

                } else{

                    System.out.println(error); //SI NO es igual llamará al mensaje de error

                }
            } catch (Exception e) {
                
                System.out.println("[X] Introduce un numero correcto ");
                consola.nextLine();
            }
        } while (!exit);
        
        return piloto;
    }
    
    //creamos notBoolean para verificar que el contenido introducido es true o false
    public static Boolean notBoolean(String msg, String error) {
        
        Scanner consola = new Scanner(System.in);
        boolean piloto = false;
        boolean exit = false;

        do {
            
            String userText = consola.nextLine();
            
            if (userText.equalsIgnoreCase("true")) { //SI piloto está activo(true) seguirá el programa
                
                piloto = true;
                exit = true;
                
            } else if (userText.equalsIgnoreCase("false")) { //SI piloto NO está activo(false) seguirá el programa
                
                piloto = false;
                exit = true;
                
            } else{ //SI NO es niguna de la anteriores, es que el usuario puso algo diferente a lo pedido
                    //y el programa dará error
                
                System.out.println(error); //llamará al mensaje de error
                System.out.println(msg);
                //exit = false; //volverá a pedir un parametro, ya que interpretará que el usuario se 
                              //equivocó al escribir
                
            }           
        } while (!exit);
        
        return piloto;
    }
    
//-------------------------
    
    /**
     * todos los casos siguientes tienen los mismos parámetros
     * @param msg introducimos un mensaje
     * @param msg2 introducimos un segundo mensaje
     * @param error introducimos un mensaje de error
     * @return retornará el valor introducido por el usuario
     */
    
    //creamos optionalString para verificar SI quiere seguir rellenando los datos
    public static String optionalString(String msg, String msg2, String error) {
        
        Scanner consola = new Scanner(System.in);
        String dato = "null"; //en caso de no indicar ningun valor, imprimirá ese null 
        boolean exit = false;
        
        do{
            //preguntaremos al usuario SI quiere seguir rellenando los datos:
            System.out.println(msg);

            String continua = consola.nextLine();

            //SI pone que sí (S)
            if (continua.equalsIgnoreCase("S")) {

                System.out.println("[OK] Continua");
                //dato almacenará el valor del usuario, y lo comprobará con notString 
                dato = notString (msg2, error);
                exit = true;
                
            //SI pone que no (N)
            } else if(continua.equalsIgnoreCase("N")){
                
                System.out.println("[OK] Saliste");
                exit = true;
            } 
        } while(!exit);
        
        return dato;
    }
    
    //creamos optionalInt para verificar SI quiere seguir rellenando los datos
    public static Integer optionalInt(String msg, String msg2, String error) {
        
        Scanner consola = new Scanner(System.in);
        int dato = 0;
        boolean exit = false;
        
        do{
            System.out.println(msg);

            String continua = consola.nextLine();

            if (continua.equalsIgnoreCase("S")) {

                System.out.println("[OK] Continua");
                int yearFabrication = askForIntBetween(2021, 2024, "[~] Introduzca un anyo valido entre (2021-2024): ");
                exit = true;
                
            } else if(continua.equalsIgnoreCase("N")){
                
                System.out.println("[OK] Saliste");
                exit = true;
            } 
        } while(!exit);
        
        return dato;
    }
    
    //creamos optionalDouble para verificar SI quiere seguir rellenando los datos
    public static Double optionalDouble(String msg, String msg2, String error) {
        
        Scanner consola = new Scanner(System.in);
        double dato = 0;
        boolean exit = false;
        
        do{
            System.out.println(msg);

            String continua = consola.nextLine();

            if (continua.equalsIgnoreCase("S")) {

                System.out.println("[OK] Continua");
                //dato almacenará el valor del usuario, y lo comprobará con notString 
                dato = notDouble (msg2, error);
                exit = true;
                
            } else if(continua.equalsIgnoreCase("N")){
                
                System.out.println("[OK] Saliste");
                exit = true;
            } 
        } while(!exit);
        
        return dato;
    }
    
    //creamos optionalBoolean para verificar SI quiere seguir rellenando los datos
    public static Boolean optionalBoolean(String msg, String msg2, String error) {
        
        Scanner consola = new Scanner(System.in);
        boolean dato = true; //valor del usuario el cual validaremos abajo
        boolean exit = false;
        
        do{
            System.out.println(msg);

            String continua = consola.nextLine();

            if (continua.equalsIgnoreCase("S")) {

                System.out.println("[OK] Continua");
                System.out.println(msg2);
                dato = notBoolean(msg2, error); //llamaremos a notBoolean para pedir un valor
                exit = true;
                
            } else if(continua.equalsIgnoreCase("N")){
                
                System.out.println("[OK] Saliste");
                exit = true;
                 
            } else {
                
                System.out.println(error);
            }
        } while(!exit);
        
        return dato;
    }
    
//-------------------------
    
    /**
     * 
     * @param piloto llamará al nombre del piloto introducido por el usuario
     * @param opEntidad el usuario al poner un caso (por ejemplo case 1) llamará a "equipo",
     * que ese equipo aquí lo interpretará como " case "equipo" " y por tanto accederá a él
     * @param msg introducimos un mensaje
     */
    
    //creamos modificarEnt para llamar a los casos escogidos por el usuario
    //con "F1 piloto" sabremos que piloto quiere modificar el usuario
    //con "String atributo" 
    public static void modificarEnt(F1 piloto, String opEntidad, String msg) {
        Scanner consola = new Scanner(System.in);

        switch (opEntidad) {
            
            case "equipo":
                System.out.println(msg);
                String nuevoEquipo = consola.nextLine();
                piloto.setEquipo(nuevoEquipo);
                
                System.out.println("[OK] Equipo actualizado");
                break;

            case "anyo":
                System.out.println(msg);
                int nuevoAnyo = askForIntBetween(2021, 2024, "[~] Introduzca un anyo entre (2021-2024): ");
                piloto.setYearFabrication(nuevoAnyo);
                
                System.out.println("[OK] Anyo de fabricacion actualizado");
                break;

            case "velocidad":
                System.out.println(msg);
                double nuevaVelocidad = consola.nextDouble();
                piloto.setVelocidadMaxima(nuevaVelocidad);
                
                System.out.println("[OK] Velocidad maxima actualizada");
                break;

            case "actividad":
                System.out.println(msg);
                boolean nuevaActividad = notBoolean("[~] Introduzca si esta activo o no (true/false)", "[!] Valor incorrecto. Introduzca si esta activo o no con (true/false)");
                piloto.setActividad(nuevaActividad);
                
                System.out.println("[OK] Actividad actualizada");
                break;

            default:
                System.out.println("[X] Valor incorrecto ");
        }
    }
    
}
