package parte_2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RegistoEstudiantes {
    private static final int LONGITUD_NUMERO_REGISTRO = 4;
    private static final int LONGITUD_NOMBRE = 20;
    private static final int LONGITUD_NOTA = 4;

    public static void main(String[] args) {
        try {
            RandomAccessFile archivo = new RandomAccessFile("registroestudiantel.dat", "rw");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Menú:");
                System.out.println("1. Agregar registro");
                System.out.println("2. Buscar registro por número");
                System.out.println("3. Salir");
                System.out.print("Elija una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 1) {
                    int numeroRegistro = 0;
                    boolean entradaValida = false;

                    while (!entradaValida) {
                        System.out.print("Número de registro (4 dígitos): ");
                        try {
                            numeroRegistro = scanner.nextInt();
                            scanner.nextLine(); 
                            if (String.valueOf(numeroRegistro).length() < LONGITUD_NUMERO_REGISTRO) {
                                entradaValida = true;
                            } else {
                                System.out.println("Número de registro debe tener 4 dígitos o menos.");
                            }
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Valor no válido. Ingrese un número entero de 4 dígitos o menos.");
                            scanner.next();
                        }
                    }

                    System.out.print("Nombre (máximo 20 caracteres): ");
                    String nombre = scanner.nextLine();
                    if (nombre.length() > LONGITUD_NOMBRE) {
                        nombre = nombre.substring(0, LONGITUD_NOMBRE);
                    }

                    float nota = 0.0f;
                    boolean entradaValida1 = false;

                    while (!entradaValida1) {
                        System.out.print("Nota: ");
                        try {
                            nota = scanner.nextFloat();
                            scanner.nextLine();
                            entradaValida1 = true;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Valor no válido. Ingrese un valor float válido.");
                            scanner.next();
                        }
                    }

                    
                    archivo.writeInt(numeroRegistro);
                    archivo.writeChars(padRight(nombre, LONGITUD_NOMBRE));
                    archivo.writeFloat(nota);

                    System.out.println("Registro agregado.");

                } else if (opcion == 2) {
                    System.out.print("Ingrese el número de registro a buscar: ");
                    int numeroRegistroBuscado = scanner.nextInt();

                    archivo.seek(0);
                    boolean encontrado = false;

                    while (archivo.getFilePointer() < archivo.length()) {
                        int numeroRegistro = archivo.readInt();
                        String nombre = readFixedString(archivo, LONGITUD_NOMBRE).trim();
                        float nota = archivo.readFloat();

                        if (numeroRegistro == numeroRegistroBuscado) {
                            System.out.println("Número de registro: " + numeroRegistro);
                            System.out.println("Nombre: " + nombre);
                            System.out.println("Nota: " + nota);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Registro no encontrado.");
                    }
                } else if (opcion == 3) {
                    break;
                }
            }

            archivo.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    private static String readFixedString(RandomAccessFile raf, int length) throws IOException {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(raf.readChar());
        }
        return sb.toString();
    }
}