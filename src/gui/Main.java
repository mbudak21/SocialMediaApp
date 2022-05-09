package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import api.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User("mbudak21","Bjh310hyy","Mehmet Murat", "Budak", "mbudak21@ku.edu.tr", 18);
		User user2 = new User("gabechu","1234","Ahmet", "Zade", "aasddwq@ku.edu.tr", 22);
		User user3 = new User("hasan","1111","hasan123", "Celik", "aaaaaa@asd.com", 55);
		JFrame frame = new MainFrame();
		LoginPanel LoginPane = new LoginPanel();
		frame.add(LoginPane);
		LoginPane.setVisible(true);
		frame.setVisible(true);
	

		
		
		
	}	

}
