
import java.io.IOException;
import java.util.*;

public class Main {

  static Scanner in = new Scanner(System.in); // System.in és global


  // Main
  public static void main(String[] args) throws InterruptedException, IOException {
    boolean running = true;
    while (running) {
      String menu = "Escull una opció:";
      menu = menu + "\n 0) PR430Main";
      menu = menu + "\n 1) PR431Main";
      // Adapta aquí les altres classes de l’exercici (PR432Main…)
      menu = menu + "\n 100) Sortir";
      System.out.println(menu);


      int opcio = Integer.valueOf(llegirLinia("Opció:"));
      try {
        switch (opcio) {
          case 0: PR430Main.main(args); break;
          case 1: PR431Main.main(args); break;
          // Adapta aquí les altres classes de l’exercici (PR432Main…)
          case 100: running = false; break;
          default: break;
        }
      } catch (Exception e) {
          System.out.println(e);
      }
    }
    in.close();
  }


  static public String llegirLinia (String text) {
    System.out.print(text);
    return in.nextLine();
  }
}
