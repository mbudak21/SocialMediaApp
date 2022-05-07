package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import api.User;

@SuppressWarnings({ "serial" })
public class LoginPane extends JPanel implements ActionListener {
	
	JButton RegisterButton = new JButton("Register");
	JButton LoginButton = new JButton("Log In");
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	Color COLOR = Color.DARK_GRAY;
	int SIZE_X = 330;
	int SIZE_Y = 200;
	GridBagConstraints gbc = new GridBagConstraints();
	
	LoginPane(){
		
		// Pane
		this.setBackground(COLOR);
		this.setForeground(COLOR);
		this.setPreferredSize(new Dimension(SIZE_X, SIZE_Y));
		setLayout(new GridBagLayout());
	
		
		
		// Login Button
		LoginButton.addActionListener(this);
		LoginButton.setFocusable(false);
		LoginButton.setPreferredSize(new Dimension(90, 22));
		gbc.gridx = 0; gbc.gridy = 3; gbc.insets = new Insets(8, 0, 0, 5); // up, left, bottom, right
		this.add(LoginButton, gbc);
		
		// Register Button
		RegisterButton.addActionListener(this);
		RegisterButton.setFocusable(false);
		RegisterButton.setPreferredSize(new Dimension(90, 22));
		gbc.gridx = 1; gbc.gridy = 3; gbc.insets = new Insets(8, 5, 0, 0);
		this.add(RegisterButton, gbc);
		
		// Username Text Field
		username.setPreferredSize(new Dimension(170, 20));
		username.setText("Enter your username");
		gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(0, 20, 0, 0);
		this.add(username, gbc);
		
		// Password Text Field
		password.setPreferredSize(new Dimension(170, 20));
		password.setText("********");
		gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; gbc.insets = new Insets(8, 20, 0, 0);
		this.add(password, gbc);


		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == LoginButton ) {
			System.out.println("LoginButton pressed");
			User user = User.Login(username.getText(), password.getText());
			if (user != null) {
				// Login sucsesfull
				System.out.printf("User: %s succsessfully logged in", user.getNickname());
				
			}
			else {
				// wrong creds
			}
			
		}
		if(e.getSource() == RegisterButton ) {
			System.out.println("RegisterButton pressed");
		}
		
	}
}
