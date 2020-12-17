/**
 * @author Marcus Wong
 * @Refactored 
 * Main class containing Main method
 * Extracted Menu and GameScene from main 
 * Ensure single rsponsibility
 */
package game;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
	
    public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	/**
	 * Display Menu scene once game is launched
	 * @throws Exception if unable to display primaryStage scene
	 */
	public void start(Stage primaryStage) throws Exception {
		
		Menu start = new Menu();
		start.menu(primaryStage);
		}
}

