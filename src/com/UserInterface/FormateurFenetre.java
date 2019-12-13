package com.UserInterface;

import com.Noyau.*;
import java.time.LocalDate;
import java.util.*;
import javafx.animation.Animation;
import javafx.scene.input.MouseEvent;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FormateurFenetre extends Stage{
Stage window;
	public final String form = "Creation d'une formation";
	public final String gererApp = "Gestion des apprenants";
	public final String quiz = "Modification un quiz";
	
	public FormateurFenetre() {
		
		this.setTitle("Formateur");
		Button Formation = CreerFormation();
		Button GererApprenantButton = GestionApprenant();
		Button quiz =  ModifierQuiz();
		Button[] boutons = {Formation,GererApprenantButton,quiz};
		this.centerOnScreen();
		this.setResizable(false);
		this.setScene(new Scene(CreerLayoutFormateur(boutons),900,500));
	    
	}

	public Button CreerFormation() {
		
		Button formation = new Button();
		formation.setText(form);
		formation.setFont(Font.font("Vijaya",25));
		formation.setPrefSize(300,70);
		formation.setId("btn");

		formation.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent arg0) {

				Stage nouveauStage;
	               nouveauStage = (Stage) ((Node) arg0.getSource()).getScene().getWindow();
	      
					FormationFenetre formationFenetre = new FormationFenetre();

			     Scene scene = formationFenetre.getScene();
	             nouveauStage.setScene(scene);
				

				 			}});
		
		return formation;
	}
	public Button GestionApprenant() {
     
		Button Apprenant = new Button();
		Apprenant.setText(gererApp);
		Apprenant.setFont(Font.font("Vijaya",25));
		Apprenant.setPrefSize(300,70);
		Apprenant.setId("btn");
		Apprenant.setOnAction(new EventHandler<ActionEvent>(){
				
				public void handle(ActionEvent arg0) {
					
					   Stage nouveauStage;
		               nouveauStage = (Stage) ((Node) arg0.getSource()).getScene().getWindow();
		      
				     GestoinApprenantFenetre gestion = new GestoinApprenantFenetre();
				     Scene scene = gestion.getScene();
		             nouveauStage.setScene(scene);
				  //   gestion.show();
				
				}});
		

		return Apprenant;
	}
	public Button ModifierQuiz() {

		Button Quizz = new Button();
		Quizz.setText(quiz);
		Quizz.setFont(Font.font("Vijaya",25));
		Quizz.setPrefSize(300,70);
		
		Quizz.setId("btn");
		Quizz.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent actionEvent) {

			}});
		
		return Quizz;
		
	}
	
	

	public VBox CreerLayoutFormateur(Button[] boutons) {
		
		VBox listboutons = new VBox();
		
		listboutons.setAlignment(Pos.CENTER);
		
        FlowPane layout = new FlowPane(Orientation.VERTICAL);
       
        layout.setAlignment(Pos.CENTER);
        
      
        layout.setPadding(new Insets(20,20,20,20));
		layout.setVgap(40);
		layout.setHgap(40);
		layout.getChildren().setAll(boutons);		
		listboutons.getChildren().setAll(layout);
		layout.setId("root");
		layout.getStylesheets().add(getClass().getClassLoader().getResource("com/UserInterface/Formateur.css").toExternalForm());
		listboutons.getStylesheets().add(getClass().getClassLoader().getResource("com/UserInterface/Formateur.css").toExternalForm());
		return listboutons;
	}
}
