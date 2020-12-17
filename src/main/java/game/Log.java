package game;

import javafx.scene.image.Image;

public class Log extends Actor {

	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	/**
	 * Access log in game scene
	 * @param imageLink image file directory
	 * @param size 
	 * @param xpos set x position
	 * @param ypos set y position
	 * @param s set speed
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	/**
	 * 
	 * @return TRUE if speed less than 0
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
