package gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

@SuppressWarnings({ "serial" })
public class MyFrame extends JFrame {
	
	
	MyFrame(){
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		setLayout(new GridBagLayout());
		this.setMinimumSize(new Dimension(350, 240));
		
		
		
		
	}
	
	
//	public void startLoginPane() {
//		
//	}


}
