package com.songs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Playlist {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		ArrayList<File> file = new ArrayList<File>();
		file.add(new File("Hukum.wav"));
		file.add(new File("Gemini-Gemini.wav"));
		Scanner sc = new Scanner(System.in);
		String choose = "";
		for(File i : file) {
		AudioInputStream audio = AudioSystem.getAudioInputStream(i);
		Clip clip = AudioSystem.getClip();
		clip.open(audio);
		
		System.out.println("choose : ");
		choose=sc.next();
		
		while(choose != "Q") {
		clip.start();

		}
		}
	}

}
