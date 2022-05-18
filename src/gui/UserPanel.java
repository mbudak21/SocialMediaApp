package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import api.User;

@SuppressWarnings("serial")
public class UserPanel extends JPanel implements ActionListener {
	JLabel userProfilePictureLabel;
	JLabel nameSurnameLabel;
	JLabel usernameLabel;
	JButton showContentButton;
	JButton followButton;

	User user;
	User userToDisplay;
	/**
	 * Create the panel.
	 */
	public UserPanel(User user, User userToDisplay) {
		this.user = user;
		this.userToDisplay = userToDisplay;
		setLayout(null);
		
		userProfilePictureLabel = new JLabel();
		userProfilePictureLabel.setVerticalTextPosition(SwingConstants.TOP);
		userProfilePictureLabel.setVerticalAlignment(SwingConstants.TOP);
		userProfilePictureLabel.setIconTextGap(0);
		userProfilePictureLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userProfilePictureLabel.setBorder(null);
		userProfilePictureLabel.setBackground(Color.LIGHT_GRAY);
		userProfilePictureLabel.setAlignmentY(0.0f);
		userProfilePictureLabel.setBounds(10, 11, 61, 61);
		userProfilePictureLabel.setIcon(userToDisplay.getProfilePhoto());
		add(userProfilePictureLabel);
		
		nameSurnameLabel = new JLabel(userToDisplay.getName() + " " + userToDisplay.getSurname());
		nameSurnameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameSurnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameSurnameLabel.setBounds(75, 11, 225, 14);
		add(nameSurnameLabel);
		
		usernameLabel = new JLabel(userToDisplay.getNickname());
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setBounds(75, 29, 225, 14);
		add(usernameLabel);
		
		showContentButton = new JButton("Show Content");
		showContentButton.addActionListener(this);
		showContentButton.setBounds(10, 116, 120, 23);
		add(showContentButton);
		
		followButton = new JButton("Follow");
		followButton.addActionListener(this);
		followButton.setBounds(320, 116, 120, 23);
		add(followButton);
		
		updateButton();
	}
	/*
	 * Checks if the user has followed the user being displayed and updates the "Follow" button accordingly
	 */
	public void updateButton() {
		if (user.getUsersWhoThisFollows().contains(userToDisplay)) {
			followButton.setText("Unfollow");
		}
		else {
			followButton.setText("Follow");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == followButton) {
			if (followButton.getText().equals("Follow")) {
				followButton.setText("Unfollow");
				user.follow(userToDisplay);
//				System.out.println("following");
			}
			else {
				followButton.setText("Follow");
				user.unfollow(userToDisplay);
//				System.out.println("unfollowing");
			}
		}
	}
}
