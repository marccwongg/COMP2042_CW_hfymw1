package game;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	/**
	 * Access checkpoint position
	 * @param x set x position
	 * @param y set y position
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/End.png", 60, 60, true, true));
	}
	
	/**
	 * Indicates Completed Checkpoint image
	 */
	public void setEnd() {
		setImage(new Image("file:src/main/resources/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	/**
	 * Screen checkpoint
	 * @return TRUE if checkpoint is completed
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
