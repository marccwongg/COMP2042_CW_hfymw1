/*
 * @Refactored
 * Taken out Menu and GameScene from main 
 */
package game;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
	
    public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Menu start = new Menu();
		start.menu(primaryStage);
		}
}

