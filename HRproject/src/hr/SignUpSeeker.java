package hr;
import javax.swing.*;

import com.mysql.jdbc.Statement;

import ClassSource.MyPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Arrays;

public class SignUpSeeker extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	int w=(int)width;
	int h=(int)height;
	private MyPanel pan1,pan2,pan3,pan4,pan;
	private JTextField tfFirstname,tfLastname,tfEmail,tfUsername;
	private JPasswordField tfPassword,tfRepassword;
	private JLabel lbShow,lbLine,lbFirstname,lbLastname,lbEmail,lbUsername,lbPassword,lbRepassword;
	private JButton btnRegister,btnCancel;
	private JCheckBox chOk;
	Container con=getContentPane();
	Font fo= new Font("ARIAL",Font.PLAIN,12);
	Connection conn;
	
	
	public void initForm(){
		setTitle("Sign Up for Seeker");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		
	}
	public void initControls(){
		con.setLayout(new BorderLayout());
		pan1=new MyPanel(w,150,new Color(204,229,255));
		con.add(pan1,BorderLayout.NORTH);
		pan2=new MyPanel(w,50,new Color(204,229,255));
		con.add(pan2,BorderLayout.SOUTH);
		pan3=new MyPanel(300,h,new Color(204,229,255));
		con.add(pan3,BorderLayout.WEST);
		pan4=new MyPanel(300,h,new Color(204,229,255));
		con.add(pan4,BorderLayout.EAST);
		pan=new MyPanel(0,0,Color.WHITE);
		pan.setLayout(null);
		lbShow=new JLabel("Sign Up new Job Seeker");
		lbShow.setFont(new Font("Times New Roman",Font.BOLD,20));
		lbShow.setBounds(290,20,300,20);
		pan.add(lbShow);
		lbLine=new JLabel("____________________________________________________________________________________________________________________________");
		lbLine.setBounds(0,50,w,20);
		pan.add(lbLine);
		lbFirstname=new JLabel("First Name");
		lbFirstname.setBounds(150,100,150,20);
		pan.add(lbFirstname);
		tfFirstname=new JTextField();
		tfFirstname.setBounds(300,100,300,30);
		tfFirstname.setBackground(new Color(204,229,255));
		pan.add(tfFirstname);
		lbLastname=new JLabel("Last Name");
		lbLastname.setBounds(150,140,150,20);
		pan.add(lbLastname);
		tfLastname=new JTextField();
		tfLastname.setBounds(300,140,300,30);
		tfLastname.setBackground(new Color(204,229,255));
		pan.add(tfLastname);
		lbEmail=new JLabel("Email");
		lbEmail.setBounds(150,180,150,20);
		pan.add(lbEmail);
		tfEmail=new JTextField();
		tfEmail.setBounds(300,180,300,30);
		tfEmail.setBackground(new Color(204,229,255));
		pan.add(tfEmail);
		lbUsername=new JLabel("Username");
		lbUsername.setBounds(150,220,150,20);
		pan.add(lbUsername);
		tfUsername=new JTextField();
		tfUsername.setBounds(300,220,300,30);
		tfUsername.setBackground(new Color(204,229,255));
		pan.add(tfUsername);
		lbPassword=new JLabel("Password");
		lbPassword.setBounds(150,260,150,20);
		pan.add(lbPassword);
		tfPassword=new JPasswordField();
		tfPassword.setBounds(300,260,300,30);
		tfPassword.setBackground(new Color(204,229,255));
		pan.add(tfPassword);
		lbRepassword=new JLabel("Re-Password");
		lbRepassword.setBounds(150,300,150,20);
		pan.add(lbRepassword);
		tfRepassword=new JPasswordField();
		tfRepassword.setBounds(300,300,300,30);
		tfRepassword.setBackground(new Color(204,229,255));
		pan.add(tfRepassword);
		chOk=new JCheckBox(" I have read and agreed to the Terms of Service.");
		chOk.setBounds(200,340,300,20);
		chOk.setBackground(Color.WHITE);
		pan.add(chOk);
		btnRegister=new JButton("Register");
		btnRegister.setBounds(200,400,150,30);
		btnRegister.setBackground(new Color(204,229,255));
		btnRegister.setEnabled(false);
		pan.add(btnRegister);
		btnCancel=new JButton("Cancel");
		btnCancel.setBounds(370,400,150,30);
		btnCancel.setBackground(new Color(204,229,255));
		pan.add(btnCancel);
		
		con.add(pan,BorderLayout.CENTER);
	}
	public void initEvent(){
		tfPassword.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {  
				tfPassword.setFont(fo);
				 tfPassword.setEchoChar((char) 0);	
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				tfPassword.setFont(fo);
				 tfPassword.setEchoChar('●');
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				tfPassword.setFont(fo);
				 tfPassword.setEchoChar('●');
			}
		});
		
		btnCancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				  dispose();
				  LoginForm lf=new LoginForm();
				  lf.setVisible(true);	  
			}	
		});
		
		chOk.addActionListener(new ActionListener(){
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chOk.isSelected()){
					char[] password=tfPassword.getPassword();
					char[] repassword=tfRepassword.getPassword();
					btnRegister.setEnabled(true);
					if(tfFirstname.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Please Input Firstname");
						//btnRegister.setEnabled(false);
						chOk.setSelected(false);
					}
					else if(tfLastname.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Please Input Lastname");
						//btnRegister.setEnabled(false);
						chOk.setSelected(false);
						
					}
					else if(tfEmail.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Please Input Email");
						//btnRegister.setEnabled(false);
						chOk.setSelected(false);
					}
					else if(tfUsername.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Please Input Username");
						btnRegister.setEnabled(false);
						chOk.setSelected(false);
					}
					else if(tfPassword.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Please Input Password");
					    btnRegister.setEnabled(false);
					    chOk.setSelected(false);
					}
					else if(tfPassword.getText().length()<=6){
						JOptionPane.showMessageDialog(null,"Password must bigger than 6");
					    btnRegister.setEnabled(false);
					    chOk.setSelected(false);
					}
					else if(tfRepassword.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Please Input Re-Password");
						//btnRegister.setEnabled(false);
						chOk.setSelected(false);
					}
					else if(!Arrays.equals(password, repassword)){
						JOptionPane.showMessageDialog(null,"Please check again");
						chOk.setSelected(false);
					}
					else{
						btnRegister.setEnabled(true);
					   
				 }
				}
				else{
					btnRegister.setEnabled(false);
				}
			}
		});
		 btnRegister.addActionListener(new ActionListener(){
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) {
			try{
				
				String sql1="SELECT * FROM seeker WHERE username='"+tfUsername.getText()+"' ";
				String sql2="INSERT INTO seeker (first_name,last_name,email,username,password) VALUES(?,?,?,?,?)";
				conn=ClassSource.MySqlConnection.ConnectDB();
				Statement st=(Statement) conn.createStatement();
				ResultSet res=st.executeQuery(sql1);
				if(res.next()){
					if(res.getString("username").equalsIgnoreCase(tfUsername.getText())){
						JOptionPane.showMessageDialog(null," The Password is already register.");
					}
				}else{
					PreparedStatement resPre=conn.prepareStatement(sql2);
					resPre.setString(1, tfFirstname.getText());
					resPre.setString(2, tfLastname.getText());
					resPre.setString(3, tfEmail.getText());
					resPre.setString(4, tfUsername.getText());
					resPre.setString(5, tfPassword.getText());
					resPre.executeUpdate();
					JOptionPane.showMessageDialog(null, "Register Firstname : "+tfFirstname.getText()+" Successfull.");
				}
				res.close();
				st.close();
				conn.close();
				
				
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
	});
		 
	}
	public SignUpSeeker(){
		initControls();
		initEvent();
		initForm();
	}
	public static void main(String[] args) {
		new SignUpSeeker();
	}

}
