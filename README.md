# Frogger- COMP 2042
Author: Marcus Wong J- Fatt
Student ID: 20115147
OWA: hfymw1

Please view this README.md in my GitHub repository for better alignment and formatting.

## Introduction
This coursework is about maintaining and extending a re-implementation of a classic retro game - Frogger.

## Git & GitHub
Github Repository: https://github.com/marccwongg/COMP2042_CW_hfymw1.git (private)
Version control was done via git and in GitHub. 
History of version control can be found in `TryFrog1/Screenshots/GitHub` folder in the zip folder submitted through the screenshots of GitHub edit history.

## Setup

 - Download and extract the folder `Wong_MarcusJFatt_Eclipse_13.zip`
 - Project was compiled using Java SE 13 / Java JDK 13.0.2.
 - JavaFx is needed. (JavaFx 11 was used)
 - Project is converted to Maven build so please ensure Maven is installed in respective PC.
 - After opening project in IDE, run the project through Maven build.
 - Input `clean javafx:run` in `Goals` in `Edit Configuration`
 - Click Apply and Run. Project should run smoothly.
 - In case of Build Failure, head to `pom.xml` under `source` and `target` tags, modify the number to the Java version that you are currently running with.

## Maintenance
### File Management
- Under `src` folder contains 2 subfolders which are `main` and `test`
- `main` consists of another 2 subfolders which are `java/game` where all the .java files could be found to execute the project and `resources` where all the pictures, media and music files are located at
- `test` contains all files for JUnit test cases.
- Changed package name from `p4_group_8_repo` to `game` for easier understanding
### Main class
 - Main class only contains Main method to launch the project and start() to display the primary/ first scene upon launching the application.
 - Extracted Menu scene and main Game scene from Main
 - Ensure single responsibility
 - Removed unused imports
### Menu class
 - Removed all unused imports
 - Menu class extracted from Main have a smaller class
 - Mainly displaying the Menu scene with buttons to direct to following scene
### GameScene class
 - Removed all unused imports
 - Game scene extracted from Main to have a smaller class
 - Displaying entire game scene with high score filing system
### BackgroundMusic class
- Background music into separate class from MyStage
 - New class
 - Ensure single responsibility
 - Remove all unused imports
 - BackgroundMusic is not a subclass of MyStage, replace with aggregation, promote loose coupling
 - Self encapsulating field to avoid direct access of field  even within own class
 - Create setter and getter for encapsulated field
 - Extract method prepareMP() to set up a media player

## Extension
### Build
- The project is Maven build (refer to `pom.xml`)
- User should be able to import and run the project with Maven, Java Version 10 and above and JavaFx 10 and above as pre-requisites.
### Menu
- Added Main Menu for the game and set Main Menu scene as first scene to display upon launching. Added background image in Main Menu.
- Added "START", "INSTRUCTIONS" and "EXIT" buttons.
- "START" will launch the game scene, "INSTRUCTIONS" will launch an instruction page which is a custom background image on how to play the game and "EXIT" will quit the window system.
### Game Scene
- Changed background image of the game scene
- Removed certain parts of game display to fit the game scene appropriately
- Added "EXIT" button in game scene for users to quit the game/window while playing the game or after completing the game by clicking it.
- Added alert box with high score board displaying previous high scores when game was played in previous rounds.
### High Score Text File
- Added `highscore.txt`file where it reads the high score achieved by user after game completion and stores the high scores in the text file. User is able to view all past high scores through this text file.
- Added `highscoresorted.txt` where it reads high scores from `highscore.txt` line by line and sorts the high scores list in a descending order. The descending order high score list will be displayed through  the alert box in game scene upon game completion
### JUnit Test Case
- JUnit test done on BackgroundMusic.java on set and get methods
### Javadocs
- Included javadocs under `doc` file

## Screenshot of Frogger Game
#### Menu Scene
![MenuScene](https://github.com/marccwongg/COMP2042_CW_hfymw1/blob/master/Screenshots/FroggerGame/MenuScene.PNG)
#### Game Scene
![GameScene](https://github.com/marccwongg/COMP2042_CW_hfymw1/blob/master/Screenshots/FroggerGame/GameScene.PNG)

