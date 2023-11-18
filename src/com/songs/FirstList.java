package com.songs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class FirstList {

	public static void main(String[] args) {
		
		List<String> songs = new ArrayList<String>();
		songs.add("Firstaudio.dat.wav");
		songs.add("Hukum.wav");
		songs.add("Gemini-Gemini.wav");
		
		try
		{
			for(int i=0;i<songs.size();i++)
			{
				System.out.println("Now playing " + songs.get(i));
				Clip clip = play(songs.get(i));
				while(clip.getMicrosecondLength() != clip.getMicrosecondPosition())
				{
					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static Clip play(String location)
	{
		try 
		{
			File file = new File(location);
			if(file.exists())
			{
				AudioInputStream audio = AudioSystem.getAudioInputStream(file);
				Clip clip = AudioSystem.getClip();
				clip.open(audio);
				clip.start();
				return clip;
			}
			else
				System.out.println("file not found");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
