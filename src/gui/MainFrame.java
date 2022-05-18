package gui;

import java.awt.Dimension;

import javax.swing.JFrame;


@SuppressWarnings({ "serial" })
public class MainFrame extends JFrame {
	
	
	public MainFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setSize(416, 379);


		
//		MainPagePanel MainPagePanel = new MainPagePanel(null, user1);
//		add(MainPagePanel);
//		MainPagePanel.setVisible(true);
		
//		setVisible(true);
		startLoginPane();
	}
	
	
	public void startLoginPane() {
		this.setBounds(750, 350, 416, 339);
		this.setMinimumSize(new Dimension(416, 339));
		LoginPanel LoginPane = new LoginPanel();
		getContentPane().add(LoginPane);
		LoginPane.setVisible(true);
	}


	
	

}
