package com.UserInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
  
/**
 *
 * @web http://zoranpavlovic.blogspot.com/
 */
public class Login extends Stage {
  
 String user = "younes";
 String pw = "123456";
 String VerifierUtilisateur, VerifierMotdePasse;
 Label utilisateurLabel = new Label("Utilisateur");
 final TextField utilisaturField = new TextField();
 Label motdepasseLabel = new Label("Mot de passe");
 final PasswordField pf = new PasswordField();
 Button loginButton = new Button("Se connecter");
 final Label messageLabel = new Label();
 
 public Login(String s) {
	 
	 this.setTitle("Mot de passe");
	 this.setResizable(false);
	 this.setScene(new Scene(CreerLayoutLogin(s),310,250));
	 
 }
 
 public GridPane CreerLayoutLogin(String s) {
	 

     GridPane gridPane = new GridPane();
     gridPane.setPadding(new Insets(10,10,10,10));
     gridPane.setAlignment(Pos.CENTER);
     gridPane.setHgap(5);
     gridPane.setVgap(5);

     loginButton.setPrefSize(200,30);
     
//=============================Authentification=====================================================
     loginButton.setOnAction(new EventHandler<ActionEvent>() {
         
         public void handle(ActionEvent event) {
          
         	VerifierUtilisateur = utilisaturField.getText().toString();
         	VerifierMotdePasse   = pf.getText().toString();
          
          if(VerifierUtilisateur.equals(user) && VerifierMotdePasse.equals(pw)&& s.equals("Formateur")){
 
        	  FormateurFenetre formFenetre = new FormateurFenetre();
        	  hide();
        	  formFenetre.show();
          }
          else   if(VerifierUtilisateur.equals(user) && VerifierMotdePasse.equals(pw)&& s.equals("Apprenant")){
 
           }
          else{
        	
           messageLabel.setText("Le mot de passe est incorrect");
           messageLabel.setTextFill(Color.RED);
          }
          utilisaturField.setText("");
          pf.setText("");
         }
         @Override
         protected Object clone() throws CloneNotSupportedException {
         	// TODO Auto-generated method stub
         	return super.clone();
         }
         });
//==================================================================================
     utilisaturField.setPromptText("Entrer votre nom d'utilisateur");
     pf.setPromptText("Entrer votre mot de passe ");
      
     gridPane.add(utilisateurLabel, 0, 0);
     gridPane.add(utilisaturField, 1, 0);
     gridPane.add(motdepasseLabel, 0, 1);
     gridPane.add(pf, 1, 1);
     gridPane.add(loginButton, 1, 4);
     gridPane.add(messageLabel, 1, 2);
     gridPane.setColumnSpan(messageLabel, 3);

   return gridPane;
 }                    
}
        