package hr;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import ClassSource.MyPanel;

public class LoginForm extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	int w=(int)width/2;
	int h=(int)height;
	
    private MyPanel pan1,pan2,pan3,pan4;
    private JLabel lbLogin,lbLine,lbUser,lbPassword,lbSignUp,lbHere;
    private JTextField tfUser;
    private JPasswordField tfPassword;
    private JButton btnLogin,btnCancel,btnSignUp;
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    private JLabel lbLogin1,lbLine1,lbUser1,lbPassword1,lbSignUp1,lbHere1;
    private JTextField tfUser1;
    private JPasswordField tfPassword1;
    private JButton btnLogin1,btnCancel1,btnSignUp1;
    private JLabel help,label,locate;
    String address = "ypanha0619@gmail.com";
   
    Container con=getContentPane();
	public void initForm(){
		setTitle("Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	public void initControls(){
		con.setLayout(new BorderLayout());

		pan1=new MyPanel(w,300,Color.WHITE);
		pan1.setLayout(null);
		
		lbLogin=new JLabel("Job Seeker Login Form",JLabel.CENTER);
		lbLogin.setFont(new Font("Times New Roman",Font.BOLD,20));
		lbLogin.setBounds(200, 30,300, 40);
		lbLogin.setIcon(new ImageIcon(getClass().getResource("employ1.png")));
		lbLine=new JLabel("_________________________________________________________________________________________________");
	    lbLine.setBounds(0,60,w,20);
		lbLine.setBackground(Color.RED);
		lbUser=new JLabel(" Username");
		lbUser.setBounds(200,150,200,20);
		lbUser.setFont(new Font("Times New Roman",Font.BOLD,20));
		lbUser.setIcon(new ImageIcon(getClass().getResource("username.png")));
		tfUser=new JTextField();
		tfUser.setBounds(200,180,300,30);
		tfUser.setBackground(new Color(204,229,255));
		tfUser.setFont(new Font("Times New Roman",Font.PLAIN,17));
	    lbPassword=new JLabel(" Password");
	    lbPassword.setIcon(new ImageIcon(getClass().getResource("pass.png")));
	    lbPassword.setFont(new Font("Times New Roman",Font.BOLD,20));
	    lbPassword.setBounds(200,220,200,20);
	    tfPassword=new JPasswordField();
		tfPassword.setBounds(200,250,300,30);
		tfPassword.setBackground(new Color(204,229,255));
		tfPassword.setFont(new Font("Times New Roman",Font.PLAIN,17));
		btnLogin=new JButton("Login");
		btnLogin.setBounds(200,300,100,40);
		btnLogin.setFont(new Font("Times New Roman",Font.BOLD,16));
		btnLogin.setBackground(new Color(204,229,255));
		btnCancel=new JButton("Cancel");
		btnCancel.setBounds(320,300,100,40);
		btnCancel.setFont(new Font("Times New Roman",Font.BOLD,16));
		btnCancel.setBackground(new Color(204,229,255));
		lbSignUp=new JLabel("Don't have an account ! Please");
		lbSignUp.setFont(new Font("Times New Roman",Font.BOLD,17));
		lbSignUp.setBounds(200,360,280,20);
		String s="<html><u>Sign Up</u></html>";
		btnSignUp=new JButton(s);
		btnSignUp.setFont(new Font("Times New Roman",Font.BOLD,17));
		btnSignUp.setForeground(Color.BLUE);
		btnSignUp.setBounds(420,360,80,20);
		btnSignUp.setFocusPainted(false);
		btnSignUp.setMargin(new Insets(0,0,0,0));
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		
		//btnSignUp.setOpaque(false);
		lbHere=new JLabel("Here.");
		lbHere.setBounds(500,360,100,20);
		lbHere.setFont(new Font("Times New Roman",Font.BOLD,17));
		
		pan1.add(lbLogin);
		pan1.add(lbLine);
		pan1.add(lbUser);
		pan1.add(tfUser);
		pan1.add(lbPassword);
		pan1.add(tfPassword);
		pan1.add(btnLogin);
		pan1.add(btnCancel);
		pan1.add(lbSignUp);
		pan1.add(btnSignUp);
		pan1.add(lbHere);
		con.add(pan1,BorderLayout.WEST);
		
		pan2=new MyPanel(w,300,Color.WHITE);
		pan2.setLayout(null);
		
		lbLogin1=new JLabel("Employer Login Form",JLabel.CENTER);
		lbLogin1.setFont(new Font("Times New Roman",Font.BOLD,20));
		lbLogin1.setBounds(200, 30,300, 40);
		lbLogin1.setIcon(new ImageIcon(getClass().getResource("employer1.png")));
		lbLine1=new JLabel("_________________________________________________________________________________________________");
	    lbLine1.setBounds(0,60,w,20);
		lbLine1.setBackground(Color.RED);
		lbUser1=new JLabel(" Username");
		lbUser1.setBounds(200,150,200,20);
		lbUser1.setFont(new Font("Times New Roman",Font.BOLD,20));
		lbUser1.setIcon(new ImageIcon(getClass().getResource("username.png")));
		tfUser1=new JTextField();
		tfUser1.setBounds(200,180,300,30);
		tfUser1.setBackground(new Color(204,229,255));
		tfUser1.setFont(new Font("Times New Roman",Font.PLAIN,17));
	    lbPassword1=new JLabel(" Password");
	    lbPassword1.setIcon(new ImageIcon(getClass().getResource("pass.png")));
	    lbPassword1.setFont(new Font("Times New Roman",Font.BOLD,20));
	    lbPassword1.setBounds(200,220,200,20);
	    tfPassword1=new JPasswordField();
		tfPassword1.setBounds(200,250,300,30);
		tfPassword1.setBackground(new Color(204,229,255));
		tfPassword1.setFont(new Font("Times New Roman",Font.PLAIN,17));
		btnLogin1=new JButton("Login");
		btnLogin1.setBounds(200,300,100,40);
		btnLogin1.setFont(new Font("Times New Roman",Font.BOLD,16));
		btnLogin1.setBackground(new Color(204,229,255));
		btnCancel1=new JButton("Cancel");
		btnCancel1.setBounds(320,300,100,40);
		btnCancel1.setFont(new Font("Times New Roman",Font.BOLD,16));
		btnCancel1.setBackground(new Color(204,229,255));
		lbSignUp1=new JLabel("Don't have an account ! Please");
		lbSignUp1.setFont(new Font("Times New Roman",Font.BOLD,17));
		lbSignUp1.setBounds(200,360,280,20);
		String s1="<html><u>Sign Up</u></html>";
		btnSignUp1=new JButton(s1);
		btnSignUp1.setFont(new Font("Times New Roman",Font.BOLD,17));
		btnSignUp1.setForeground(Color.BLUE);
		btnSignUp1.setBounds(420,360,80,20);
		btnSignUp1.setFocusPainted(false);
		btnSignUp1.setMargin(new Insets(0,0,0,0));
		btnSignUp1.setContentAreaFilled(false);
		btnSignUp1.setBorderPainted(false);
		
		//btnSignUp.setOpaque(false);
		lbHere1=new JLabel("Here.");
		lbHere1.setBounds(500,360,100,20);
		lbHere1.setFont(new Font("Times New Roman",Font.BOLD,17));
		
		pan2.add(lbLogin1);
		pan2.add(lbLine1);
		pan2.add(lbUser1);
		pan2.add(tfUser1);
		pan2.add(lbPassword1);
		pan2.add(tfPassword1);
		pan2.add(btnLogin1);
		pan2.add(btnCancel1);
		pan2.add(lbSignUp1);
		pan2.add(btnSignUp1);
		pan2.add(lbHere1);
		con.add(pan2,BorderLayout.EAST);
		
		pan3=new MyPanel(w*2,100,new Color(204,229,255));
		con.add(pan3,BorderLayout.NORTH);
		pan4=new MyPanel(w*2,100,new Color(204,229,255));
		pan4.setLayout(null);
		

		label = new JLabel("<html><br><font size=4><a href=#>" + address + "</a></font></html>");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    label.setBounds(800,10,200,40);
		help=new JLabel("If you have any problems with login please contact this "
                   +    "Tel : 855(0) 71 451 2313 or Email:");
	    help.setBounds(300,30,500,20);
	    locate=new JLabel("Russian Federation Boulevard, Toul Kork, Phnom Penh, Cambodia");
	    locate.setBounds(450,60,400,20);
		pan4.add(help);
		pan4.add(label);
		pan4.add(locate);
		con.add(pan4,BorderLayout.SOUTH);
		
	}
	public void initEvent(){
		btnSignUp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			    SignUpSeeker main=new SignUpSeeker();
				main.setVisible(true);
			}
		});
		btnSignUp.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSignUp.setForeground(Color.BLACK);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSignUp.setForeground(Color.BLUE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {	
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}	
		});
		btnSignUp1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				SignUpEmployer main=new SignUpEmployer();
				main.setVisible(true);	
			}
		});
		btnSignUp1.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSignUp1.setForeground(Color.BLACK);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSignUp1.setForeground(Color.BLUE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {	
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}	
		});
		btnLogin.addActionListener(new ActionListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
			conn=ClassSource.MySqlConnection.ConnectDB();
			String sql="select * from seeker where username=? and password=?";
			try{
				pst=conn.prepareStatement(sql);
				pst.setString(1,tfUser.getText());
				pst.setString(2,tfPassword.getText());
				rs=pst.executeQuery();
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "Login");
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong Username/Password");
				}
			}catch(Exception e){
				
			}
				
			}
			
		});
		btnLogin1.addActionListener(new ActionListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
			conn=ClassSource.MySqlConnection.ConnectDB();
			String sql="select * from employer where username=? and password=?";
			try{
				pst=conn.prepareStatement(sql);
				pst.setString(1,tfUser1.getText());
				pst.setString(2,tfPassword1.getText());
				rs=pst.executeQuery();
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "Login");
				}
				else{
					JOptionPane.showMessageDialog(null, "Wrong Username/Password");
				}
			}catch(Exception e){
				
			}
				
			}
			
		});
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		btnCancel1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		label.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            Desktop.getDesktop().mail(new URI("mailto:" + address + "?subject=Hello"));
		        } catch (URISyntaxException | IOException ex) {
		            // ...
		        }
		    }
		});
			}
	public LoginForm(){
		initControls();
		initEvent();
		initForm();
	}
	public static void main(String[] args) {
		new LoginForm();

	}

}
