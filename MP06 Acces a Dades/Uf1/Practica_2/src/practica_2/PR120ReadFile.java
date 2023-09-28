package practica_2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PR120ReadFile {
    public static void main(String[] args) {
        String filePath = "/home/super/AMS-2/MP06 Acces a Dades/Uf1/Practicas Java/src/practica_2/PR120ReadFile.java";
        System.out.println("======== A CONTINUACION EL SIGUIENTE CODIGO===========");

        //Este codigo lee el codigo del archivo dado anteriormente
        try {
            List<String> linies = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
            for (int cnt = 0; cnt < linies.size(); cnt = cnt + 1) {
                System.out.println(cnt+"  "+linies.get(cnt));
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
    
}
