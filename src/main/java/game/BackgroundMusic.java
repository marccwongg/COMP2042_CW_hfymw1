package game;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BackgroundMusic {

	private static MediaPlayer mediaPlayer;
	private static String musicFile;
	private static Media sound;
	
//CONTROLLER
	public void playMusic() {
		prepareMP();
		getMediaPlayer().play();
	}
	
	public void stopMusic() {
		getMediaPlayer().stop();
	}
	public void prepareMP() {
		setMusicFile("src/main/resources/Frogger Main Song Theme (loop).mp3");   
		setSound(new Media(new File(getMusicFile()).toURI().toString()));
		setMediaPlayer(new MediaPlayer(getSound()));
		getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
	}

//MODEL
	public void setMediaPlayer(MediaPlayer mediaPlayer ) {
		this.mediaPlayer = mediaPlayer;
		
	}
	
	public static MediaPlayer getMediaPlayer() {
		 return mediaPlayer;
	}

	public static String getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(String musicFile) {
		this.musicFile = musicFile;
	}

	public static Media getSound() {
		return sound;
	}

	public void setSound(Media sound) {
		this.sound = sound;
	}
}
