package Vista;

//llamaremos a la libreria y el controlador, y con * le diremos que llame todas las que hayan.
//así no tenemos que llamar una por una

import static Controlador.Controlador.*;
import static MiLibreria.MyAPI.*; 

/*
VISTA ¿QUE ES?

Es la representación visual de los datos, todo lo que tenga que ver con 
la interfaz gráfica. Ni el modelo ni el controlador se preocupan 
de cómo se verán los datos, ya que se de eso se encarga únicamente la vista.
*/

public class Inicio {
    public static void main(String[] args) {
          
        System.out.println("-| Bienvenido al programa! |-");
        
        boolean exit = false;
        initDefault(); // Inicializará valores predeterminados
        
        do {

            mostrarMenu();
            int opcionMenu = askForIntBetween(1, 6, "[~] Elija una opcion del menu (1-6): ");
            //variable para llamar al case correspondiente del switch

            switch (opcionMenu) {
                case 1:
                    System.out.println("[OK] case 1 Funciona");
                    crearEntidad();
                    break;

                case 2:
                    System.out.println("[OK] case 2 Funciona");
                    buscarEntidad();
                    break;

                case 3:
                    System.out.println("[OK] case 3 Funciona");
                    modificarEntidad();
                    break;

                case 4:
                    System.out.println("[OK] case 4 Funciona");
                    borrarEntidad();
                    break;

                case 5:
                    System.out.println("[OK] case 5 Funciona");
                    buscarEntidadDefault();
                    break;

                case 6:
                    System.out.println("- Has salido del programa");
                    exit = true;
                    break;

                default:
                    System.out.println("[X] Opcion incorrecta, introduzca un numero de la tabla");
            }
        } while (!exit);
    }
    
//------------------------------------------------
// menú texto
    public static void mostrarMenu(){
        System.out.println("- -------------------------------- -");
        System.out.println("-             Menu F1              -");
        System.out.println("- -------------------------------- -");
        
        System.out.println("-      [1] Crear entidad           -");
        System.out.println("-     [2] Buscar entidades         -");
        System.out.println("-    [3] Modificar entidades       -");
        System.out.println("-      [4] Borrar entidad          -");
        System.out.println("-  [5] Buscar entidad predefinida  -");
        
        System.out.println("-            [6] Exit              -");
        
        System.out.println("- -------------------------------- -");
    }
}
