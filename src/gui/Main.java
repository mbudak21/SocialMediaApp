package gui;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new MyFrame();
		LoginPane LoginPane = new LoginPane();
		frame.add(LoginPane);
		LoginPane.setVisible(true);
		frame.setVisible(true);
		
	}	

}
