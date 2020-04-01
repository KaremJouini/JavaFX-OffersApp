package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FormController {

    @FXML
    TextField offreField;
    @FXML
    ComboBox cardTypes;
    @FXML TextField nomField;
    @FXML TextField adresseField;
    @FXML TextField carteField;
    @FXML
    DatePicker dateField;
    @FXML
    PasswordField passField;
    Offre selectedOffre=null;
    public void initData(Offre selectedOffre){
        this.selectedOffre=selectedOffre;
        System.out.println("selected offre in form controller !"+selectedOffre);
        offreField.setText(this.selectedOffre.getTitre());
        ArrayList <String>types= new ArrayList<String>();
        types.add("Visa");
        types.add("Master Card");
        types.add("Payonneer");
        types.add("Citi Reward +");
        types.add("Chase");
        types.add("American Express");
        cardTypes.setItems(FXCollections.observableArrayList(types));
    }


    public void ImprimerButtonHandler(ActionEvent actionEvent) throws Exception {
     if(nomField.getText().equals("")
             ||carteField.getText().equals("")
             ||cardTypes.getSelectionModel().getSelectedItem()==null
             ||passField.getText().equals("")){
         Alert a=new Alert(Alert.AlertType.ERROR);
         a.setTitle("Informations manquantes!");
         a.setHeaderText("Informations manquantes!");
         a.setWidth(800);
         a.setHeight(1000);
         a.setContentText("Erreur ! Vous devez remplir tous les champs pour continuer !");
         a.show();
     }
     else{ // All the data were provided
         Alert a=new Alert(Alert.AlertType.INFORMATION);
         a.setTitle("Status");
         a.setHeaderText("Status");
         a.setWidth(800);
         a.setHeight(1000);
         a.setContentText("Impression en cours ...");
         a.showAndWait();
         returnToSelection(actionEvent);
         };

     }




    public void backButtonHandler(ActionEvent actionEvent)throws Exception {
       returnToSelection(actionEvent);
    }

    public void returnToSelection(ActionEvent actionEvent) throws Exception{
        //Getting a reference to the primary stage

        Stage primaryStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        //Navigation
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "SelectionScene.fxml"
                ));
        //Hiding the stage temporarily to configurate the scene
        primaryStage.hide();
        primaryStage.setScene(new Scene(loader.load(), 1024, 768));
        //Changing the screen
        primaryStage.show();
    }
}
