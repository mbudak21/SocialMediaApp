package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import api.User;

@SuppressWarnings({ "serial" })
public class LoginPanel extends JPanel implements ActionListener {
	
	// Panel Constants
	Color BGCOLOR = Color.DARK_GRAY;
	int SIZE_X = 400;
	int SIZE_Y = 300;
	JFrame MainFrame; // parent frame
	RegistrationPanel registrationPane; // Registration Panel
	
	// Labels
	JLabel status = new JLabel();
	JLabel usernameLabel = new JLabel();
	JLabel passwordLabel = new JLabel();
	
	// Text fields
	JTextField username = new JTextField();
	JTextField password = new JTextField();	
	
	// Buttons
	JButton LoginButton = new JButton("Log In");
	JButton RegisterButton = new JButton("Register");

	GridBagConstraints gbc = new GridBagConstraints();
	
	LoginPanel(){
		
		System.out.println("LoginPanel started");
		
		// Pane
		this.setBackground(BGCOLOR);
		this.setPreferredSize(new Dimension(SIZE_X, SIZE_Y));
		setLayout(new GridBagLayout());
		
		
		// Username Label
		usernameLabel.setText("Username");
		usernameLabel.setForeground(Color.LIGHT_GRAY);
		gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 1; gbc.insets = new Insets(0, 0, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		this.add(usernameLabel, gbc);
		// Password label
		passwordLabel.setText("Password");
		passwordLabel.setForeground(Color.LIGHT_GRAY);
		gbc.gridx = 0; gbc.gridy = 2;gbc.gridwidth = 1; gbc.insets = new Insets(5, 0, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		this.add(passwordLabel, gbc);
		
		
		// Username Text Field
		// username.setText("Enter your username");
		username.setBorder(new EmptyBorder(0, 0, 0, 0));
		gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; gbc.insets = new Insets(0, 0, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		this.add(username, gbc);
		
		// Password Text Field
		// password.setText("********");
		password.setBorder(new EmptyBorder(0, 0, 0, 0));
		gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.insets = new Insets(0, 0, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		this.add(password, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		
		// Login Button
		LoginButton.addActionListener(this);
		LoginButton.setFocusable(false);
		LoginButton.setPreferredSize(new Dimension(90, 22));
		gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1; gbc.insets = new Insets(8, 0, 0, 5); // up, left, bottom, right
		this.add(LoginButton, gbc);
		
		// Register Button
		RegisterButton.addActionListener(this);
		RegisterButton.setFocusable(false);
		RegisterButton.setPreferredSize(new Dimension(90, 22));
		gbc.gridx = 1; gbc.gridy = 4; gbc.gridwidth = 1;  gbc.insets = new Insets(8, 5, 0, 0);
		this.add(RegisterButton, gbc);
		
		// Status Label	
		status.setForeground(Color.RED);
		gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.insets = new Insets(15, 0, 0, 0);
		gbc.fill = GridBagConstraints.NONE;
		this.add(status, gbc);
		
		
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("------------------------------------");
//		System.out.println(RegisterButton);
//		System.out.println(e.getSource());
//		System.out.println("------------------------------------");
		if(e.getSource() == LoginButton ) {
			System.out.println("LoginButton pressed");
			User user = User.Login(username.getText(), password.getText());
			if (user != null) {
				// Login successful
				System.out.printf("User: %s successfuly logged in", user.getNickname());
				status.setText("Login Successful");
				status.setForeground(Color.GREEN);
				
			}
			else {
				// wrong credentials
				status.setForeground(Color.RED);
				System.out.printf("Wrong username or password");
				status.setText("Wrong username or password");
				
			}
			
		}
		if(e.getSource() == RegisterButton ) {
			System.out.println("RegisterButton pressed");
			this.setVisible(false);
			if (registrationPane == null) {
				RegistrationPanel registrationPane = new RegistrationPanel(this);
				System.out.println(registrationPane);
				MainFrame = (JFrame) SwingUtilities.getWindowAncestor(this); // Get the parent frame
				MainFrame.add(registrationPane);
				registrationPane.setVisible(true);
			}

			
			
		}
		
	}
}
