package MusicPlayer;
import MusicPlayer.Library;
import MusicPlayer.Queue;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.omg.Messaging.SyncScopeHelper;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuBarBuilder;
import javafx.scene.control.MenuBuilder;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.Slider;
import javafx.scene.control.SliderBuilder;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextBuilder;
import javafx.stage.FileChooser;
import javafx.stage.FileChooserBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GUI extends Application {
	public JTextArea que = new JTextArea("TEST test test test tkajsdhflkjsdfhlksjahflkajshdakweufhzdkjfhlksgajkhfwdklgnrglfflkasjdfh test");
	
	JFrame f = new JFrame ("Test");
	JScrollPane scroll = new JScrollPane (que, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	JButton chooseButton = new JButton("Choose");
	
		
	
	 	private String name;
	    private Audio audio;
	    private Text nowPlayingText;
	    private Slider playbackSlider;
	    private JTextArea queDisplay;
	    private JFrame frame;
	    private Library library;
	    public Queue AllSongs = new Queue(20);
		public Queue AllDirectories  = new Queue(20);
		public String path;
		private Queue SongQue = new Queue(20);
		private Queue PathQue = new Queue(10);
	    public boolean running = false;
	    public Library l = new Library();
	
//		public GUI () {
//			GUI.launch(GUI.class);
//		}
	 public void start(Stage stage) {
		
		 running = true;
		// playQue("/Users/naveen/Desktop/Test1/note2.wav");
		 
//		 File file = new File("/Users/naveen/Desktop/Test1/note2.wav");
//	    	if(file != null) {
//	            name = file.getName();
//	            audio = AudioFactory.getInstance().getAudio(file);
//	            playbackSlider.setValue(0);
//	            if(audio != null) {
//	                playbackSlider.setMax(audio.getTotalSecs());
//	                
//	            } else {
//	                playbackSlider.setMax(0);
//	            }
//	    	}
	            
         final SwingNode swingNode = new SwingNode();
         createAndSetSwingContent(swingNode);
         
         
       

         Pane pane = new Pane();
         pane.getChildren().add(swingNode); // Adding swing node
         
          

         chooseButton.setVisible(true);
         chooseButton.setLocation(0, 0);
        


         stage.setScene(new Scene(pane, 200, 100));
         stage.show();
         
         
         // Create now playing text
         nowPlayingText = TextBuilder.create()
                 .textAlignment(TextAlignment.CENTER)
                 .build();

         // Create the playback slider
         playbackSlider = SliderBuilder.create()
                 .min(0)
                 .max(0)
                 .majorTickUnit(60)
                 .minorTickCount(12)
                 .blockIncrement(5)
                 .snapToTicks(true)
                 .build();
         
      
         		//.setX()
         
        JScrollPane scroll = new JScrollPane (queDisplay, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
     	queDisplay.setRows(5);

         // Create the buttons
         Button playButton = ButtonBuilder.create()
                 .text("Play")
                 .onAction(new EventHandler<ActionEvent>() {
                     @Override
                     public void handle(ActionEvent actionEvent) {
                         if(audio != null) {
                             audio.play();
                         }
                     }
                 })
                 .build();
         Button pauseButton = ButtonBuilder.create()
                 .text("Pause")
                 .onAction(new EventHandler<ActionEvent>() {
                     @Override
                     public void handle(ActionEvent actionEvent) {
                         if(audio != null) {
                             audio.pause();
                         }
                     }
                 })
                 .build();

         // Create the menu items
         
         MenuItem openItem = MenuItemBuilder.create()
                 .text("Open")
                 .accelerator(new KeyCodeCombination(
                         KeyCode.O, KeyCombination.CONTROL_DOWN))
                 .onAction(new EventHandler<ActionEvent>() {
                     private final FileChooser chooser = FileChooserBuilder.create()
                             .title("Open Music File")
                             .extensionFilters(
                                     new FileChooser.ExtensionFilter(
                                             "Music files (*.wav, *.aiff, *.au)",
                                             "*.wav", "*.wave",
                                             "*.aiff", "*.aif",
                                             "*.au", "*.snd"))
                             .initialDirectory(
                                     new File(System.getProperty("user.home")))
                             .build();

                     @Override
                     public void handle(ActionEvent actionEvent) {
                         File file = new File("/Users/naveen/Desktop/Test1");
                         if(file != null) {
                             name = file.getName();
                             audio = AudioFactory.getInstance().getAudio(file);
                             playbackSlider.setValue(0);
                             if(audio != null) {
                                 playbackSlider.setMax(audio.getTotalSecs());
                             } else {
                                 playbackSlider.setMax(0);
                             }
                         }
                     }
                 })
                 .build();
     

         // Create the menus
      
 
         // Set up the scene
         MenuBar menuBar = MenuBarBuilder.create().menus().build();
         VBox buttons = VBoxBuilder.create()
                 .alignment(Pos.CENTER)
                 .children(nowPlayingText, playbackSlider, playButton, pauseButton)
                 .spacing(10)
                 .build();
         StackPane main = StackPaneBuilder.create()
                 .padding(new Insets(20))
                 .children(menuBar, buttons)
                 .build();
         VBox root = VBoxBuilder.create().children(menuBar, main, pane).build();
         stage.setScene(new Scene(root, 1200, 1000));
         stage.setX(0);
         stage.setY(0);

         // Show the window
         stage.show();
        
         
        // l.FileChooser();
         
         
         // Get the periodic update going
         Timeline timeline = TimelineBuilder.create()
                 .cycleCount(Timeline.INDEFINITE)
                 .keyFrames(
                         new KeyFrame(
                                 Duration.seconds(1),
                                 new EventHandler<ActionEvent>() {
                                     @Override
                                     public void handle(ActionEvent actionEvent) {
                                         update();
                                     }
                                 }))
                 .build();
         timeline.playFromStart();
     }
	  
	 private void update() {
	        if(audio != null) {
	            nowPlayingText.setText(String.format(
	                    "Playing '%s' - %s / %s",
	                    name,
	                    formatSecs(audio.getCurrentSecs()),
	                    formatSecs(audio.getTotalSecs())));
	            playbackSlider.setValue(audio.getCurrentSecs());
	        } else {
	            nowPlayingText.setText("No music loaded");
	        }
	    }
	 private String formatSecs(long secs) {
	        return String.format("%d:%02d", secs / 60, secs % 60);
	    }

     private void createAndSetSwingContent(final SwingNode swingNode) {
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 JPanel panel = new JPanel();
                 panel.add(scroll);
                 panel.add(chooseButton);
                 scroll.setBackground(Color.black);
                 scroll.setSize(200, 100);
                 scroll.setBounds(0, 50, 200, 20);
                 scroll.setVisible(true);
                 que.setVisible(true);
                 que.setBounds(0, 50, 200, 20);
                 swingNode.setContent(panel);
                 
             }
         });
     }
     
     
    public void playQue(String filepath) {
    	
    	File file = new File(filepath);
    	if(file != null) {
            name = file.getName();
            audio = AudioFactory.getInstance().getAudio(file);
            playbackSlider.setValue(0);
            if(audio != null) {
                playbackSlider.setMax(audio.getTotalSecs());
                
            } else {
                playbackSlider.setMax(0);
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
		        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		          path = selectedFile.getPath();
		          PathQue.push(path);
		         
		         
		          }
		        }

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		      }
		    );
		    frame.add(button);
		    frame.pack();
		    frame.setVisible(true);
		    PathQue.displayTheStack();
		    System.out.println(path);
		    /*
		    try {
				GetAllFiles(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		    return path;
    }
		    
    public static void main (String[] args) {
    	launch(args);
    }
    
}