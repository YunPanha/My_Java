package hr;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class HomeForm extends JInternalFrame {

	
	/**
	 * 
	 */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	int w=(int)width;
	int h=(int)height;
	private static final long serialVersionUID = 1L;
	 JInternalFrame frame = new JInternalFrame();
	private JPanel panel,otherPanel;
	Container con=getContentPane();
	
	 
	public void initForm(){
		setBounds(0,0,w,560);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    	BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
    	for(MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()){
    		basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
    		} 
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		 

	}
	public void initControls(){
		    panel = new JPanel();  
		    panel.setBackground(Color.BLUE);
		    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));  

		    for(int i = 0; i < 40; i++) {  
		      panel.add(new JButton("Button " + i));  
		    } 

		   
		    JScrollPane scrollPane = new JScrollPane(panel);
		    otherPanel = new JPanel();
		    otherPanel.setLayout(new BorderLayout());
		    //Adding scrollPane to panel
		    otherPanel.add(scrollPane);
		    con.add(otherPanel);
		   
	}
	public void initEvent(){
		
	}
	public HomeForm(){
		initControls();
		initEvent();
		initForm();
	
	}
	public static void main(String[] args) {
		new HomeForm();
		
		
	}

}
