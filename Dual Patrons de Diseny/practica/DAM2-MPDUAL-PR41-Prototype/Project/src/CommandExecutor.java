
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecutor {

    public static void main(String[] args) {
        // Directorio de trabajo
        String workingDirectory = "~/dev/rpi-rgb-led-matrix/examples-api-use/demo";

        // Comando a ejecutar (personalizado según tus necesidades)
        String command = "./demo -D0 --led-cols=64 --led-rows=64 --led-slowdown-gpio=4 --led-no-hardware-pulse";

        try {
            // Crear el proceso builder y configurar el directorio de trabajo
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
            processBuilder.directory(new File(workingDirectory));

            // Redirigir la salida del proceso a la consola
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Leer la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Imprimir la salida del comando
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Comando ejecutado con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
