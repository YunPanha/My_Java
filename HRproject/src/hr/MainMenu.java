package hr;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
public class MainMenu extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JPanel p;
	private JLabel img;
	private ImageIcon icon;
	public JDesktopPane dp;
	private JMenu home,findajob,jobwanted,cv,about,help;
	private  JMenuItem item,item1;
	HomeForm f;
	CvGuideLine c;
	Container con=getContentPane();
    Answer a;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	int w=(int)width;
	int h=(int)height;
	
	
    public void initForm(){
    	//setSize(300,300);
    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setVisible(true);
    }
    public void initControls(){
    	con.setLayout(null);
        p=new JPanel();
        p.setBounds(0, 0,w , 150);
        p.setBackground(new Color(204,229,255));
        p.setLayout(new BorderLayout());
        dp=new JDesktopPane();
        dp.setBounds(0, 150, w,600);

        icon=new ImageIcon(getClass().getResource("image2.png"));
        img=new JLabel();
        img.setIcon(icon);
      
    	menuBar=new JMenuBar();
    	menuBar.setBackground(new Color(204,229,255));
         findajob   =new JMenu("Find a job                            ");
         jobwanted  =new JMenu("Job wanted                            ");
         home       =new JMenu("Home                                  ");
         cv         =new JMenu("CV- Guideline                         ");
         help       =new JMenu("Help                                  ");
         about      =new JMenu("About                                 ");
    	home.setIcon(new ImageIcon(getClass().getResource("home.png")));
    	findajob.setIcon(new ImageIcon(getClass().getResource("search.png")));
    	jobwanted.setIcon(new ImageIcon(getClass().getResource("profile.png")));
    	cv.setIcon(new ImageIcon(getClass().getResource("cv.png")));
    	about.setIcon(new ImageIcon(getClass().getResource("about.png")));
    	help.setIcon(new ImageIcon(getClass().getResource("help.png")));
    	 menuBar.add(home);
         menuBar.add(findajob);
         menuBar.add(jobwanted);
         menuBar.add(cv);
         item=new JMenuItem("CV & Cover Letters");
         item1=new JMenuItem("CV Samples");
         cv.add(item);
         cv.add(item1);
         menuBar.add(about);
         menuBar.add(help);
    	 p.add(img,BorderLayout.CENTER);
    	 p.add(menuBar,BorderLayout.SOUTH);
     
    	con.add(p);
    	con.add(dp);
    	
    	
    	
    }
    public void initEvent(){
    	home.addMenuListener(new MenuListener(){

			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuSelected(MenuEvent e) {
				if(a==null){
				    a=new Answer();
					dp.add(a);
					a.setVisible(true);
	
			}
    		
			}});	
    	item.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			    
				    c=new CvGuideLine();
					dp.add(c);
					c.show();
					a.setVisible(false);
				
			}});
    	item1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				    a=new Answer();
					dp.add(a);
					//a.show();;
					c.setVisible(false);
		
			}});
    }
    public MainMenu(){
    	
    	initControls();
    	initEvent();
    	initForm();
    }
	public static void main(String[] args) {
		new MainMenu();
	}
	

}
