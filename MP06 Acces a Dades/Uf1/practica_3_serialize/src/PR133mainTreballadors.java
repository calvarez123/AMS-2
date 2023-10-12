import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PR133mainTreballadors { 
    public static void main(String[] args) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String fileName = "PR133treballadors.csv";
        String filePath = basePath + fileName;
        boolean flag00 = true;
        Scanner sc = new Scanner(System.in);

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }
        List<String> csv = UtilsCSV.read(filePath);

        //Con esta funcion recibo todos los datos de la columna id (id hacia abajo)
        String[] dadesTitol = UtilsCSV.getColumnData(csv, "Id");
        dadesTitol = Arrays.copyOfRange(dadesTitol, 1, dadesTitol.length);
        System.out.println("Els títols de l'arxiu són: " + Arrays.toString(dadesTitol));
        /*
        //Con esto obtienes el numero de linea de la persona en cuestion
        int numlineaPersona = UtilsCSV.getLineNumber(csv, "Id", "123");
        System.out.println("La fila on està \"Avatar\" és la " + numlineaPersona);
        
        //con esto sacas todo el texto de la linea 
        String strLiniaPersona = csv.get(numlineaPersona);
        System.out.println("El text de la fila \"d'Avatar\" és \"" + strLiniaPersona + "\"");

        //aqui en forma de array
        String[] arrAvatar = UtilsCSV.getLineArray(strLiniaPersona);
        System.out.println("L'array de dades de la fila \"d'Avatar\" és " + Arrays.toString(arrAvatar));

        //y asi haces el cambio de valor
        PARA NUMEROS ---->> UtilsCSV.update(csv, numLiniaAvatar, "any", Integer.toString(nouAny));
        PARA STRINGS ---->> UtilsCSV.update(csv, numlineaPersona, "Nom", "antonio");
        UtilsCSV.write(filePath, csv);
         */
        while (flag00) {
            
            System.out.print("Id del trabajador-->");
            String id_trabajador = sc.next();
            boolean encontrado = false;

            while (!encontrado) {
                for (String fila : dadesTitol) {
                    if (fila.equals(id_trabajador)) {
                        encontrado = true;
                        break;
                    }
                }
            
                if (!encontrado) {
                    System.out.println("El id no existe. Inténtalo de nuevo.");
                    System.out.print("Id del trabajador-->");
                    id_trabajador = sc.next();
                }
            }
            
            System.out.println("Que dato quieres modificar");
            System.out.print("1-Nombre\n2-Apellido\n3-Departamento\n4-Salario\nopcion--->> ");
            String opcion = sc.next();
            int numlineaPersona = UtilsCSV.getLineNumber(csv, "Id", id_trabajador);
            String variableString;
            int variableInt;
            switch (opcion) {
                case "1":
                    System.out.println("Vamos a cambiar el nombre");
                    System.out.print("Nombre-->>");
                    variableString = sc.next();
                    UtilsCSV.update(csv, numlineaPersona, "Nom", variableString);
                    UtilsCSV.write(filePath, csv);
                    System.out.println("cambio realizado con exito");
                    break;
                case "2":
                    System.out.println("Vamos a cambiar el Apellido");
                    System.out.print("Apellido-->>");
                    variableString = sc.next();
                    UtilsCSV.update(csv, numlineaPersona, "Cognom", variableString);
                    UtilsCSV.write(filePath, csv);
                    System.out.println("cambio realizado con exito");
                    break;
                case "3":
                    System.out.println("Vamos a cambiar el Departamento");
                    System.out.print("Departamento-->>");
                    variableInt = sc.nextInt();
                    UtilsCSV.update(csv, numlineaPersona, "Departament", Integer.toString(variableInt));
                    UtilsCSV.write(filePath, csv);
                    System.out.println("cambio realizado con exito");
                    break;
                case "4":
                    System.out.println("Vamos a cambiar el Salario");
                    System.out.print("Salario-->>");
                    variableInt = sc.nextInt();
                    UtilsCSV.update(csv, numlineaPersona, "Salari", Integer.toString(variableInt));
                    UtilsCSV.write(filePath, csv);
                    System.out.println("cambio realizado con exito");
                    
                    break;
            
                default:
                    break;
            }
            


            
            
        }
        
    }
    
}
