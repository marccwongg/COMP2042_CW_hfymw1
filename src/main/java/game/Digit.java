package game;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Access highscore board
	 * @param n highscore board 
	 * @param dim
	 * @param x set x position
	 * @param y set y position
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/main/resources/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
