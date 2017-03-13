package hr;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class sco {
	public static void main(String[] args) {
	    Frame frame = new JFrame();  

	    JPanel panel = new JPanel();  
	    panel.setBackground(Color.BLUE);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));  

	    for(int i = 0; i < 20; i++) {  
	      panel.add(new JButton("Button " + i));  
	    } 

	    //Creating JScrollPane with JPanel
	    JScrollPane scrollPane = new JScrollPane(panel);
	    JPanel otherPanel = new JPanel();
	    otherPanel.setLayout(new BorderLayout());
	    //Adding scrollPane to panel
	    otherPanel.add(scrollPane);
	    frame.add(otherPanel);  

	    frame.setSize(200,200);  
	    frame.setVisible(true);     

	}
}
