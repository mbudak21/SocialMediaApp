package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import api.Content;
import api.User;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainPagePanel extends JPanel implements ActionListener {
	int X_POS = 215;
	int Y_POS = 100;
	int SIZE_X = 1530;
	int SIZE_Y = 820;
	int ContentDisplayerSize_X = 620; // Content Display Area's size
	Color BGCOLOR = Color.PINK;
	JFrame MainFrame; // Parent Frame
	JPanel loginPanel; // Login Panel
	User user;
	
	//Components
	//Components
	JPanel leftPanel; // Contains userPanel
		JPanel buttonsPanel; // Contains the buttons
			JButton homePageButton;
			JButton followingButton;
			JButton profileButton;
			JButton groupsButton;
	
		JPanel userPanel; // displays data specific to the user logged in
			//Labels
			JLabel userProfileImgLabel; // Displays the profile image of the user
			JLabel nameSurnameLabel; // displays users name and surname
			JLabel usernameLabel; // displays users username
			//Buttons
			JButton logOutButton; // logs out the user and shows the login screen
			JButton exitButton; // closes the program	
			

	ContentDisplayer ContentDisplayer; // Content Display Area, displays the content(posts)
	JPanel rightPanel;
		JPanel panel;
		JTextField searchBarTextField;
		JButton searchUsersButton;
		JButton searchGroupsButton;
		ContentDisplayer userDisp;
		private JButton btnAddimage;

	

	
	public MainPagePanel(JPanel loginPane, User user) {
		System.out.println("MainPagePanel started");
		this.user = user;
		
		
		setBackground(BGCOLOR);
		setPreferredSize(new Dimension(SIZE_X, SIZE_Y));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		try {
		this.MainFrame = (JFrame) SwingUtilities.getWindowAncestor(loginPane); // Parent Frame
		MainFrame.setBounds(X_POS, Y_POS, SIZE_X+16, SIZE_Y+39);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, ContentDisplayerSize_X, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		//JPanel leftPanel, contains the userPanel which displays logged in users data
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.CYAN);
		GridBagConstraints gbc_leftPanel = new GridBagConstraints();
		gbc_leftPanel.insets = new Insets(0, 0, 0, 5);
		gbc_leftPanel.fill = GridBagConstraints.BOTH;
		gbc_leftPanel.gridx = 0;
		gbc_leftPanel.gridy = 0;
		add(leftPanel, gbc_leftPanel);
		SpringLayout sl_leftPanel = new SpringLayout();
		leftPanel.setLayout(sl_leftPanel);
		
		// JPanel buttonsPanel, contains the buttons
		buttonsPanel = new JPanel();
		sl_leftPanel.putConstraint(SpringLayout.NORTH, buttonsPanel, 0, SpringLayout.NORTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, buttonsPanel, -262, SpringLayout.EAST, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, buttonsPanel, 258, SpringLayout.NORTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, buttonsPanel, 0, SpringLayout.EAST, leftPanel);
		leftPanel.add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		homePageButton = new JButton("Home Page");
		homePageButton.addActionListener(this); 
		homePageButton.setFocusable(false);
		homePageButton.setBounds(10, 11, 238, 50);
		buttonsPanel.add(homePageButton);
		
		profileButton = new JButton("Profile");
		profileButton.addActionListener(this);
		profileButton.setFocusable(false);
		profileButton.setBounds(10, 72, 238, 50);
		buttonsPanel.add(profileButton);
		
		followingButton = new JButton("Following");
		followingButton.addActionListener(this);
		followingButton.setFocusable(false);
		followingButton.setBounds(10, 135, 238, 50);
		buttonsPanel.add(followingButton);
		
		groupsButton = new JButton("Groups");
		groupsButton.addActionListener(this);
		groupsButton.setFocusable(false);
		groupsButton.setBounds(10, 196, 238, 50);
		buttonsPanel.add(groupsButton);
		
		//JPanel userPanel, displays data specific to the user logged in
		userPanel = new JPanel();
		sl_leftPanel.putConstraint(SpringLayout.NORTH, userPanel, -268, SpringLayout.SOUTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, userPanel, -306, SpringLayout.EAST, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, userPanel, -128, SpringLayout.SOUTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, userPanel, 0, SpringLayout.EAST, leftPanel);
		leftPanel.add(userPanel);
		userPanel.setLayout(null);
		
		//JLabel userProfileImgLabel, displays users profile image
		userProfileImgLabel = new JLabel();
		userProfileImgLabel.setBounds(10, 11, 60, 60);
		userProfileImgLabel.setIcon(user.getProfilePhoto());
		userPanel.add(userProfileImgLabel);
		
		//JLabel nameSurnameLabel, displays users name and surname
		nameSurnameLabel = new JLabel(user.getName() + " " + user.getSurname());
		nameSurnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameSurnameLabel.setBounds(80, 11, 198, 14);
		userPanel.add(nameSurnameLabel);
		
		//JLabel usernameLabel, displays users username
		usernameLabel = new JLabel(user.getNickname());
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setBounds(80, 36, 198, 14);
		userPanel.add(usernameLabel);
		
		//JButton logOutButton, logs out the user and shows the login screen
		logOutButton = new JButton("Log Out");
		logOutButton.addActionListener(this);
		logOutButton.setBounds(108, 106, 94, 23);
		userPanel.add(logOutButton);
		
		//JButton exitButton, closes the program
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(209, 106, 94, 23);
		userPanel.add(exitButton);
		
		btnAddimage = new JButton("Add Image");
		btnAddimage.setBounds(7, 106, 94, 23);
		userPanel.add(btnAddimage);
		
		ContentDisplayer = new ContentDisplayer(user);
		ContentDisplayer.displayContent(Content.getcontentList(), false);
		ContentDisplayer.displayContentCreator();
		
		GridBagConstraints gbc_ContentDisplayer = new GridBagConstraints();
		gbc_ContentDisplayer.insets = new Insets(0, 0, 0, 5);
		gbc_ContentDisplayer.fill = GridBagConstraints.BOTH;
		gbc_ContentDisplayer.gridx = 1;
		gbc_ContentDisplayer.gridy = 0;
		add(ContentDisplayer, gbc_ContentDisplayer);
		
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.CYAN);
		GridBagConstraints gbc_rightPanel = new GridBagConstraints();
		gbc_rightPanel.fill = GridBagConstraints.BOTH;
		gbc_rightPanel.gridx = 2;
		gbc_rightPanel.gridy = 0;
		add(rightPanel, gbc_rightPanel);
		SpringLayout sl_rightPanel = new SpringLayout();
		rightPanel.setLayout(sl_rightPanel);
		
		panel = new JPanel();
		sl_rightPanel.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.SOUTH, panel, 820, SpringLayout.NORTH, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.EAST, panel, 452, SpringLayout.WEST, rightPanel);
		rightPanel.add(panel);
		panel.setLayout(null);
		
		searchBarTextField = new JTextField();
		searchBarTextField.setBounds(10, 11, 265, 20);
		panel.add(searchBarTextField);
		searchBarTextField.setColumns(10);
		
		searchGroupsButton = new JButton("Search Groups");
		searchGroupsButton.addActionListener(this);
		searchGroupsButton.setBounds(10, 54, 120, 23);
		panel.add(searchGroupsButton);
		
		searchUsersButton = new JButton("Search Users");
		searchUsersButton.addActionListener(this); 
		searchUsersButton.setBounds(155, 54, 120, 23);
		panel.add(searchUsersButton);
		
		userDisp = new ContentDisplayer(user);
		userDisp.setVisible(true);
		userDisp.setBackground(Color.ORANGE);
		userDisp.setBounds(0, 92, 452, 728);
		panel.add(userDisp);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//searchUsersButton searchGroupsButton
		if(e.getSource() == logOutButton) {
			this.setVisible(false);
			MainFrame.remove(this);
			MainFrame customFrame = (MainFrame) MainFrame;
			customFrame.startLoginPane();
		}
		if (e.getSource() == exitButton) {
			MainFrame.dispose();
		}
		if (e.getSource() == homePageButton) {
			ContentDisplayer.displayContent(Content.getcontentList(), false);
			ContentDisplayer.displayContentCreator();
			this.repaint();
			this.revalidate();
		}
		if (e.getSource() == profileButton) {
			System.out.println("ProfileButton pressed");
			ContentDisplayer.displayContent(user.getContentCreated(), true);
		}
		if (e.getSource() == followingButton) {
			userDisp.displayUsers(user, user.getUsersWhoThisFollows());
		}
		if (e.getSource() == groupsButton) {
			
		}
		if (e.getSource() == searchUsersButton) {
			userDisp.displayUsers(user, User.search(searchBarTextField.getText()));
			
			
		}
		if (e.getSource() == searchGroupsButton) {
			//Content.search(searchBarTextField.getText());
		}

	}
}
