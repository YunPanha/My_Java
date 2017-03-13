package hr;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
public class Answer extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height=screenSize.getHeight();
	int w=(int)width;
	int h=(int)height;
	private JPanel panel1,panel2,panel3;
	Container con=getContentPane();
	public JTextPane taA;
	public JLabel lbQ;
	public void initForm(){
		//setBounds(0,0,w,560);
		
		setTitle("Sign Up for Employer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	/*BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
    	for(MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()){
    		basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
    		} 
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		 */
	}
	public void initControls(){
		con.setLayout(null);
		panel1=new JPanel();
		panel1.setBounds(0,0 , w, 650);
		panel1.setBackground(new Color(204,229,255));
		panel2=new JPanel();
		panel2.setBounds(0, 650, w, 80);
		panel2.setBackground(new Color(204,229,255));
		panel1.setLayout(null);
		panel3=new JPanel();
		panel3.setBackground(Color.BLACK);
		panel3.setBounds(0,100,w,8);
		panel1.add(panel3);
		lbQ=new JLabel("");
		lbQ.setBounds(300,40,1000,40);
		lbQ.setFont(new Font("Times New Roman",Font.BOLD,30));
		panel1.add(lbQ);
		
		taA=new JTextPane();
		StyledDocument doc = taA.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	    taA.setFont(new Font("Times New Roman",Font.BOLD,15));
		JScrollPane scr=new JScrollPane(taA);
		scr.setBounds(100,110,1150,540);
		panel1.add(scr);
		con.add(panel1);
		con.add(panel2);
		
		
	}
	public void initEvent(){
		taA.addFocusListener(new FocusListener() {

	        @Override
	        public void focusLost(FocusEvent e) {
	            taA.setEditable(true);

	        }

	        @Override
	        public void focusGained(FocusEvent e) {
	            taA.setEditable(false);

	        }
	    });
	}
	public Answer(){
		initControls();
		initEvent();
		initForm();
	}
	public static void main(String[] args) {
        new Answer();		

	}

}
