package com.songs;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Thalaiva {

	public static void main(String[] args) {
		File file = new File("Hukum.wav");
		Scanner sc = new Scanner(System.in);
		
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audio);
			
			String choice = "";
			
			while(!choice.equalsIgnoreCase("Q")) {
				System.out.println("Play : P , Stop : S , Reset : R , Quit : Q");
				System.out.println("choose your choice");
				
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
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
//		while(choice.equalsIgnoreCase("Q"))
//		{
//			
//		}

	}

}
