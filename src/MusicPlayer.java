import java.io.File;

import javax.media.*;
import java.net.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.media.Manager;

public class MusicPlayer {
	
	ArrayList<String> paths = new ArrayList<String>();
	ArrayList<File> songFiles = new ArrayList<File>();
	ArrayList<File> queueFiles = new ArrayList<File>();
	ArrayList<String> songs = new ArrayList<String>();
	ArrayList<String> artists = new ArrayList<String>();
	public BufferedImage image;
	
	public static final String SPLASH_IMAGE =
            "http://fxexperience.com/wp-content/uploads/2010/06/logo.png";
	
	public static void main(String args[]) throws Exception {


		 // Take the path of the audio file from command line
		 File f = new File("/Users/naveen/Desktop/Test1/note2.wav");


		 // Create a Player object that realizes the audio
		 final Player p = Manager.createRealizedPlayer(f.toURI().toURL());


		  // Start the music
		  p.start();


		  // Create a Scanner object for taking input from cmd
		  Scanner s=new Scanner(System.in);


		  // Read a line and store it in st
		  String st=s.nextLine();


		   // If user types 's', stop the audio
		   if(st.equals("s"))
		   {
		   p.stop();
		   }
		 }
}
