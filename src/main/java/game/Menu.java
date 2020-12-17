/**
 * @Refactored
 * Removed all unsued imports
 * Menu scene extracted from Main
 */
package game;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu {

	Scene menuscene, insscene;
	
	/**
	 * set stage for Menu Scene
	 * @param primaryStage
	 */
	public void menu (Stage primaryStage){
		
		//Menu Background Image
	      Image image = new Image("file:src/main/resources/froggermenu.jpg", 600, 800, true, true);
	      //Creating the image view
	      ImageView imageView = new ImageView();
	      //Setting image to the image view
	      imageView.setImage(image);
	    //Setting the image view parameters
	      imageView.setX(10);
	      imageView.setY(10);
	      imageView.setFitWidth(600);
		  imageView.setFitHeight(800);
	      imageView.setPreserveRatio(true);
	      //Setting the Scene object
	      Group root = new Group(imageView);
	     
	     //Instructions Image
	      Image image2 = new Image("file:src/main/resources/frogger_inspage.png", 600, 540, true, true);
	      //Creating the image view
	      ImageView imageView2 = new ImageView();
	      //Setting image to the image view
	      imageView2.setImage(image2);
	    //Setting the image view parameters
	      imageView2.setX(10);
	      imageView2.setY(10);
	      imageView2.setFitWidth(600);
		  imageView2.setFitHeight(540);
	      imageView2.setPreserveRatio(true);
	      //Setting the Scene object
	      Group root2 = new Group(imageView2);
	    
	      
		//Start Button
	      	GameScene game = new GameScene();
	  		Button btnstart = new Button("START");
	  		btnstart.setTranslateX(100);
	  	    btnstart.setTranslateY(-400);
	  	    //btnstart.setOnAction(this);
	  	    btnstart.setOnMouseClicked(event -> {
	  			game.gamescene(primaryStage);
	  	    });
		  	 
	  //Instruction Button
	  	    Button btnmanual = new Button("INSTRUCTIONS");
	  	    btnmanual.setTranslateX(100);
	  	    btnmanual.setTranslateY(-375);
	  	    //btnmanual.setOnAction(this);
	  	    btnmanual.setOnMouseClicked(event ->{
	  	    	primaryStage.setScene(insscene);
	  	    	primaryStage.show();
	  	    });
	  	      	     
	  //Exit Button
	  	  Button btnexit = new Button("EXIT");
	  	  btnexit.setTranslateX(100);
	  	  btnexit.setTranslateY(-350);
	  	  btnexit.setOnMouseClicked(event -> {
	  		  
	  	  System.exit(0);
	  	  
	  	  });
	  	  
	  //Game Menu Layout
	  	  VBox layout = new VBox(20); 
	  	  layout.getChildren().addAll(root, btnstart , btnmanual, btnexit);
	  	  Scene menuscene = new Scene(layout,600,540 ); 
	  	 
	  //Instructions Layout
	  	  Button btnbackins = new Button("BACK");
	  	  btnbackins.setTranslateX(400);
	  	  btnbackins.setTranslateY(-500);
	  	  btnbackins.setOnMouseClicked(event ->{
	    	primaryStage.setScene(menuscene);
	    	primaryStage.show();
	    });
	  	  
	  	  VBox layoutins = new VBox(20); 
		  layoutins.getChildren().addAll(root2,btnbackins);  
		  insscene = new Scene(layoutins,600,540);
		  
		  	primaryStage.setTitle("FROGGER");
			primaryStage.setScene(menuscene);
			primaryStage.show();
	  	  
		
		
	}
	//end of start
	
		
	  	public static class Button extends StackPane{
			private Text text;
			
			/**
			 *Construct a name instance for Game Scene buttons
			 *@param name to give instance
			 */
			public Button(String name) {
				text = new Text(name);
				text.getFont();
				text.setFont(Font.font(20));
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

}
