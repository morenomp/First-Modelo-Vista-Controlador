package Model;

/*
MODELO ¿QUE ES?

Se encarga de los datos. 
Actualizaciones, consultas, búsquedas, etc. 
*/

public class F1 {
    
//NO tiene un public static void main
    
//A esto se le llama variables de instancia (objeto). 
//Es como el ESQUELETO del código 
    
    //Con "utilizando una variable inmutable", nos referimos a una variable que 
    //sea única y NO se puede cambiar, como el DNI de una persona. En este caso 
    //el nombre del piloto.
    
//-------------------------------------
//Modificadores de acceso:
//-------------------------------------
    
//Con "aplicando conceptos de encapsulamiento", nos referimos al private 
//(utilizando getters y setters)
//
//El encapsulamiento busca de alguna forma controlar el acceso a los datos 
//que conforman un objeto o instancia, de este modo podríamos decir que una 
//clase y por ende sus objetos que hacen uso de modificadores de 
//acceso (especialmente privados) son objetos encapsulados.
    
//solo es accesible aquí | parte dinámica

/*Es decir, si por ejemplo, un atributo es privado solo puede ser accedido por 
lo métodos o constructores de la misma clase.*/
    
//-------------------------------------
//Variable de instancia (v.i)
//-------------------------------------
    private final String piloto; // variable inmutable
    
    private String modeloAcual;
    private int victorias; // las victorias de cada piloto (hasta 2024)
    private String equipo;
    private int yearFabrication; // depende del coche (aunque en este caso todos serán de 2024)
    private double velocidadMaxima; // puede variar dependiendo del coche
    private boolean actividad; //quizas está retirado
    
    private static int contador = 0; //veremos cuantas entidades tenemos creadas
    
//-------------------------------------
//Sobrecarga de constructores:
//-------------------------------------
    
//Con "sobrecarga de constructores", nos referimos a que es creación de varios métodos 
//con el mismo nombre pero con diferente lista de tipos de parámetros
//
//con (public) le decimos que es accesible desde cualquier sitio del código
    
    public F1(String piloto) { 
    
        this.piloto = piloto;
        
        contador++;
    }
    
    public F1(String piloto, String modeloAcual, int victorias, String equipo, int yearFabrication, double velocidadMaxima, boolean actividad) {
        
        this.piloto = piloto;
        
        this.modeloAcual = modeloAcual;
        this.victorias = victorias;
        this.equipo = equipo;
        this.yearFabrication = yearFabrication;
        this.velocidadMaxima = velocidadMaxima;
        this.actividad = actividad;
        
        contador++;
    }

//-------------------------------------
//Métodos Adicionales
//-------------------------------------
    
//PRIMER METODO
    //nos dirá si el piloto tiene más de 15 victorias o no
    public boolean muchasVictorias(){
       
        //SI el número de victorias es mayor a 15, nos dirá que es true. 
        //SI NO nos dirá que es false.
        //finalmente retorna el valor final
        return victorias >= 15;
    }
    
//SEGUNDO METODO
    //nos dirá si el piloto está activo o no, y depende de lo que sea nos dirá
    //en que equipo está actualmente
    public boolean actividadPiloto(){
        
        //NO inicializaremos ninguna variable, ya que llamaremos directamente 
        //a los valor que tenemos arriba
        
        //SI el piloto está activo:
        if (actividad == true) {
            
            System.out.println("[adicional] Piloto: " + piloto);
            System.out.println("            Equipo actual: " + equipo);
            System.out.print("            Actividad: Activo | ");
            
            
        } else { //SI el piloto NO está activo:
            
            System.out.println("[adicional] Piloto: " + piloto);
            System.out.print("            Actividad: No Activo | ");
        }
        
        return actividad;
    }
    
//-------------------------------------
//Variable de clase (v.c)
//-------------------------------------

//con STATIC lo que decimos es que eso SIEMPRE está ahí
//vamos a encapsularlo (getter y setter)
    
//GETTER: El método get devuelve el valor de la variable name / con esto lees los valores
    public String getPiloto() {
        return piloto;
    }

    public String getModeloAcual() {
        return modeloAcual;
    }

    public int getVictorias() {
        return victorias;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getYearFabrication() {
        return yearFabrication;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public boolean isActividad() {
        return actividad;
    }

    public int getContador() {
        return contador;
    }
    
//SETTER: con esto puedes modificar los valores / los que tienen "final" no serán modificados (e incluimos los obligatorios en nuestro caso)
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setYearFabrication(int yearFabrication) {
        this.yearFabrication = yearFabrication;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void setActividad(boolean actividad) {
        this.actividad = actividad;
    }

    public static void setContador(int contador) {
        F1.contador = contador;
    }
//-------------------------------------
/*
    MÁS INFO:
    
    Encapsulada:
    · getters (leer)
    · setters (escribir)
    
    GETTERS son modificadores que pertimen leer el valor introducido.
    
    Todo esto puede servir por ejemplo para que nadie pueda cambiar los valores de
    dentro de una variable/objeto.
    
    Por ejemplo un DNI o el nombre de un alumno.
*/


}
