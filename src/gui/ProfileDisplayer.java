package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class ProfileDisplayer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileDisplayer frame = new ProfileDisplayer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProfileDisplayer() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(null);
		upperPanel.setSize(new Dimension(600, 61));
		upperPanel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		upperPanel.setBackground(Color.LIGHT_GRAY);
		upperPanel.setBounds(15, 11, 600, 61);
		contentPane.add(upperPanel);
		
		JLabel nameSurnameLabel_1 = new JLabel("<dynamic> <dynamic>");
		nameSurnameLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		nameSurnameLabel_1.setBounds(71, 11, 225, 14);
		upperPanel.add(nameSurnameLabel_1);
		
		JLabel usernameLabel = new JLabel((String) null);
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setBounds(71, 29, 225, 14);
		upperPanel.add(usernameLabel);
		
		JLabel datetimeLabel = new JLabel((String) null);
		datetimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		datetimeLabel.setForeground(Color.DARK_GRAY);
		datetimeLabel.setBounds(454, 13, 136, 14);
		upperPanel.add(datetimeLabel);
		
		JLabel userProfilePictureLabel = new JLabel();
		userProfilePictureLabel.setVerticalTextPosition(SwingConstants.TOP);
		userProfilePictureLabel.setVerticalAlignment(SwingConstants.TOP);
		userProfilePictureLabel.setIconTextGap(0);
		userProfilePictureLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userProfilePictureLabel.setBorder(new MatteBorder(0, 0, 1, 1, new Color(0, 0, 0)));
		userProfilePictureLabel.setBackground(Color.LIGHT_GRAY);
		userProfilePictureLabel.setAlignmentY(0.0f);
		userProfilePictureLabel.setBounds(0, 0, 61, 61);
		upperPanel.add(userProfilePictureLabel);
	}
}
