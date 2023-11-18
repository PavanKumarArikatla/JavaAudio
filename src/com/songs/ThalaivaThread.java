package com.songs;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
class Jailer extends Thread
{
	public void run() {
		File file = new File("Hukum.wav");
		Scanner sc = new Scanner(System.in);
		String start = "";
		try {
			AudioInputStream song = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(song);
			
			while(!start.equalsIgnoreCase("q"))
			{
				System.out.println("p = play, s = stop, r = reset, q = quit");
				System.out.print("choose anything : ");
				start = sc.next();
				switch(start)
				{
				case ("p") : clip.start();
				break;
				case ("s") : clip.stop();
				break;
				case ("r") : clip.setMicrosecondPosition(0);
				break;
				case ("q") : clip.close();
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

public class ThalaivaThread {

	public static void main(String[] args) {
		Jailer jail = new Jailer();
		jail.start();
	}

}
