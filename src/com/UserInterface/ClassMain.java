package com.UserInterface;

import javafx.application.Application;
import javafx.stage.Stage;


public class ClassMain extends Application{

	@Override
	public void start(Stage primarystage) {
		Accueil scene =new Accueil();
		scene.show();
		
	}
	public static void main(String[] args) {
	launch(args);
	}

}
