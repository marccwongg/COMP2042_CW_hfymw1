/*
 * @Refactored
 * Taken out Menu and GameScene from main 
 */
package main.gameMain.p4_group_8_repo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{
	Scene menuscene, insscene;
	
    public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Menu start = new Menu();
		start.menu(primaryStage);
		}
}

