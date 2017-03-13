package hr;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import ClassSource.Interview;
public class CvGuideLine extends JInternalFrame {

	
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
	private JPanel panel,panel1;
	Container con=getContentPane();
	private JLabel total,page,current;
	private JTable table;
	private JTextField tfSearch;
	private JButton btnSearch,btnNext,btnPrevious,btnFirst,btnLast;
	private Connection conn;
	private JScrollPane scrollPane,scr;
	private int count = 0,cont=0;
	private int rows=11;
	private DefaultTableModel model;
	private int totalrow,p;
	public void initForm(){
		setBounds(0,0,w,555);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
    	BasicInternalFrameUI basicInternalFrameUI = ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI());
    	for(MouseListener listener : basicInternalFrameUI.getNorthPane().getMouseListeners()){
    		basicInternalFrameUI.getNorthPane().removeMouseListener(listener);
    		} 
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		 setVisible(true);

		 findQuestion();
	}
	
    
    
	public void initControls(){
		 String[] columnNames = {"Question",
                 "Answer",
                 "Post Date"};

Object[][] data = {};
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));  
		tfSearch=new JTextField();
		tfSearch.setBounds(20,150,400,35);
		btnSearch=new JButton("");
		btnSearch.setIcon(new ImageIcon(getClass().getResource("search2.png")));
		btnSearch.setBounds(440,150,100,40);
		btnNext=new JButton("Next");
		btnNext.setBounds(370,640,100,30);
		btnPrevious=new JButton("Previous");
		btnPrevious.setBounds(250,640,100,30);
		btnFirst=new JButton("First");
		btnFirst.setBounds(130,640,100,30);
		btnLast=new JButton("Last");
		btnLast.setBounds(490,640,100,30);
		total=new JLabel();
		total.setBounds(620,640,250,30);
		page=new JLabel();
		page.setBounds(760,640,250,30);
		current=new JLabel();
		current.setBounds(880,640,250,30);
        table=new JTable(data,columnNames);
        scr=new JScrollPane(table);
        //scr.setBounds(5,200,w-45,480);
        scr.setBounds(5,200,  w-45, table.getRowHeight()*rows*2+70);
        scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        table.setRowHeight(10, 40);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(400);
        table.getColumnModel().getColumn(1).setPreferredWidth(710);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        panel1=new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setPreferredSize(new Dimension(640, 700));
        panel1.setLayout(null);
        panel1.add(tfSearch);
        panel1.add(btnSearch);
        panel1.add(btnLast);
        panel1.add(btnNext);
        panel1.add(btnPrevious);
        panel1.add(btnFirst);
       	panel1.add(scr);
       	panel1.add(total);
        panel1.add(page);
        panel1.add(current);
        panel.add(panel1);
       
     
        for (int i = 0; i < 2; i++) {
            panel.add(new JLabel(" "));
        }
      
        scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(5, 5, w-20, h-225);
       

        JPanel contentPane = new JPanel(null);
       // contentPane.setPreferredSize(new Dimension(400, 500));
        contentPane.add(scrollPane);
        con.add(contentPane);
       
	}
	public ArrayList<Interview> listUsers (String ValToString)
	{
		ArrayList<Interview> userList=new ArrayList<Interview>();
		Statement st;
		ResultSet rs;
		try{
			conn=(Connection) ClassSource.MySqlConnection.ConnectDB();
			st=(Statement) conn.createStatement();
			String query="Select Question,Answer,Date from `cv` where CONCAT(`Question`,`Answer`,`Date`) LIKE '%"+ ValToString +"%'";
			rs=st.executeQuery(query);
		    Interview view;
			while(rs.next()){
			view=new Interview(
					    rs.getString("Question"), 
						rs.getString("Answer"), 
						rs.getString("Date")
						);
			userList.add(view);
			}
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return userList;
		
	}
	public void findQuestion(){
		ArrayList<Interview> user=listUsers(tfSearch.getText());
		model=new DefaultTableModel(){
			 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
			    {
			      return false;//This causes all cells to be not editable
			    }
		};
		model.setColumnIdentifiers(new Object[]{"Question","Answer","Date"});
		Object[] row=new Object[3];
		for(int i=0;i<user.size();i++)
		{
			row[0]=user.get(i).Question();
			row[1]=user.get(i).Answer();
			row[2]=user.get(i).Date();
			model.addRow(row);
			
		}
		table.setRowHeight(40);
		//model.setRowCount(5);    
		table.setModel(model);
		totalrow=table.getRowCount();
		if(totalrow/10==0){
			p=(totalrow/10);
		}else{
			p=(totalrow/10)+1;
		}
		
		total.setText("Total Question: "+totalrow);
		page.setText("Total Page: "+p);
		current.setText("Current Page: "+0);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(400);
        table.getColumnModel().getColumn(1).setPreferredWidth(800);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        JTableHeader headerResumen = table.getTableHeader();
        headerResumen.setResizingAllowed(false);
        headerResumen.setReorderingAllowed(false);
	}
	public void initEvent(){
		btnSearch.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			findQuestion();
				
			}
			
		});
		btnNext.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				  int height = table.getRowHeight()*(rows-1);
                  JScrollBar bar = scr.getVerticalScrollBar();
                  bar.setValue( bar.getValue()+height );
				count++;
				cont++;
				if(cont<p){
				 current.setText("Current Page: "+cont);
				}else{
			     current.setText("Current Page: "+p);
			     cont=p;
				}
			}
			
		});
		btnPrevious.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                int height = table.getRowHeight()*(rows-1);
                JScrollBar bar = scr.getVerticalScrollBar();
                bar.setValue( bar.getValue()-height );
                cont--;
                if(cont>=1){
                current.setText("Current Page: "+cont);
                }
                else{
                	cont=0;
                current.setText("Current Page: "+0);
                }
            }
        } );
		btnFirst.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                int height = table.getRowHeight()*(rows-1);
                JScrollBar bar = scr.getVerticalScrollBar();
                bar.setValue( bar.getValue()-height*count );
                current.setText("Current Page: "+0);
            }
        } );
		btnLast.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                int height = table.getRowHeight()*(rows-1);
                JScrollBar bar = scr.getVerticalScrollBar();
                bar.setValue( bar.getValue()+height*100 );
                current.setText("Current Page: "+p);
                cont=p;
            }
        } );
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	  //MainMenu m=new MainMenu();
		   
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		            int index=table.getSelectedRow();
		            TableModel model=table.getModel();
		            String question=model.getValueAt(index, 0).toString();
		            String answer=model.getValueAt(index, 1).toString();
		          
		          
		            CvGuideLine c=new CvGuideLine(); 
		            Answer  a=new Answer();
					//m.dp.add(a);
					//a.show();
                    a.lbQ.setText(question);
                    //a.taA.setText(answer);
                    a.taA.setText(answer);;
                	c.setVisible(false);
                	//c.dispose();
		        }
		    }
		});
	}
	public  void scrollToVisible( int rowIndex, int vColIndex, JTable argtable){              
	    Component parent = argtable.getParent();
	    if (parent == null)
	        return;
	    if (!(parent instanceof JViewport)){
	        return;
	    }
	    JViewport viewport = (JViewport)parent;

	    // This rectangle is relative to the table where the
	    // northwest corner of cell (0,0) is always (0,0).
	    Rectangle rect = argtable.getCellRect(rowIndex, vColIndex, true);

	    // The location of the viewport relative to the table
	    Point pt = viewport.getViewPosition();

	    // Translate the cell location so that it is relative
	    // to the view, assuming the northwest corner of the
	    // view is (0,0)
	    rect.setLocation(rect.x-pt.x, rect.y-pt.y);

	    // Scroll the area into view
	    viewport.scrollRectToVisible(rect);
	}     

	public CvGuideLine(){
		
		initControls();
		initEvent();
		initForm();
	
	}
	public static void main(String[] args) {
		new CvGuideLine();
		
		
	}
	
}
