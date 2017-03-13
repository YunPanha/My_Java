package FormHr;
import javax.swing.*;

import ClassSource.MyPanel;
import java.awt.*;

public class LoginForm extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container con=getContentPane();
	
	private JMenuBar menuBar;
	private JMenu home,findajob,jobwanted,cv,about,help;
	JPanel containe=new JPanel();
    public void initControls(){
      MyPanel panel1,panel2;
      panel1=new MyPanel(100,200,new Color(102,255,255));
      panel2=new MyPanel(100,200,Color.WHITE);
      con.setLayout(new BorderLayout());
      con.add(panel1,BorderLayout.NORTH);
      con.add(panel2,BorderLayout.CENTER);
    	
      menuBar=new JMenuBar();
      menuBar.setBackground(new Color(102,255,255));
      findajob   =new JMenu("Find a job                            ");
      jobwanted  =new JMenu("Job wanted                            ");
      home       =new JMenu("Home                                  ",true);
      cv         =new JMenu("CV- Guideline                         ");
      help       =new JMenu("Help                                  ");
      about      =new JMenu("About                                 ");
      home.setIcon(new ImageIcon(getClass().getResource("home.png")));
      menuBar.add(home);
      menuBar.add(findajob);
      menuBar.add(jobwanted);
      menuBar.add(cv);
      menuBar.add(about);
      menuBar.add(help);
      
      panel1.setLayout(new BorderLayout());
      panel1.add(menuBar,BorderLayout.SOUTH);
      
     
     
    }
    public void initForm(){
    	setTitle("Login");
    	setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    public void initEvent(){
    	
    }
    public LoginForm(){
 
    	initControls();
    	initForm();
    	
    	
    }
	public static void main(String[] args) {
		new LoginForm();
	}

 }
