package gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

@SuppressWarnings({ "serial" })
public class MainFrame extends JFrame {
	
	
	MainFrame(){
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(416, 379);
		this.setBounds(750, 350, 416, 339);
		setLayout(new GridBagLayout());
		this.setMinimumSize(new Dimension(416, 339));
		

		
		
		
		
	}
	
	
//	public void startLoginPane() {
//		
//	}


}
