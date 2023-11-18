package com.songs;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PracticeThalaiva {

	public static void main(String[] args) {
		File file = new File("Firstaudio.dat.wav");
		Scanner sc = new Scanner(System.in);
		String choice = "";
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			while(choice!="Q")
			{
				System.out.println("P = play, S = stop, R = reset, Q = quit");
				System.out.print("choose anything : ");
				choice = sc.next();
				switch(choice) {
					case ("P") : clip.start();
					break;
					case ("S") : clip.stop();
					break;
					case ("R") : clip.setMicrosecondPosition(0);
					break;
					case ("Q") : clip.close();
					break;
					default : System.out.println("Not a valid option");
				}	
			}		
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}	
	}
}
