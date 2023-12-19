package com.project;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Aquest exemple mostra com fer una 
 * connexió a SQLite amb Java
 * 
 * A la primera crida, crea l'arxiu 
 * de base de dades hi posa dades,
 * després les modifica
 * 
 * A les següent crides ja estan
 * originalment modificades
 * (tot i que les sobreescriu cada vegada)
 */

public class Main {

    public static void main(String[] args) throws SQLException {
        String basePath = System.getProperty("user.dir") + "/data/";
        String filePath = basePath + "database.db";
        ResultSet rs = null;

        // Si no hi ha l'arxiu creat, el crea i li posa dades
        File fDatabase = new File(filePath);
        if (!fDatabase.exists()) { initDatabase(filePath); }

        // Connectar (crea la BBDD si no existeix)
        Connection conn = UtilsSQLite.connect(filePath);

        // Llistar les taules
        ArrayList<String> taules = UtilsSQLite.listTables(conn);
        System.out.println(taules);

        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Selecciona una opción:");
            System.out.println("1-Mostrar una taula");
            System.out.println("2-Mostrar personatges per facció");
            System.out.println("3-Mostrar el millor atacant per facció");
            System.out.println("4-Mostrar el millor defensor per facció");
            System.out.println("5-Sortir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                System.out.println("---------TABLAS-----------");
                System.out.println("1--> Facciones");
                System.out.println("2--> Personatges");
               
                    String valor = scanner.next();
                    String faccion="";

                    switch (valor) {
                        case "1":
                            faccion = "faccio";
                            break;
                        case "2":
                            faccion = "personatge";
                            break;
                     
                    
                        default:
                            break;
                    }
                    rs = UtilsSQLite.querySelect(conn, "SELECT * FROM "+faccion+";");
            ResultSetMetaData rsmd = rs.getMetaData();

          
            System.out.println("----------Información de la tabla "+faccion+"-----------");
            for (int cnt = 1; cnt <= rsmd.getColumnCount(); cnt++) {
                
                String label = rsmd.getColumnLabel(cnt);
                String name = rsmd.getColumnName(cnt);
                int type = rsmd.getColumnType(cnt);

                System.out.println("    Columna " + cnt + ":");
                System.out.println("        Etiqueta: " + label);
                System.out.println("        Nombre: " + name);
                System.out.println("        Tipo: " + type);
            }
            scanner.nextLine();
            System.out.println("Presiona Enter para continuar...");
            
            scanner.nextLine();

                    break;
                case 2:
                
                System.out.println("---------Facciones-----------");
                System.out.println("1--> Caballeros");
                System.out.println("2--> Vikingos");
                System.out.println("3--> Samurais");
                    String valor2 = scanner.next();
                    String faccion2="";

                    switch (valor2) {
                        case "1":
                            faccion2 = "Caballeros";
                            break;
                        case "2":
                            faccion2 = "Vikingos";
                            break;
                        case "3":
                            faccion2 = "Samurais";
                            break;
                    
                        default:
                            break;
                    }
                    
                    
                    rs = UtilsSQLite.querySelect(conn, "SELECT p.id, p.nom, p.atac, p.defensa, f.nom as faccion_nombre " +
                    "FROM Personatge p INNER JOIN Faccio f ON f.id = p.idFaccio " +
                    "WHERE f.id = (SELECT id FROM Faccio WHERE nom = '"+faccion2+"');");

                    System.out.println("Contenido de la tabla:");
                    System.out.printf("%-5s | %-15s | %-10s | %-10s | %-15s%n", "ID", "Nombre", "Ataque", "Defensa", "Facción");
                    System.out.println("-----------------------------------------------------------");

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nombre = rs.getString("nom");
                        double ataque = rs.getDouble("atac");
                        double defensa = rs.getDouble("defensa");
                        String faccionNombre = rs.getString("faccion_nombre");

                        System.out.printf("%-5d | %-15s | %-10.2f | %-10.2f | %-15s%n", id, nombre, ataque, defensa, faccionNombre);
                    }
                    
                    scanner.nextLine();
            System.out.println("Presiona Enter para continuar...");
            
            scanner.nextLine();

                    break;
                case 3:


                break;
                case 4:
                    
                
                    break;
                case 5:
                    System.out.println("Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    

        /*
        // Demanar informació de la taula
        rs = UtilsSQLite.querySelect(conn, "SELECT * FROM warehouses;");
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Informació de la taula:");
        for (int cnt = 1; cnt < rsmd.getColumnCount(); cnt = cnt + 1) { 
            // Les columnes començen a 1, no hi ha columna 0!
            String label = rsmd.getColumnLabel(cnt);
            String name = rsmd.getColumnName(cnt);
            int type = rsmd.getColumnType(cnt);
            System.out.println("    " + label + ", " + name + ", " + type);
        }

        // SELECT a la base de dades
        rs = UtilsSQLite.querySelect(conn, "SELECT * FROM warehouses;");
        System.out.println("Contingut de la taula:");
        while (rs.next()) {
            System.out.println("    " + rs.getInt("id") + ", " + rs.getString("name"));
        }

        // Actualitzar una fila
        UtilsSQLite.queryUpdate(conn, "UPDATE warehouses SET name=\"MediaMarkt\" WHERE id=2;");

        // Esborrar una fila
        UtilsSQLite.queryUpdate(conn, "DELETE FROM warehouses WHERE id=3;");

        // SELECT a la base de dades
        rs = UtilsSQLite.querySelect(conn, "SELECT * FROM warehouses;");
        System.out.println("Contingut de la taula modificada:");
        while (rs.next()) {
            System.out.println("    " + rs.getInt("id") + ", " + rs.getString("name"));
        }
        */

        // Desconnectar
        UtilsSQLite.disconnect(conn);
    }

    static void initDatabase (String filePath) {
        // Connectar (crea la BBDD si no existeix)
        Connection conn = UtilsSQLite.connect(filePath);

        // Esborrar la taula (per si existeix)
        
        UtilsSQLite.queryUpdate(conn, "DROP TABLE IF EXISTS Faccio;");
        UtilsSQLite.queryUpdate(conn, "DROP TABLE IF EXISTS Personatge;");

        // Crear una nova taula
        UtilsSQLite.queryUpdate(conn, "CREATE TABLE Faccio (" +
                                        "id INTEGER PRIMARY KEY," +
                                        "nom VARCHAR(15)," +
                                        "resum VARCHAR(500)" +
                                        ")");

        UtilsSQLite.queryUpdate(conn, "CREATE TABLE Personatge (" +
                    "id INTEGER PRIMARY KEY," +
                    "nom VARCHAR(15)," +
                    "atac REAL," +
                    "defensa REAL," +
                    "idFaccio INTEGER," +
                    "FOREIGN KEY (idFaccio) REFERENCES Faccio(id)" +
                    ")");

        // Afegir elements a una taula
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Faccio (nom, resum) VALUES ('Caballeros', 'Héroes nobles y valientes');");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Faccio (nom, resum) VALUES ('Vikingos', 'Guerreros fuertes y salvajes');");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Faccio (nom, resum) VALUES ('Samurais', 'Maestros del arte de la guerra oriental');");

        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Lancelot', 80.0, 60.0, 1);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Guinevere', 75.0, 65.0, 1);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Arthur', 85.0, 55.0, 1);");

        // Facción: Vikingos
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Ragnar', 85.0, 55.0, 2);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Astrid', 75.0, 65.0, 2);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Erik', 80.0, 60.0, 2);");

        // Facción: Samuráis
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Hanzo', 75.0, 65.0, 3);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Sakura', 80.0, 60.0, 3);");
        UtilsSQLite.queryUpdate(conn, "INSERT INTO Personatge (nom, atac, defensa, idFaccio) VALUES ('Kenji', 85.0, 55.0, 3);");


        // Desconnectar
        UtilsSQLite.disconnect(conn);
    }


    
}