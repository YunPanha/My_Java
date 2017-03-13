package ClassSource;
import javax.swing.*;
import java.awt.*;
public class MyPanel extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public MyPanel(int width,int height,Color c){
	this.setBackground(c);
Dimension dimension=new Dimension(width,height);
this.setPreferredSize(dimension);
}
}
