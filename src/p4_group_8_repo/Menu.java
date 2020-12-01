package p4_group_8_repo;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;

public class Menu extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Pane root = new Pane();
		root.setPrefSize(600, 800);
		//Load image
		InputStream is = Files.newInputStream(Paths.get("src/p4_group_8_repo/froggermenu.jpg"));
		
		Image img = new Image(is);
		is.close();
		
		ImageView imgView = new ImageView(img);
		//Resize image to fit pane
		imgView.setFitWidth(600);
		imgView.setFitHeight(800);
		
		//Display image as imgView
		root.getChildren().addAll(imgView);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	  private class GameMenu extends Parent {
	        public GameMenu() {
	            VBox menu0 = new VBox(10);
	            VBox menu1 = new VBox(10);

	            menu0.setTranslateX(100);
	            menu0.setTranslateY(200);

	            menu1.setTranslateX(100);
	            menu1.setTranslateY(200);

	            final int offset = 400;

	            menu1.setTranslateX(offset);

	            MenuBtn btnPlay = new MenuBtn("PLAY");
	            btnPlay.setOnMouseClicked(event -> {
	                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
	                ft.setFromValue(1);
	                ft.setToValue(0);
	                ft.setOnFinished(evt -> setVisible(false));
	                ft.play();
	            });


	            MenuBtn btnInfo = new MenuBtn("MANUAL");
	            btnInfo.setOnMouseClicked(event -> {
	                getChildren().add(menu1);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
	                tt.setToX(menu0.getTranslateX() - offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
	                tt1.setToX(menu0.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(menu0);
	                });
	            });

	            MenuBtn btnExit = new MenuBtn("EXIT");
	            btnExit.setOnMouseClicked(event -> {
	                System.exit(0);
	            });

	            MenuBtn btnBack = new MenuBtn("BACK");
	            btnBack.setOnMouseClicked(event -> {
	                getChildren().add(menu0);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
	                tt.setToX(menu1.getTranslateX() + offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
	                tt1.setToX(menu1.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(menu1);
	                });
	            });

	            MenuBtn btnSound = new MenuBtn("SOUND");
	            MenuBtn btnVideo = new MenuBtn("VIDEO");

	            menu0.getChildren().addAll(btnPlay, btnInfo, btnExit);
	            menu1.getChildren().addAll(btnBack, btnSound, btnVideo);

	            Rectangle bg = new Rectangle(800, 600);
	            bg.setFill(Color.GREY);
	            bg.setOpacity(0.4);

	            getChildren().addAll(bg, menu0);
	        }
	    }
	
	private static class MenuBtn extends StackPane{
		private Text text;
		
		public MenuBtn(String name) {
			text = new Text(name);
			text.setFont(text.getFont().font(20));
			text.setFill(Color.WHITE);
			
			Rectangle backg = new Rectangle(200,30);
			backg.setOpacity(0.6);
			backg.setFill(Color.BLACK);
			backg.setEffect(new GaussianBlur(4.0));
			
			setAlignment(Pos.CENTER_LEFT);
			setRotate(-0.5);
			getChildren().addAll(backg,text);//White background
			
			setOnMouseEntered(event ->{
				backg.setTranslateX(10);
				text.setTranslateX(10);
				backg.setFill(Color.WHITE);
				text.setFill(Color.BLACK);
			});
			
			setOnMouseExited(event ->{
				backg.setTranslateX(10);
				text.setTranslateX(10);
				backg.setFill(Color.BLACK);
				text.setFill(Color.WHITE);
			});
			
			DropShadow drop = new DropShadow(50, Color.WHITE);
			drop.setInput(new Glow());
			
			setOnMousePressed(event -> setEffect(drop));
			setOnMouseReleased(event -> setEffect(null));
			
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}