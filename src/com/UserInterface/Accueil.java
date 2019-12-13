package com.UserInterface;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
public class Accueil extends Stage{

	private final String form ="Formateur";
	private final String App  ="Apprenant";
	
	public Accueil() {
		this.setTitle("EsiQuiz");
		Label bienvenu = CreerMessage("Bienvenu dans notre application EsiQuiz");
	    Button FormateurBouton =  CreerBoutonFormateur();
	    Button ApprennantBouton = CreerBoutonApprenant();
	    Button[] boutons = {FormateurBouton,ApprennantBouton};
		this.centerOnScreen();
		this.setResizable(false);
	    this.setScene(new Scene(CreerLayout(bienvenu,boutons),900,500)) ;
	    
	}

public Label CreerMessage(String s) {
	
		Label label = new Label(s);
		label.setFont(Font.font("Vijaya", 40));
		label.setAlignment(Pos.TOP_CENTER);
	//	label.setPadding(new Insets(80,20,20,20));
		label.setId("text");
		return label;		
	}
public Button CreerBoutonFormateur() {
		
		Button formateur = new Button();
		formateur.setText(form);
		formateur.setPrefSize(300,75);
		formateur.setFont(Font.font("Vijaya", 40));
		formateur.setId("btn");
		 formateur.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent actionEvent) {
				
			Login login = new Login(form);	
			hide();
			login.show();
			}});
		return formateur;
	}
public Button CreerBoutonApprenant() {
		Button apprenantButton = new Button();
		apprenantButton.setText(App);
		apprenantButton.setFont(Font.font("Vijaya", 40));
		apprenantButton.setPrefSize(300,75);
		apprenantButton.setId("btn");
		apprenantButton.setOnAction(new EventHandler<ActionEvent>(){
		
		public void handle(ActionEvent arg0) {
				
		/*	Login login = new Login(App);	
			login.show();*/
			   Stage nouveauStage;
               nouveauStage = (Stage) ((Node) arg0.getSource()).getScene().getWindow();
               //Scene scene =  this.FormationFenetre();//new Scene(new FormationFenetre(), 200, 200);
               FormationFenetre fortFenetre =new FormationFenetre();
               Scene scene = fortFenetre.getScene();
               nouveauStage.setScene(scene);
			}});
		
		return apprenantButton;
	}
	
public VBox CreerLayout(Label s,Button[] boutons) {
	
		VBox contenu = new VBox();
	
		//contenu.setPadding(new Insets(20,20,20, 20));
		contenu.setAlignment(Pos.CENTER);
		
		FlowPane layout = new FlowPane(Orientation.VERTICAL);
layout.setId("root");
		layout.setAlignment(Pos.CENTER);
		layout.setVgap(20);
		layout.getChildren().setAll(boutons);		
		contenu.getChildren().setAll(s,layout);
			//contenu.getStylesheets().add("com/UserInterface/accueil.css");
		layout.getStylesheets().add(getClass().getClassLoader().getResource("com/UserInterface/accueil.css").toExternalForm());

			contenu.getStylesheets().add(getClass().getClassLoader().getResource("com/UserInterface/accueil.css").toExternalForm());
		return contenu;
		
	}
}
