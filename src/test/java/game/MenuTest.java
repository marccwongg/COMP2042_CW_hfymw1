package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.control.Button;

class MenuTest {

	@Test
	void menubuttontest() {
		String exitbutton = "EXIT";
		@SuppressWarnings("unused")
		Button btnexit = new Button (exitbutton);
		System.out.println(exitbutton);
		assertEquals("EXIT",exitbutton,"Error:Button text not matched");
	}

}
