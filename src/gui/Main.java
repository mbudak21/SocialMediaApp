package gui;

import javax.swing.ImageIcon;

import api.User;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		User user1 = new User("mbudak21","Bjh310hyy","Mehmet Murat", "Budak", "mbudak21@ku.edu.tr", 18, null);
		User user2 = new User("gabechu","1234","Ahmet", "Zade", "aasddwq@ku.edu.tr", 22, null);
		User user3 = new User("hasan","1111","hasan123", "Celik", "aaaaaa@asd.com", 55, null);

		
		
		user1.createContent("title testtt", "To provide correct layout of JEditorPane's content we need to know what height we will have for the content if JEditorPane's width is fixed. The code below can be used to measure JEditorPane and JTextPane. ", null);
		user1.createContent("title testtt2", "    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", null);
		user1.createContent("title testtt3", "placeholdertext Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididu Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididu Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididu", new ImageIcon(ContentPanel.class.getResource("/contentImages/image1.png")));
		user2.createContent("title testtt4", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image2.jpg")));
		user3.createContent("title testtt5", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image3.png")));
		user3.createContent("title testtt8", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image1.png")));
		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
//		JFrame frame = new JFrame();
//		MainPagePanel MainPagePanel = new MainPagePanel(null, null);
//		frame.add(MainPagePanel);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//this.setSize(416, 379);
//		frame.setBounds(750, 350, 416, 339);
		
	}
}
