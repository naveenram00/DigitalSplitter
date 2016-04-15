import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
 
public class Player extends JPanel {
	
    public Player() throws NoPlayerException, CannotRealizeException, IOException {
        super(new GridLayout(1, 1));
       
         
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");
         
        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Tab 1", icon, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2", icon, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", icon, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
         
        JComponent panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Tab 4", icon, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        JTextArea que =  new JTextArea(10, 10);
	    JTextField search = new JTextField(10);
	    
	    que.setSize(1000, 400);
	    que.setText("Song.....Artist");
	    search.setToolTipText("type here to search");
	    
	    MusicPlayer mp = new MusicPlayer();
	    mp.GetAllFiles("/Users/naveen/Music/iTunes/iTunes Media/Music");
		  System.out.println(mp.songs.get(2));
		  System.out.println(mp.artists.get(2));
	  
	   
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
            	
            	 System.out.println(me);
            	
                int x = me.getX();
                int y = me.getY();
                System.out.println("X : " + x);
                System.out.println("Y : " + y);
                int startOffset = que.viewToModel(new Point(x, y));
                System.out.println("Start Offset : " + startOffset);
                String text = que.getText();
                int searchLocation = text.indexOf("student://", startOffset);
                System.out.println("Search Location : " + searchLocation);
                if (searchLocation == startOffset)
                    JOptionPane.showMessageDialog(null, "BINGO you found me.");
            	System.out.println("test");
            }
        });
        
        // Set size
        search.setSize(200, 10);
        
        // Add components to tabs
        
        panel1.add(scroll, BorderLayout.CENTER);
        panel1.add(search, BorderLayout.SOUTH);
        
        
        //Add the tabbed pane to this panel.
        add(tabbedPane);
         
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
     
    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
     
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Player.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     * @throws IOException 
     * @throws CannotRealizeException 
     * @throws NoPlayerException 
     */
    private static void createAndShowGUI() throws NoPlayerException, CannotRealizeException, IOException {
        //Create and set up the window.
        JFrame frame = new JFrame("Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(new Player(), BorderLayout.CENTER);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        try {
			createAndShowGUI();
		} catch (NoPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotRealizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            }
        });
    }
}