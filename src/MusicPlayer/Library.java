package MusicPlayer;
import java.awt.FlowLayout;
import MusicPlayer.GUI;
import MusicPlayer.Queue;
import javafx.application.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class Library {
	public Queue AllSongs = new Queue(20);
	public Queue AllDirectories  = new Queue(20);
	public String path;
	private Queue SongQue = new Queue(20);
	private Queue PathQue = new Queue(10);
	public GUI g = new GUI();
	public Library l = new Library();
	
	
	public Library() {
		
	}
	public void Lib(String song){
		
	}
	public void GetAllFiles(String directory) throws IOException {
		File f = new File(directory.toString()); // current directory

	    File[] files = f.listFiles();
	    for (File file : files) {
	    	if (file.getCanonicalPath().toString().contains(".")) {
	    		AllSongs.push(file.getCanonicalPath().toString());
	    		System.out.println("File: " + file.getCanonicalPath().toString());
	    	} else {
	    		AllDirectories.push(file.getCanonicalPath().toString());
	    		System.out.println("Directory: " + file.getCanonicalPath().toString());
	    		GetAllFiles(file.getCanonicalPath().toString());
	    		}
	    	}
	    
	    l.PlayQue();
	    }
	
	public void PlayQue() {
		
		 
		
//		try {
//		    Thread.sleep(1000);                 //1000 milliseconds is one second.
//		} catch(InterruptedException ex) {
//		    Thread.currentThread().interrupt();
//		}
		
		
		g.test();
		g.playQue("/Users/naveen/Desktop/Test1/note2.wav");
		
		
		
		
		for (int i = 0; i < AllSongs.stackSize; i++) {
			g.playQue(AllSongs.peek());
			
			try {
				TimeUnit.MINUTES.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public String FileChooser() {
		 JFrame.setDefaultLookAndFeelDecorated(true);
		    JDialog.setDefaultLookAndFeelDecorated(true);
		    JFrame frame = new JFrame("JComboBox Test");
		    frame.setLayout(new FlowLayout());
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    JButton button = new JButton("Select File");
		    button.addActionListener(new ActionListener() {
		    	
		      public void actionPerformed(ActionEvent ae) {
		        JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		        
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		          path = selectedFile.getPath();
		          PathQue.push(path);
		         
		         
		          }
		        }
		      }
		    );
		    frame.add(button);
		    frame.pack();
		    frame.setVisible(true);
		    PathQue.displayTheStack();
		    System.out.println(path);
		    
		    try {
				GetAllFiles(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    return path;
		    }
	
	 
	public static void main(String [] args) throws IOException{
		GUI g = new GUI();
		
		
		
		
		Library l = new Library();
		
		
		//String s = l.FileChooser();
		//l.FileChooser();
		
		g.launch(g.getClass());
		//l.GetAllFiles("/Users/naveen/Desktop/Test1");
		//"/Users/naveen/Desktop/Test1"
		l.PlayQue();
		
	}
}