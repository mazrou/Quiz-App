package com.UserInterface;




import java.awt.CardLayout;
import java.util.ArrayList;

import com.Noyau.Formateur;
import com.Noyau.Notion;
import com.Noyau.Question;
import com.Noyau.Quiz;

import javafx.scene.control.cell.ComboBoxListCell;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class FormationFenetre extends Accueil{
	
	Stage window;
	public CardLayout layoutt = new CardLayout();
	ListView<String> list = new ListView<>();
	int j=0;
	 public static Formateur formateur1 = new Formateur("Yasser", "DRIF");

	Label reponseincorrectLabel = new Label();
	Text etiq = new Text("Ensemble des reponses correctes:");
	Text etiq1 = new Text("Ensemble des reponses incorrectes:");
	
	
	public FormationFenetre() {
		this.setTitle("Formation");
		this.setResizable(false);
		this.setScene(new Scene(CreerLayoutFormation(), 900, 500));
		
	}
	public GridPane CreerLayoutFormation() {
 		
 		 Label reponseLabel = new Label();
 		 TextField reponseField = new TextField();
 	   	 Label reponseLabel2 = new Label();
         TextField reponseField2 = new TextField();
         Label reponseLabel3 = new Label();
         TextField reponseField3 = new TextField();
         Label reponseLabel4 = new Label();
         TextField reponseField4 = new TextField();  
         Label reponseQO = new Label();
         TextField reponseQOField = new TextField();
        
         
  		 GridPane layout = new GridPane();
  		 
  		 layout.setPadding(new Insets(5,5,20,5));
  		 layout.setHgap(4);
  		 layout.setVgap(10);
  		// layout.setGridLinesVisible(true);
  		 //================================================================================================
  		 Label nomquizLabel = new Label("Nom du quiz: ");
  		 GridPane.setConstraints(nomquizLabel, 0, 0);
  		 TextField nomquizField = new TextField();
  		 nomquizField.setPrefColumnCount(10);
  		 
  		 nomquizField.setPromptText("Introduire le nom du quiz");
  		 GridPane.setConstraints(nomquizField, 1, 0);
         layout.getChildren().addAll(nomquizLabel,nomquizField);
         //================================================================================================
  		 Label datedebutquizLabel = new Label("Date d'ouverture du quiz: ");
  		 GridPane.setConstraints(datedebutquizLabel, 0, 1);
  		 TextField datedebutdequizField = new TextField();
  		 datedebutdequizField.setPrefColumnCount(10);
  		 datedebutdequizField.setPromptText("la date d'ouverture du quiz jj/mm/aaaa");
  		 GridPane.setConstraints(datedebutdequizField, 1, 1);  	
         layout.getChildren().addAll(datedebutquizLabel,datedebutdequizField);
  		 //================================================================================================
  		 Label dateexpirationquizLabel = new Label("Date d'expiration du quiz: ");
 		 GridPane.setConstraints(dateexpirationquizLabel, 0, 2);
 		 TextField dateexpirationquizField = new TextField();
 		 dateexpirationquizField.setPrefColumnCount(10);
 		 dateexpirationquizField.setPromptText("la date d'expiration du quiz jj/mm/aaaa");
 		 GridPane.setConstraints(dateexpirationquizField, 1, 2); 
 		// GridPane.setColumnSpan(dateexpirationquizLabel, 3);
 		 layout.getChildren().addAll(dateexpirationquizLabel,dateexpirationquizField);
  		 //================================================================================================
 		 
 		 TextArea textArea =new TextArea();
 		 textArea.setPromptText("Saisir ici la question");
		 GridPane.setConstraints(textArea, 0, 4);
		 GridPane.setColumnSpan(textArea, 2);
	//	 textArea.setPrefSize(400, 100);
		 layout.getChildren().add(textArea);

		 //================================================================================================
		 Label typequestionLabel = new Label("Type de question: ");
	     GridPane.setConstraints(typequestionLabel, 3, 1);
	     
		 ComboBox<String> typequestion = new ComboBox<String>();    
		 typequestion.setPromptText("Choisir un type");
		 typequestion.setPrefSize(150, 20);
	     typequestion.getItems().addAll("QCM","QCU","QO");
	     HBox typequestionBox = new HBox(typequestion);
	     typequestionBox.setSpacing(40);
	     GridPane.setConstraints(typequestionBox, 4,1);
	     layout.getChildren().addAll(typequestionLabel,typequestionBox);
		 //================================================================================================
	     Label ajouternotionLabel = new Label("Nouveau notion ");
  		 GridPane.setConstraints(ajouternotionLabel, 3, 0);
  		 TextField ajouternotionfField = new TextField();
  		 ajouternotionfField.setPrefColumnCount(10);
  	  	 ajouternotionfField.setPromptText("Introduire la notion");
  		 GridPane.setConstraints(ajouternotionfField, 4, 0);
         layout.getChildren().addAll(ajouternotionLabel,ajouternotionfField);
	     //================================================================================================
		 Label notionLabel = new Label("Notion: ");
	     GridPane.setConstraints(notionLabel, 3,2 );
	     
		 ComboBox<String> notion = new ComboBox<String>();  
		 
		 notion.setPromptText("Choisir une notion ");
		 notion.setPrefSize(150, 20);
	     HBox notionBox = new HBox(notion);
	     GridPane.setConstraints(notionBox, 4,2);
	     layout.getChildren().addAll(notionLabel,notionBox);
		 //================================================================================================
         Button ajouterButton33 = new Button("AjouterNotion");
         
         GridPane.setConstraints(ajouterButton33, 5, 0);
         layout.getChildren().add(ajouterButton33);
         ajouterButton33.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent actionEvent) {
				
				notion.getItems().add(ajouternotionfField.getText());
				ajouternotionfField.clear();
			}});
         
         //================================================================================================
        list.setEditable(true);
         Button ajouterquestionButton = new Button("Ajouter");
         GridPane.setConstraints(ajouterquestionButton, 3, 4);
        ajouterquestionButton.setPrefSize(120, 30);
         list.setPrefSize(300, 200);
         list.setOrientation(Orientation.VERTICAL);
         VBox listBox = new VBox();
         listBox.setSpacing(10);
         listBox.getChildren().addAll(list);
         GridPane.setColumnSpan(listBox, 2);

         GridPane.setConstraints(listBox, 4, 4);
         layout.getChildren().add(listBox);
         layout.getChildren().add(ajouterquestionButton);
         
       ajouterquestionButton.setOnAction(new EventHandler<ActionEvent>(){

        	public void handle(ActionEvent actionEvent) 
			{
		        list.getItems().add(textArea.getText());
		        
     formateur1.creerFormation(nomquizField.getText(), "Ouvert", datedebutdequizField.getText(), dateexpirationquizField.getText());
     formateur1.formation.creerNotion(notion.getValue());         
     formateur1.formation.notion.get(0).ajouterQuestion(textArea.getText(),typequestion.getValue(),reponseField.getText(),reponseField2.getText(),reponseField3.getText(),reponseField4.getText());
    // formateur1.ajouterQuestionQuiz(1);		       
     textArea.clear();
		         
		         			}});
       //  list.setCellFactory(ComboBoxListCell.forListView("ouii"));
         
         //================================================================================================
	     reponseLabel.setText("Reponse 1:");
 		 GridPane.setConstraints(reponseLabel, 0, 6);
 		 reponseField.setPrefColumnCount(15);    		 
 		 reponseField.setPromptText("Saisir la r�ponse");
 		 GridPane.setConstraints(reponseField, 1, 6);
 	                     	
  	     reponseLabel2.setText("Reponse 2:");
		 GridPane.setConstraints(reponseLabel2, 0, 7);
		 reponseField2.setPrefColumnCount(15);    		 
		 reponseField2.setPromptText("Saisir la r�ponse");
		 GridPane.setConstraints(reponseField2, 1, 7);
	                          
      	     reponseLabel3.setText("Reponse 3:");
    		 GridPane.setConstraints(reponseLabel3, 0, 8);
    		 reponseField3.setPrefColumnCount(15);    		 
    		 reponseField3.setPromptText("Saisir la r�ponse");
    		 GridPane.setConstraints(reponseField3, 1, 8);
    	      
    	     reponseLabel4.setText("Reponse 4:");
             GridPane.setConstraints(reponseLabel4, 0, 9);
             reponseField4.setPrefColumnCount(15);    		 
             reponseField4.setPromptText("Saisir la r�ponse");
             GridPane.setConstraints(reponseField4, 1, 9);
             reponseQO.setText("Reponse :");         		 
      		 reponseQOField.setPrefColumnCount(15);    		 
      		 reponseQOField.setPromptText("Saisir la r�ponse");
      		 GridPane.setConstraints(reponseQOField, 5, 6);
             GridPane.setConstraints(reponseQO, 4, 6);     
             layout.getChildren().addAll(reponseLabel,reponseField);
             layout.getChildren().addAll(reponseLabel2,reponseField2);
             layout.getChildren().addAll(reponseLabel3,reponseField3);
     	     layout.getChildren().addAll(reponseLabel4,reponseField4);  
      	     layout.getChildren().addAll(reponseQO,reponseQOField);
        		reponseQOField.setDisable(true);           		
         		reponseField.setDisable(true);            	   
                reponseField2.setDisable(true);                     
                reponseField3.setDisable(true);                    
                reponseField4 .setDisable(true);
      	     typequestion.setOnAction(new EventHandler<ActionEvent>(){

             	public void handle(ActionEvent actionEvent) 
     			{
               
              	if((typequestion.getValue()=="QCM")||(typequestion.getValue()=="QCU")) {
              		reponseQOField.setDisable(true);           		
             		reponseField.setDisable(false);            	   
                    reponseField2.setDisable(false);                     
                    reponseField3.setDisable(false);                    
                    reponseField4 .setDisable(false);
                   }
            	else if(typequestion.getValue()=="QO"){
            		reponseQOField.setDisable(false);           		
             		reponseField.setDisable(true);            	   
                    reponseField2.setDisable(true);                     
                    reponseField3.setDisable(true);                    
                    reponseField4 .setDisable(true);
           	     
             	}
             	
     		         			}});
         //================================================================================================
         Button retourButton = new Button("Retour");
       //  GridPane.setConstraints(retourButton,3, 10);
         retourButton.setPrefSize(150, 30);
         
         retourButton.translateXProperty().set(425);
         retourButton.translateYProperty().set(460);
         retourButton.setOnAction(new EventHandler<ActionEvent>(){
 			
			public void handle(ActionEvent arg0) {
				
				   Stage nouveauStage;
	               nouveauStage = (Stage) ((Node) arg0.getSource()).getScene().getWindow();
	      
	         	  FormateurFenetre formFenetre = new FormateurFenetre();

			     Scene scene = formFenetre.getScene();
	             nouveauStage.setScene(scene);

			}});
           Button sauvegarderButton = new Button("Sauvegarder");
         //  GridPane.setConstraints(sauvegarderButton,4, 10);
           sauvegarderButton.setPrefSize(150, 30);
           sauvegarderButton.translateXProperty().set(580);
           sauvegarderButton.translateYProperty().set(460);
           layout.getChildren().add(sauvegarderButton);
           
    	    sauvegarderButton.setOnAction(new EventHandler<ActionEvent>(){

              	public void handle(ActionEvent actionEvent) 
      			{
            
          formateur1.creerQuiz(nomquizField.getText(), datedebutdequizField.getText(), dateexpirationquizField.getText(), "ouvert");
         
      			}});

           
           layout.getChildren().add(retourButton);        
           Button CancelButton = new Button("Cancel");
       //    GridPane.setConstraints(CancelButton,5, 10);
           CancelButton.translateXProperty().set(735);
           CancelButton.translateYProperty().set(460);
         
           
           CancelButton.setPrefSize(150, 30);
           layout.getChildren().add(CancelButton);

       //================================================================================================
       ajouterButton33.setId("btn");
       ajouterquestionButton.setId("btn");
       retourButton.setId("btn");
       sauvegarderButton.setId("btn");
       CancelButton.setId("btn");
 
       nomquizLabel.setId("Label");
       datedebutquizLabel.setId("Label");
       dateexpirationquizLabel.setId("Label");
       notionLabel.setId("Label");
       reponseLabel.setId("Label");
       reponseLabel2.setId("Label");
       reponseLabel3.setId("Label");
       reponseLabel4.setId("Label");
       reponseQO.setId("Label");
       notion.setId("combobox");
       typequestion.setId("combobox");
       
       layout.setId("root");
   	layout.getStylesheets().add(getClass().getClassLoader().getResource("com/UserInterface/accueil.css").toExternalForm());
      //================================================================================================
           
  		
		return layout;
		
		
	}

	

}
