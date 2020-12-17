/**
 * Refactored
 * Game scene taken out from Main
 */
package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameScene {

	AnimationTimer timer;
	MyStage background;
	Animal animal;

	public void gamescene(Stage primaryStage) {
		
		background = new MyStage();
		Scene scene  = new Scene(background,600,800);
	
		primaryStage.setScene(scene);
		background.start();
		start();
		
		// GAME SCENE
				BackgroundImage froggerback = new BackgroundImage("file:src/main/resources/arcade.png");
			    
				background.add(froggerback);
				
				//Exit button
				Button exitbtn = new Button("EXIT");
				exitbtn.setTranslateX(5);
				exitbtn.setTranslateY(5);
			  	exitbtn.setOnMouseClicked(event -> {
			  		  System.exit(0);
			  	  });
				
				background.add(exitbtn);
				
				//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
				//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
				//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
				
				background.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
				background.add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
				background.add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
				//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
				background.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
				background.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
				//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
				background.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
				background.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
				background.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
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
				animal = new Animal("file:src/main/resources/froggerUp.png");
				background.add(animal);
				background.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
				background.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
				background.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
				//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
				background.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
				background.add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
				background.add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
				background.add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
				background.add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
				background.add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
				background.add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));
				background.add(new Digit(0, 30, 360, 25));
				//background.add(new InGameButton("EXIT",20,20));
				//background.add(obstacle);
				//background.add(obstacle1);
				//background.add(obstacle2);
				
				//start();
			}
			//end of start
			
				//Button styles (Refactored)
			  	public static class Button extends StackPane{
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
		            	}
		            	
		            	//Storing highscore into a text file
		            	try {
		            	    if (animal.getStop()) {
		            		File myObj = new File("highscore.txt");
		            	      if (myObj.createNewFile()) {
		            	        System.out.println("File created: " + myObj.getName());
		            	      } else {
		            	        System.out.println("File already exists.");
		            	     }
		            	    FileWriter myWriter = new FileWriter("highscore.txt", true);
		            	    myWriter.write("*****SCORE HISTORY*****" + newLine);
		            	    }
		            	   } catch (IOException e) {
		            	      System.out.println("An error occurred.");
		            	      e.printStackTrace();
		            	    }
		            	
		            	try {
		            		if (animal.getStop()) {
		            		FileWriter myWriter1 = new FileWriter("highscore.txt", true);
		            	    myWriter1.write(newLine + ""+ animal.getPoints()+ newLine);
		          	        myWriter1.close();
		            		}
		            	} catch (IOException e) {
		          	      System.out.println("An error occurred.");
		          	      e.printStackTrace();
		          	  }
		            	
		            	//Create and write highscores in a text file
		            	try
		            	{
		            		//Creating BufferedReader object to read the input file
		            		reader = new BufferedReader(new FileReader("highscore.txt"));
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
		                     
		                    writer = new BufferedWriter(new FileWriter("highscoresorted.txt"));
		                    
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
		            
		            //Read from sorted highscore and display in alert box
		            try {
		    	        if (animal.getStop()) {
		    	        		System.out.print("STOP:");
		    	        		/*
		    	        		background.stopMusic();
		    	        		stop();
		    	        		background.stop();
		    	        		*/
		    	        		reader1 = new BufferedReader(new FileReader("highscoresorted.txt"));
		    	                
		    	                //Reading all the lines of input file one by one and adding them into ArrayList
		    	                 
		    	                String currentLine = reader1.readLine();          
		    	                while (currentLine != null)
		    	                {
		    	                    lines1.add(currentLine);
		    	                    currentLine = reader1.readLine();
		    	                }
		    	        	Alert alert = new Alert(AlertType.INFORMATION);
		    	    		alert.setTitle("You Have Won The Game!");
		    	    		alert.setHeaderText("Your Score: "+animal.getPoints()+"!");
		    	    		alert.setContentText("Highest Possible Score: 800\n"+"Highscore Leaderboard:\n" + lines);
		    	    		alert.show();
		    	        	}
		    	        }
		    	        
		            	catch (IOException e) 
		                    {
		                        e.printStackTrace();
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
	}