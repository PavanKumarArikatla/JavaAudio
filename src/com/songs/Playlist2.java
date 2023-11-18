package com.songs;

//USING ARRAYLIST

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Playlist2 {
	
	static String choose="";
	
	static void play(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{
		Scanner sc = new Scanner(System.in);
		AudioInputStream audio = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audio);
		
		while(choose != "Q") {
			System.out.println("P:play, S:stop, R:reset, Q:quit");
			choose = sc.next();
			switch(choose) {
				case "P": clip.start();
				break;
				case "S": clip.stop();
				break;
				case "R": clip.setMicrosecondPosition(0);
				break;
				case "Q" : clip.close();
				break;
				default : System.out.println("i didn't get it :(");
			}
		}	
	}
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		ArrayList<File> file = new ArrayList<File>();
		file.add(new File("Hukum.wav"));
		file.add(new File("Gemini-Gemini.wav"));	
		for(File i: file) {
			play(i);
		}
	}
}
