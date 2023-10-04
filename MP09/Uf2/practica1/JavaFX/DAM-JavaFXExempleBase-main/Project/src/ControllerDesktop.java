import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
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
          System.out.println("ControllerDesktop: Error loading data.");
        } else {
          // Cal afegir el try/catch a la crida de ‘showList’
          try {
            showList();
          } catch (Exception e) {
            System.out.println("ControllerDesktop: Error showing list.");
          }
        }
      });
      
      }
  





      // Funció ‘showLoading’, mostrar una càrrega

      public void showLoading() {

        // Esborrar la llista actual
        yPane.getChildren().clear();
        
        // Afegeix un indicador de progrés com a primer element de la llista
        ProgressIndicator progressIndicator = new ProgressIndicator();
        yPane.getChildren().add(progressIndicator);
        }
  


      public void showList() throws Exception {

        String opcioSeleccionada = ChoiceBox.getValue();
    
        // Obtenir una referència a l'ojecte AppData que gestiona les dades
        AppData appData = AppData.getInstance();
    
        // Obtenir les dades de l'opció seleccionada
        JSONArray dades = appData.getData(opcioSeleccionada);
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
    // Funció ‘showList’, modificar com es mostren les dades

// Carregar la plantilla
URL resource = this.getClass().getResource("assets/template_list_item.fxml");

// Esborrar la llista actual
yPane.getChildren().clear();

// Carregar la llista amb les dades
for (int i = 0; i < dades.length(); i++) {
  JSONObject consoleObject = dades.getJSONObject(i);

  if (consoleObject.has("nom")) {
    String nom = consoleObject.getString("nom");
    String imatge = "assets/images/" + consoleObject.getString("imatge");
    FXMLLoader loader = new FXMLLoader(resource);
    Parent itemTemplate = loader.load();
    ControllerListItem itemController = loader.getController();
    itemController.setText(nom);
    itemController.setImage(imatge);

    yPane.getChildren().add(itemTemplate);
  }
}

  }

};

