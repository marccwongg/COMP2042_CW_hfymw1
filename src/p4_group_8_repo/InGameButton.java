/**@Extension
 * Added in-game exit button
 */

package p4_group_8_repo;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

//import p4_group_8_repo.Main.Button;

public class InGameButton extends Actor{
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	//Button styles (Refactored)
  	public class Button extends StackPane{
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
	
}
	
/*	public void InGameBtton(String ingamebutton, int x, int y) {
		Button btnexit = new Button(ingamebutton);
	  	btnexit.setTranslateX(100);
	  	btnexit.setTranslateY(-350);
	  	btnexit.setOnMouseClicked(event -> {
	  		  System.exit(0);
	  	  
	  	  });
		setX(x);
		setY(y);
	}
	
}*/


/*import p4_group_8_repo.Main.Button;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class InGameButton extends Parent {

	private Button gameexit;
	private VBox gamebox;
//**************************************************CONTROLLER*******************************************************	
	InGameButton() {
		//game scene buttons
		setGamebox(new VBox(5));
		getGamebox().setTranslateX(5);
		getGamebox().setTranslateY(5);
		setGameexit(new Button("EXIT"));
		getGamebox().getChildren().addAll(getGameexit());
		getChildren().addAll(getGamebox());
	}

	public void enable() {
		getGameexit().setDisable(false);	
	}
	public void disable() {
        getGameexit().setDisable(true);
	}
	
//***********************************************************MODEL****************************************************

	public Button getGameexit() {
		return gameexit;
	}

	public void setGameexit(Button gameexit) {
		this.gameexit = gameexit;
	}

	public VBox getGamebox() {
		return gamebox;
	}

	public void setGamebox(VBox gamebox) {
		this.gamebox = gamebox;
	}

}
*/
