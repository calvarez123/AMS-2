package practicas_iniciales;

import java.util.*;


public class VideoJuegos {
    private TreeMap listajuegos = new TreeMap();
   
    public static void main(String[] args) {
        boolean valido= false;
        Scanner sc = new Scanner(System.in);
        VideoJuegos juegos = new VideoJuegos();
        juegos.listajuegos.put("Devil may cry", 50.0);
        juegos.listajuegos.put("Resident Evil 4", 70.0);
        juegos.listajuegos.put("Forza 5", 80.0);
        juegos.listajuegos.put("League of Legends", 10.0);
        String opcion= "0";
        while (opcion=="0"){
        System.out.println("----Menu Principal----");
        System.out.println("1-Introducir un Elemento\n2-Modificar Precio\n3-Eliminar un producto\n4-Mostrar Productos ordenados");
        System.out.print("Tu opcion ---->");
        String nombre = "";
        double precio = 0.0;
        String sprecio = "";
        opcion = sc.next();
        switch (opcion) {
            case "1":
                sc.nextLine();
                System.out.println("Vamos Introducir un juego");
                
                while (valido==false){
                System.out.print("Nombre= ");
                nombre = sc.nextLine(); 
                while (true) {
                    System.out.print("Introduce el precio: ");
                    sprecio = sc.nextLine();
        
                    if (sprecio.matches("[0-9]+(\\.\\d+)?")) {
                        precio = Double.parseDouble(sprecio);
                        break; 
                    } else {
                        System.out.println("El precio no es un número válido. Inténtalo de nuevo.");
                    }
                }

                if (!nombre.isEmpty()){
                    valido = true;
                }else {
                    System.out.println("No puedes dejarlo en blanco");
                    valido = false;
                }
                };
                juegos.introducirElemento(nombre, precio);
                System.out.println("Presiona Enter para continuar");
                sc.nextLine();
                opcion = "0";
                break;
            case "2":
                sc.nextLine();
                System.out.println("Vamos Modificar un precio");
                while (valido==false){
                System.out.print("Nombre= ");
                nombre = sc.nextLine(); 
                while (true) {
                    System.out.print("Introduce el precio: ");
                    sprecio = sc.nextLine();
        
                    if (sprecio.matches("[0-9]+(\\.\\d+)?")) {
                        precio = Double.parseDouble(sprecio);
                        break; 
                    } else {
                        System.out.println("El precio no es un número válido. Inténtalo de nuevo.");
                    }
                }

                if (!nombre.isEmpty()){
                    valido = true;
                }else {
                    System.out.println("No puedes dejarlo en blanco");
                    valido = false;
                }
                juegos.modificarPrecio(nombre, precio);
                System.out.println("Presiona Enter para continuar");
                sc.nextLine();
                opcion="0";
                break;
            }
            case "3":
                sc.nextLine();
                System.out.println("Vamos Eliminar un juego");
                System.out.print("Nombre= ");
                nombre = sc.nextLine();
                juegos.eliminarProducto(nombre);
                opcion="0";
                
                break;
            case "4":
            sc.nextLine();
                juegos.mostrarjuegos();
                System.out.println("Presiona Enter para continuar");
                sc.nextLine();
                opcion = "0";
                break;
                
            default:
                break;
        }
        }
    }
    public void introducirElemento(String nuevojuego, Double precio){
            if (listajuegos.containsKey(nuevojuego)){
                System.out.println("Error el juego ya existe");
            }else{
                listajuegos.put(nuevojuego, precio);
            }
            
        }
    public void modificarPrecio (String juego, Double precio){
        if (listajuegos.containsKey(juego)){
                System.out.println("Producto Desconocido");
            }else{
                listajuegos.put(juego, precio);
            }
    }

    public void eliminarProducto(String juego) {
    	Scanner sc = new Scanner(System.in);
    	if (listajuegos.containsKey(juego)){
    		System.out.println("Seguro que quieres eliminar el juego "+juego);
    		System.out.print("1-Si\n2-No\n--->");
    		String valido = sc.next();
    		switch (valido) {
				case "1": {
						System.out.println("eliminamos el juego");
						listajuegos.remove(juego);
						break;
			}
				case "2":{
						System.out.println("El juego "+juego+" No a sido eliminado");
						break;
				}

    	            
        }}else{
        	System.out.println("Producto Desconocido");
        }
    }


    public void mostrarjuegos(){
       System.out.println("==== Los " + this.listajuegos.size() + " juegos ordenados ====");
       for(Iterator i=this.listajuegos.keySet().iterator(); i.hasNext();){
           String k=(String)i.next();
           Double v=(Double)this.listajuegos.get(k);
           System.out.println("  "+k+ " : " +v);       }
        }
    
    
    }
