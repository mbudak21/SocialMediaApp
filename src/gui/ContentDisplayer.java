package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import api.Content;
import api.User;

@SuppressWarnings("serial")
public class ContentDisplayer extends JPanel {
	int SIZE_X = 617;
	int SIZE_Y = 850;
	
	User user;
	JFrame MainFrame; // Parent Frame
	JPanel MainPagePanel; // Login Panel
	
	
	JPanel mainPanel;
	ContentPanel ContentPanel;
	JScrollPane scrollPane;
	JPanel panel_1;

	public ContentDisplayer(User user) {
		this.user = user;
		System.out.println("ContentDisplayer started");
		setPreferredSize(new Dimension(SIZE_X, SIZE_Y));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		mainPanel = new JPanel();
		scrollPane.setViewportView(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setVisible(true);
		add(scrollPane);
	}
	
	public void displayContent(ArrayList<Content> contentList, Boolean editable) {
		mainPanel.removeAll();
		
		// Add the contents
		for (int i = 1; i < contentList.size()+1; i++) {
			
			int j = contentList.size()-i ;
			Content rawContent = contentList.get(j);
			ContentPanel panelContent = new ContentPanel(this, rawContent, editable);
			GridBagConstraints gbc_contentPanel = new GridBagConstraints();
			System.out.print(i);
			gbc_contentPanel.gridy = i; // gbc_contentPanel.insets = new Insets(15, 0, 0, 0);
////		gbc_contentPanel.fill = GridBagConstraints.NONE;
			mainPanel.add(panelContent, gbc_contentPanel);
			mainPanel.scrollRectToVisible(panelContent.getBounds());
		}
		mainPanel.revalidate();
	}
	public void displayUsers(User user, ArrayList<User> userList) {
		mainPanel.removeAll();
		
		// Add the contents
		for (int i = 0; i < userList.size(); i++) {
			
			UserPanel userPanel = new UserPanel(user, userList.get(i));
			GridBagConstraints gbc_userPanel = new GridBagConstraints();
			gbc_userPanel.gridy = i;
			mainPanel.add(userPanel, gbc_userPanel);
			mainPanel.scrollRectToVisible(userPanel.getBounds());
		}
		mainPanel.revalidate();
	}
	public void displayUsers(User user, Set<User> userList) {
		mainPanel.removeAll();
		int i=0;
		for (User user2 : userList) {
			UserPanel userPanel = new UserPanel(user, user2);
			GridBagConstraints gbc_userPanel = new GridBagConstraints();
			gbc_userPanel.gridy = i;
			mainPanel.add(userPanel, gbc_userPanel);
			mainPanel.scrollRectToVisible(userPanel.getBounds());
		}
		mainPanel.revalidate();
	}
	
	public void displayContentCreator(){
		// Add the content creator
		ContentCreator contentCreator = new ContentCreator(user);
		GridBagConstraints gbc_contentCreator = new GridBagConstraints();
		gbc_contentCreator.gridy = 0;
		mainPanel.add(contentCreator, gbc_contentCreator);
		mainPanel.setVisible(true);
		mainPanel.revalidate(); 
	}
	
}
