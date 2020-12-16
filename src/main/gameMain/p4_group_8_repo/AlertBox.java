package main.gameMain.p4_group_8_repo;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox extends Main {

	public static void display(String title, String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(400);
		
		Label label = new Label();
		label.setText(message);
		
		/*Button menuButton = new Button("MENU");
		menuButton.setOnMouseClicked(e -> {
			primaryStage.setScene(menuscene);
			primaryStage.show();
		});*/
	}
}
