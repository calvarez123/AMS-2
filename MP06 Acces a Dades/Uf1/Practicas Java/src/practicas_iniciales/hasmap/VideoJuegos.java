package practicas_iniciales;

import java.util.*;


public class VideoJuegos {
    private TreeMap listajuegos = new TreeMap();
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VideoJuegos juegos = new VideoJuegos();
        juegos.listajuegos.put("Devil may cry", "50");
        juegos.listajuegos.put("Resident Evil 4", "70");
        juegos.listajuegos.put("Forza 5", "80");
        juegos.listajuegos.put("League of Legends", "10");
        String opcion= "0";
        while (opcion=="0"){
        System.out.println("----Menu Principal----");
        System.out.println("1-Introducir un Elemento\n2-Modificar Precio\n3-Eliminar un producto\n4-Mostrar Productos ordenados");
        String nombre = "";
        String precio = "";
        opcion = sc.next();
        switch (opcion) {
            case "1":
                System.out.println("vamos Introducir un juego");
                System.out.print("Nombre= ");
                nombre = sc.next();
                System.out.print("precio= ");
                precio = sc.next();
                juegos.introducirElemento(nombre, precio);
                opcion="0";
                break;
            case "2":
                System.out.println("Vamos Modificar un precio");
                System.out.print("Nombre= ");
                nombre = sc.nextLine();
                System.out.print("Nuevo precio= ");
                precio = sc.nextLine();
                juegos.modificarPrecio(nombre, precio);
                opcion="0";
                
                break;
            case "3":
                
                break;
            case "4":

                break;
                
            default:
                break;
        }
        }
    }
    public void introducirElemento(String nuevojuego, String precio){
            if (listajuegos.containsKey(nuevojuego)){
                System.out.println("Error el juego ya existe");
            }else{
                listajuegos.put(nuevojuego, precio);
            }
            System.out.println("enter para continuar");
        }
    public void modificarPrecio (String juego, String precio){
        if (listajuegos.containsKey(juego)){
                System.out.println("Producto Desconocido");
            }else{
                listajuegos.put(juego, precio);
            }
    }


    public void mostrarjuegos(){
       System.out.println(">Agenda amb " + this.listajuegos.size() + " telèfons");
       for(Iterator i=this.listajuegos.keySet().iterator(); i.hasNext();){
           String k=(String)i.next();
           String v=(String)this.listajuegos.get(k);
           System.out.println("  "+k+ " : " +v);       }
        }
}
