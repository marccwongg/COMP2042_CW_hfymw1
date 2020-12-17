package game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

class MusicTest {

	MediaPlayer mediaPlayer;
	String musicFile;
	Media sd;
	
	@Test
	void musictest() {
		try {
			musicFile = "src/main/resources/Frogger Main Song Theme (loop).mp3";   
			sd = new Media(new File(musicFile).toURI().toString());
			mediaPlayer = new MediaPlayer(sd);
			mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			assertEquals(musicFile,BackgroundMusic.getMusicFile(),"Error:not the same mp3 file");
			assertTrue(BackgroundMusic.getMediaPlayer()!=null,"Error: media player does not exist");
			assertNotEquals(sd,BackgroundMusic.getSound(),"Error: same media object");
			assertNotEquals(mediaPlayer,BackgroundMusic.getMediaPlayer(),"Error: same mediaplayer object");
			assertEquals(mediaPlayer.getCycleCount(), BackgroundMusic.getMediaPlayer().getCycleCount(),"Error: not the same cycle count");
		}
		catch (Exception e) {
			e.getStackTrace();
		}
	}

}
