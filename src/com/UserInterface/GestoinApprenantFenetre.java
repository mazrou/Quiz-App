package com.UserInterface;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.beans.property.SimpleStringProperty;
import java.util.ArrayList;
import java.util.List;

import com.Noyau.Apprenant;
import com.Noyau.Formateur;
import com.Noyau.Formation;

import javafx.scene.control.TableCell;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.collections.ObservableList;

public class GestoinApprenantFenetre extends Stage{
	
	
public GestoinApprenantFenetre() {
	
		this.setTitle("Gestion des Apprenant"); 
		this.centerOnScreen();
		this.setResizable(false);
		this.setScene(new Scene(CreerlayoutAjouter(),900,500));		
		}

public GridPane CreerlayoutAjouter() {
	
	GridPane grid = new GridPane();
	
	grid.setPadding(new Insets(10,10,40,10));
	grid.setVgap(10);
	grid.setHgap(10);
	
	//grid.setGridLinesVisible(true);
	
    /*=====================================================================================================*/
	final TextField nom = new TextField();
	Label nomLabel =new Label("Nom: ");
	nom.setPromptText("Nom de l'apprenant");
	nom.setPrefColumnCount(20);
	nom.getText();
	GridPane.setConstraints(nom,1,0);
	GridPane.setConstraints(nomLabel, 0, 0);
	grid.getChildren().addAll(nom,nomLabel);
	
	final TextField prenom = new TextField();
	Label prenomLabel =new Label("Prenom: ");
	prenom.setPromptText("Prenom de l'apprenant");
 	GridPane.setConstraints(prenom, 1,1);
 	GridPane.setConstraints(prenomLabel, 0,1);
	grid.getChildren().addAll(prenom,prenomLabel);

	final TextField datedenaissance = new TextField();
	Label datedenaissanceLabel =new Label("date de naissance: ");
	datedenaissance.setPrefColumnCount(25);
	datedenaissance.setPromptText("La date de naissance de l'apprenant(jj/mm/aaaa)");
	GridPane.setConstraints(datedenaissance, 1,2);
	GridPane.setConstraints(datedenaissanceLabel, 0, 2);
	grid.getChildren().addAll(datedenaissance,datedenaissanceLabel);
	
	final TextField adresse = new TextField();
	Label adresseLabel =new Label("Adresse: ");
	adresse.setPromptText("L'adresse de l'apprenant");
	GridPane.setConstraints(adresse,1,3);
	GridPane.setConstraints(adresseLabel, 0,3);
	grid.getChildren().addAll(adresse,adresseLabel);
	
	Button ajouter = new Button("Ajouter");
	ajouter.setPrefSize(150,30);
	grid.setConstraints(ajouter,3,0);
	grid.getChildren().add(ajouter);

	Label CreerCompteLabel = new Label("NB :Le mot de passe et le nom d'utilisateur sont g�n�rer automatiquement ");
	CreerCompteLabel.setTextFill(Color.RED);
	grid.setConstraints(CreerCompteLabel,0,5);
	grid.setColumnSpan(CreerCompteLabel, 3);
	grid.getChildren().add(CreerCompteLabel);


	Button modifier = new Button();
	modifier.setText("Modifier");
	modifier.setPrefSize(200, 30);
	modifier.translateXProperty().set(680);
	modifier.translateYProperty().set(200);
	grid.getChildren().add(modifier);
	
	Button supprimer = new Button();
	supprimer.setText("Supprimer");
	supprimer.setPrefSize(200, 30);
	supprimer.translateXProperty().set(680);
	supprimer.translateYProperty().set(235);
	grid.getChildren().add(supprimer);


	
	Button activiteButton = new Button("Consulter l'activit� de l'apprenant");
	activiteButton.setPrefSize(200,30);
	activiteButton.translateXProperty().set(680);
	activiteButton.translateYProperty().set(270);
	grid.getChildren().add(activiteButton);
	
	Button classementButton = new Button("Classement des apprenants");
	classementButton.setPrefSize(200,30);
	classementButton.translateXProperty().set(680);
	classementButton.translateYProperty().set(310);
	grid.getChildren().add(classementButton);
	
	Button Precedent = new Button("Precedent");
	Precedent.setPrefSize(200,30);
	Precedent.translateXProperty().set(5);
	Precedent.translateYProperty().set(460);
	grid.getChildren().add(Precedent);
	
	Precedent.setOnAction(new EventHandler<ActionEvent>(){
		
		public void handle(ActionEvent arg0) {
			
			   Stage nouveauStage;
               nouveauStage = (Stage) ((Node) arg0.getSource()).getScene().getWindow();
      
         	  FormateurFenetre formFenetre = new FormateurFenetre();

		     Scene scene = formFenetre.getScene();
             nouveauStage.setScene(scene);
		  //   gestion.show();
		
		}});

	Button quitButton = new Button("Quitter");
	quitButton.setPrefSize(200,30);
	quitButton.translateXProperty().set(680);
	quitButton.translateYProperty().set(460);
	grid.getChildren().add(quitButton);
	/*==============================================================================================*/
    TableView<Apprenant> tableView = new TableView<Apprenant>();
   // tableView.setVisible(true);
   // tableView.setPrefSize(150, 200);
    	
    TableColumn<Apprenant,String> NomCol = new TableColumn<Apprenant,String>("Nom");
    NomCol.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("nom"));
    
    TableColumn<Apprenant,String> PrenomCol = new TableColumn<Apprenant,String>("Prenom");
    PrenomCol.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("prenom"));
    
    TableColumn<Apprenant,String> DatenaissanceCol = new TableColumn<Apprenant,String>("Date de naissance");
    DatenaissanceCol.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("datenasissance"));
    
    TableColumn<Apprenant,String> adressCol = new TableColumn<Apprenant,String>("Adresse");
    adressCol.setCellValueFactory(new PropertyValueFactory<Apprenant,String>("adresse"));
    tableView.setEditable(true);
  NomCol.setPrefWidth(150);
   PrenomCol.setPrefWidth(150);
   DatenaissanceCol.setPrefWidth(150);
   adressCol.setPrefWidth(150);
   
    ajouter.setOnAction(new EventHandler<ActionEvent>(){
		
		public void handle(ActionEvent actionEvent) {
			 
		   tableView.getItems().add(new Apprenant(nom.getText(), prenom.getText(), datedenaissance.getText(), adresse.getText()));
		   FormationFenetre.formateur1.creerCompteApprenant(nom.getText(), prenom.getText(), datedenaissance.getText(), adresse.getText());
    
			nom.clear();
		    prenom.clear();
		    datedenaissance.clear();
		    adresse.clear();
		}});
    modifier.setOnAction(new EventHandler<ActionEvent>(){
		
		public void handle(ActionEvent actionEvent) {
			
		    FormationFenetre.formateur1.consulterQuiz(1);

		   
		    
		}});
    
     	
    tableView.getColumns().addAll(NomCol,PrenomCol,DatenaissanceCol,adressCol);
    
    GridPane.setConstraints(tableView, 0,7);
    GridPane.setColumnSpan(tableView,4);
    grid.getChildren().add(tableView);
    //===================================css===================================================
    ajouter.setId("btn");
    modifier.setId("btn");
    supprimer.setId("btn");
    activiteButton.setId("btn");
    classementButton.setId("btn");
    Precedent.setId("btn");
    quitButton.setId("btn");
    grid.setId("root");
    grid.getStylesheets().add(getClass().getClassLoader().getResource("com/UserInterface/accueil.css").toExternalForm());

    //======================================================================================
    return grid;
	
}


}