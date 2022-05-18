package gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import api.User;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpringLayout;
import java.awt.Color;

@SuppressWarnings("serial")
public class TestPanel extends JPanel {

	/**
	 * Create the panel.
	 */
//	public TestPanel() {
//		
//		User user1 = new User("mbudak21","Bjh310hyy","Mehmet Murat", "Budak", "mbudak21@ku.edu.tr", 18, null);
//		User user2 = new User("gabechu","1234","Ahmet", "Zade", "aasddwq@ku.edu.tr", 22, null);
//		User user3 = new User("hasan","1111","hasan123", "Celik", "aaaaaa@asd.com", 55, null);
//		
//		ImageIcon imageIcon = new ImageIcon(ContentPanel.class.getResource("/contentImages/image1.png"));
//		
//		user1.createContent("title testtt", "To provide correct layout of JEditorPane's content we need to know what height we will have for the content if JEditorPane's width is fixed. The code below can be used to measure JEditorPane and JTextPane. ", null);
//		user1.createContent("title testtt2", "    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", null);
//		user1.createContent("title testtt3", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image1.png")));
//		user2.createContent("title testtt4", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image2.jpg")));
//		user3.createContent("title testtt5", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image3.png")));
//		user3.createContent("title testtt8", "placeholdertext", imageIcon);
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{154, 500, 154, 0};
//		gridBagLayout.rowHeights = new int[]{315, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
//		setLayout(gridBagLayout);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.PINK);
//		GridBagConstraints gbc_panel = new GridBagConstraints();
//		gbc_panel.insets = new Insets(0, 0, 0, 5);
//		gbc_panel.fill = GridBagConstraints.BOTH;
//		gbc_panel.gridx = 0;
//		gbc_panel.gridy = 0;
//		add(panel, gbc_panel);
//		SpringLayout sl_panel = new SpringLayout();
//		panel.setLayout(sl_panel);
//		
//		JPanel panel_1 = new ContentDisplayer(this, null);
//		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
//		gbc_panel_1.fill = GridBagConstraints.BOTH;
//		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
//		gbc_panel_1.gridx = 1;
//		gbc_panel_1.gridy = 0;
//		add(panel_1, gbc_panel_1);
//		
//		JPanel panel_2 = new JPanel();
//		panel_2.setLayout(null);
//		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
//		gbc_panel_2.fill = GridBagConstraints.BOTH;
//		gbc_panel_2.gridx = 2;
//		gbc_panel_2.gridy = 0;
//		add(panel_2, gbc_panel_2);
//		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(0, 409, 89, 23);
//		panel_2.add(btnNewButton);
//
//	}

	public TestPanel(){
		User user1 = new User("mbudak21","Bjh310hyy","Mehmet Murat", "Budak", "mbudak21@ku.edu.tr", 18, null);
		User user2 = new User("gabechu","1234","Ahmet", "Zade", "aasddwq@ku.edu.tr", 22, null);
		User user3 = new User("hasan","1111","hasan123", "Celik", "aaaaaa@asd.com", 55, null);
		user1.createContent("title testtt", "To provide correct layout of JEditorPane's content we need to know what height we will have for the content if JEditorPane's width is fixed. The code below can be used to measure JEditorPane and JTextPane. ", null);
		user1.createContent("title testtt2", "    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", null);
		user1.createContent("title testtt3", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image1.png")));
		user2.createContent("title testtt4", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image2.jpg")));
		user3.createContent("title testtt5", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image3.png")));
		user3.createContent("title testtt8", "placeholdertext", new ImageIcon(ContentPanel.class.getResource("/contentImages/image1.png")));
	
		add(new ContentDisplayer(this, user1));
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new TestPanel();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setSize(new Dimension(800, 500));
		
		
		
	}
}
