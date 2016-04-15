import javax.imageio.ImageIO;
import javax.media.*;
import java.net.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JWindow;

import com.sun.glass.events.KeyEvent;
import com.sun.glass.events.MouseEvent;

public class MusicPlayer extends JFrame {
	
	ArrayList<String> paths = new ArrayList<String>();
	ArrayList<File> songFiles = new ArrayList<File>();
	ArrayList<File> queueFiles = new ArrayList<File>();
	ArrayList<String> songs = new ArrayList<String>();
	ArrayList<String> artists = new ArrayList<String>();
	public BufferedImage image;
	public static String libraryFolder = "";
	
	public static final String SPLASH_IMAGE =
            "http://fxexperience.com/wp-content/uploads/2010/06/logo.png";
	
	public static void main(String args[]) throws Exception {
		MusicPlayer M = new MusicPlayer();
		
		 }
	public MusicPlayer() throws IOException, NoPlayerException, CannotRealizeException {
//		init();
//		start();
	}
	public void init() throws IOException {
		  image = ImageIO.read(new File("/Users/naveen/Desktop/splashImage.png"));
		  JLabel icon = new JLabel(new ImageIcon(image));
		  icon.setLayout(new FlowLayout(FlowLayout.CENTER));
		  
		  JWindow window = new JWindow();
		  window.setBackground(Color.white);
		  window.setSize(1000, 500);
		 
		  
		  
		  window.setBounds(150, 100, 1000, 500);
		  
		  JButton chooseLibrary = new JButton("Choose Library");
		    chooseLibrary.addActionListener(new ActionListener() {
		    	
			      public void actionPerformed(ActionEvent ae) {
			        JFileChooser fileChooser = new JFileChooser();
			        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			        
			        int returnValue = fileChooser.showOpenDialog(null);
			        if (returnValue == JFileChooser.APPROVE_OPTION) {
			          File selectedFile = fileChooser.getSelectedFile();
			          libraryFolder = selectedFile.getPath();
			         
			         
			          }
			        }
			      }
			    );
		  
		   
		  
		  
		  
		  icon.add(chooseLibrary);
		  window.getContentPane().add(icon);
		  window.setVisible(true);
		  chooseLibrary.setLocation(177, 215);
		  chooseLibrary.setSize(150, 50);
		  chooseLibrary.setVisible(true);
		  try {
		      Thread.sleep(1000);
		  } catch (InterruptedException e) {
		      e.printStackTrace();
		  }
		
		  window.setVisible(false);
		  window.dispose();
		
	      
	  }
	
	public void start () throws NoPlayerException, CannotRealizeException, MalformedURLException, IOException {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setTitle("DigiSplit");
		 setVisible(true);
		Container contentPane = getContentPane();
		JPanel quePanel = new JPanel();
		
		
		JTabbedPane pane = new JTabbedPane ();
//		pane.setSize(1000, 1000);
//		pane.setBackground(Color.white);
//		pane.setLayout(new BorderLayout());
//		pane.setVisible(true); 
		
		pane.addTab("search", null, contentPane,
                "Does nothing");
		pane.setMnemonicAt(0, KeyEvent.VK_1);
		
		quePanel.add(pane);
		
		JTextArea que =  new JTextArea(10, 10);
	    JTextField search = new JTextField(10);
	    
	    que.setSize(1000, 400);
	    que.setText("Song.....Artist");
	    search.setToolTipText("type here to search");
	    
	    
	    
	   
        JScrollPane scroll = new JScrollPane(que);
//        BufferedImage tabImage = ImageIO.read(new File("images/middle.gif"));
//        ImageIcon icon = createImageIcon(tabImage);

        search.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                
            	//SEARCH LIBRARY
            }
        });

        que.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
            	
//            	
//                int x = me.getX();
//                int y = me.getY();
//                System.out.println("X : " + x);
//                System.out.println("Y : " + y);
//                int startOffset = que.viewToModel(new Point(x, y));
//                System.out.println("Start Offset : " + startOffset);
//                String text = que.getText();
//                int searchLocation = text.indexOf("student://", startOffset);
//                System.out.println("Search Location : " + searchLocation);
//                if (searchLocation == startOffset)
//                    JOptionPane.showMessageDialog(MusicPlayer.this, "BINGO you found me.");
            	System.out.println("test");
            }
        });
        
        quePanel.setSize(1000, 500);
        quePanel.setBackground(Color.white);
        quePanel.add(scroll, BorderLayout.CENTER);
        quePanel.add(search, BorderLayout.PAGE_END);
        quePanel.setVisible(true);
        contentPane.add(quePanel);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
        
		
		/* // Take the path of the audio file from command line
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
		   */
		   
		  
		   
	}
	public void GetAllFiles(String directory) throws IOException {
		File f = new File(directory.toString()); // current directory

	    File[] files = f.listFiles();
	   
	    
	    for (File file : files) {
	    	
	    	
	    	int beginArtist = 0;
    		int endArtist = 0;
    		int beginSong = 0;
    		int endSong = 0;
	    	
	    	if (file.getCanonicalPath().toString().contains(".")) {
	    		
	    		String filepath = file.getCanonicalPath().toString();
	    		
	    		
	    		songFiles.add(file);
	    		paths.add(filepath);
	    		artists.add(file.getParentFile().getParentFile().getName());
	    		songs.add(file.getName());
	    		
	    	} else {
	    	
	    		GetAllFiles(file.getCanonicalPath().toString());
	    		}
	    	}
	    
	    }

}
