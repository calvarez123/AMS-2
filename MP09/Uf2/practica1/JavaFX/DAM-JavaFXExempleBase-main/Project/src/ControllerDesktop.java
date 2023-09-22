import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControllerDesktop implements Initializable {
    @FXML
    private ChoiceBox<String> ChoiceBox;
    @FXML
    private VBox yPane;
    @FXML
    private AnchorPane info;

    String opcions[] = { "Personatges", "Jocs", "Consoles" };


    @Override
    public void initialize(URL url,ResourceBundle rb){
        //Agrega las opciones al choicebox
        ChoiceBox.getItems().addAll(opcions);
        //selecciona la primera opcion
        ChoiceBox.setValue(opcions[0]);
        //callback se ejecuta cuando el usuario escoge una opcioon
        ChoiceBox.setOnAction((event)-> { loadList();});
        //carga automaticamente los datos de personajes
        loadList();
    }
    public void loadList() {

        // Obtenir l'opció seleccionada
        String opcio = ChoiceBox.getValue();
    
        // Obtenir una referència a AppData que gestiona les dades
        AppData appData = AppData.getInstance();
    
        // Mostrar el missatge de càrrega
        showLoading();
    
        // Demanar les dades
        appData.load(opcio, (result) -> {
          if (result == null) {
              System.out.println("ControllerDesktop: Error loading.");
            } else {
              showList(opcio);
            }
          });
        }
    public void showList(String opcioCarregada) throws Exception {

    // Si s'ha carregat una altra opció, no cal fer res
    // (perquè el callback pot arribar després de que l'usuari hagi canviat d'opció)
    String opcioSeleccionada = ChoiceBox.getValue();
    if (opcioCarregada.compareTo(opcioSeleccionada) != 0) {
      return;
    }

    // Obtenir una referència a l'ojecte AppData que gestiona les dades
    AppData appData = AppData.getInstance();

    // Obtenir les dades de l'opció seleccionada
    JSONArray dades = appData.getData(opcioCarregada);
    // Esborrar la llista actual
    yPane.getChildren().clear();

    // Carregar la llista amb les dades
    for (int i = 0; i < dades.length(); i++) {
      JSONObject consoleObject = dades.getJSONObject(i);
      if (consoleObject.has("nom")) {
        String nom = consoleObject.getString("nom");
        Label label = new Label(nom);
        yPane.getChildren().add(label);
      }
    }
  }

}