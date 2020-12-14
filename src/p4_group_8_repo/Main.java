package p4_group_8_repo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

//MainMenu
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Main extends Application{
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	Scene insscene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		background = new MyStage();
		Scene scene  = new Scene(background,600,800);//Frogger Game
			
		//Menu Image
	      Image image = new Image("file:src/p4_group_8_repo/froggermenu.jpg", 600, 800, true, true);
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
	      Image image2 = new Image("file:src/p4_group_8_repo/frogger_inspage.png", 600, 540, true, true);
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
	  		Button btnstart = new Button("START");
	  		btnstart.setTranslateX(100);
	  	    btnstart.setTranslateY(-400);
	  	    //btnstart.setOnAction(this);
	  	    btnstart.setOnMouseClicked(event -> {
	  			primaryStage.setScene(scene);
	  			background.start();
	  			start();
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
	  	  
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
	  	    
		BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/arcade.png");
	    
		background.add(froggerback);
		
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 490, 329, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
		background.add(animal);
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/car1Left.png", 500, 490, -5, 50, 50));
		background.add(new Digit(0, 30, 360, 25));
		//background.add(new Button("BACK"));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		
		primaryStage.setTitle("FROGGER");
		primaryStage.setScene(menuscene);
		primaryStage.show();
		//start();
	}
	//end of start
	
		//Button styles (Refactored)
	  	class Button extends StackPane{
			private Text text;
			
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

	/*catch (Exception e) { 
		  
        System.out.println(e.getMessage()); 
    } */
	
	 //controller
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	BufferedReader reader = null; 
                BufferedReader reader1 = null;
                BufferedWriter writer = null;
                String newLine = System.getProperty("line.separator");
                
              //Create an ArrayList object to hold the lines of input file
                ArrayList<String> lines = new ArrayList<String>();
                ArrayList<String> lines1 = new ArrayList<String>();
                
                
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            	
            	//Storing highscore into a text file
            	try {
            	    if (animal.getStop()) {
            		File myObj = new File("C:\\Users\\Lenovo IBM\\eclipse-workspace\\TryFrog1\\highscore.txt");
            	      if (myObj.createNewFile()) {
            	        System.out.println("File created: " + myObj.getName());
            	      } else {
            	        System.out.println("File already exists.");
            	     }
            	    FileWriter myWriter = new FileWriter("C:\\Users\\Lenovo IBM\\eclipse-workspace\\TryFrog1\\highscore.txt", true);
            	    myWriter.write(newLine);
            	    myWriter.write("*****SCORE HISTORY*****" + newLine);
            	    myWriter.write("\n Your latest score is: "  + animal.getPoints() + newLine);
          	        myWriter.close();
            	    }
            	   } catch (IOException e) {
            	      System.out.println("An error occurred.");
            	      e.printStackTrace();
            	    }
            	
            	//Create and write highscores in a text file
            	try
            	{
            		//Creating BufferedReader object to read the input file
            		reader = new BufferedReader(new FileReader("C:\\Users\\Lenovo IBM\\eclipse-workspace\\TryFrog1\\highscore.txt"));
            		//Reading all the lines of input file one by one and adding them into ArrayList
            		String currentLine = reader.readLine();
            		while (currentLine != null) 
                    {
                        lines.add(currentLine);
                        currentLine = reader.readLine();
                    }
            		
            		//Sorting the ArrayList
                    
                    Collections.sort(lines, Collections.reverseOrder());
                     
                    //Creating BufferedWriter object to write into output file
                     
                    writer = new BufferedWriter(new FileWriter("C:\\Users\\Lenovo IBM\\eclipse-workspace\\TryFrog1\\highscoresorted.txt"));
                    
                  //Writing sorted lines into output file
                    writer.write("Highgest Score First");
                    writer.newLine();
                    for (String line : lines)
                    {
                        writer.write(line);
                        writer.newLine();
                    }
                } 
            	catch (IOException e) 
                {
                    e.printStackTrace();
                }
            	finally
                {
                    //Closing the resources   
                    try
                    {
                        if (reader != null)
                        {
                            reader.close();
                        }  
                        if(writer != null)
                        {
                            writer.close();
                        }
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
            	}
        };
    }
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
    
    public static void main(String[] args) {
		launch(args);
	}

	/*@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/

	
    
}

