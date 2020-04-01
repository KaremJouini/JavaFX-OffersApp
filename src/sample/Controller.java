package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.System;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller implements Initializable {

@FXML
Text
titleText;
@FXML HBox selectionHBox;
@FXML VBox selectionVBox;
@FXML
TableView tableOffres;
@FXML VBox formHBox;
@FXML
GridPane mainGrid;
@FXML
CheckBox pretAPorterCheck;
@FXML
CheckBox  restaurantsCheck;
@FXML
CheckBox    electroniqueCheck;
@FXML
Button confirmerBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        System.out.println("Intializing");

        //Setting initial table
        TableColumn titreCol= new TableColumn("Titre");
        titreCol.setCellValueFactory(
                new PropertyValueFactory<Offre, String>("titre"));

        TableColumn prixCol=new TableColumn("Prix");
        prixCol.setCellValueFactory(
                new PropertyValueFactory<Offre, String>("prix"));
        TableColumn dispCol=new TableColumn("Disponibilité");
        dispCol.setCellValueFactory(
                new PropertyValueFactory<Offre, String>("disponible"));
        //Adding columns to the table
        tableOffres.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableOffres.getColumns().addAll(titreCol,prixCol,dispCol);
        OffresData offresData=new OffresData();
        offresData.loadData();
        System.out.println(offresData.getOffres());

        tableOffres.setItems(FXCollections.observableArrayList(offresData.getOffres()));


    }

    // For handling "filtrer" Button Events
    public void filtrerButtonHandler(ActionEvent actionEvent) {
        OffresData offresData = new OffresData();
        offresData.loadData();
        if(pretAPorterCheck.isSelected()||electroniqueCheck.isSelected()||restaurantsCheck.isSelected()) {
            ArrayList<Offre> listFiltred = new ArrayList<>();
            if (pretAPorterCheck.isSelected()) {
                listFiltred.addAll(offresData.getOffres().stream().filter(o -> ((Offre) o).getCategorie().equals("Prêt-à-porter") == true).collect(Collectors.toCollection(ArrayList::new)));
                tableOffres.setItems(FXCollections.observableArrayList(listFiltred));
            }
            if (restaurantsCheck.isSelected()) {
                listFiltred.addAll(offresData.getOffres().stream().filter(o -> ((Offre) o).getCategorie().equals("Restaurants") == true).collect(Collectors.toCollection(ArrayList::new)));
                tableOffres.setItems(FXCollections.observableArrayList(listFiltred));
            }
            if (electroniqueCheck.isSelected()) {
                listFiltred.addAll(offresData.getOffres().stream().filter(o -> ((Offre) o).getCategorie().equals("Electronique") == true).collect(Collectors.toCollection(ArrayList::new)));
                tableOffres.setItems(FXCollections.observableArrayList(listFiltred));
            }
        }else{ // Non selected criteria
                tableOffres.setItems(FXCollections.observableArrayList(offresData.getOffres()));
            }
        }

    public void confirmerButtonHandler(ActionEvent actionEvent) throws Exception {

        //Navigating by switching the scene
        //Loading the scene

        //If an offre is selected in the TableView
        if(tableOffres.getSelectionModel().getSelectedItem()!=null){
            Offre selectedOffre=new Offre();
            selectedOffre=(Offre)tableOffres.getSelectionModel().getSelectedItem();
            System.out.println(selectedOffre);
            if(selectedOffre.getDisponible().equals("non")){
                showAlert("L'offre doit etre disponible !");
            }else {
                //Now we navigate to the form page

                //Getting a reference to the primary stage

                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                System.out.println(primaryStage);
                //Navigating by switching the scene
                //Loading the scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "FormScene.fxml"
                        ));
                //Hiding the stage temporarily to configurate the scene
                primaryStage.hide();
                primaryStage.setScene(new Scene(loader.load(), 800, 600));
                FormController formController = loader.<FormController>getController();
                System.out.println(formController);
                formController.initData(selectedOffre);
                // Here where the scene changes and the form screen shows
                primaryStage.show();
            }
        }else{
            showAlert("Offre non sélectionnée");
        }
    }

    public void showAlert(String content) {
        Alert a=new Alert(Alert.AlertType.ERROR);
        a.setTitle("Erreur");
        a.setHeaderText("Erreur");
        a.setWidth(1000);
        a.setHeight(700);
        a.setContentText(content);
        a.show();
    }
}

