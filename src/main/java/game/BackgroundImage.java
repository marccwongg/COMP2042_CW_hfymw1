package game;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	/**
	 * Construct a name instance for background image
	 * @param imageLink image file directory
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 900, 900, true, true));
	}

}
