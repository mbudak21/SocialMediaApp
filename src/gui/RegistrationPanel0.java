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

@SuppressWarnings("serial")
public class RegistrationPanel0 extends JPanel implements ActionListener {
	
	// Panel Constants
	Color COLOR = Color.BLACK;
	int SIZE_X = 400;
	int SIZE_Y = 300;
	JFrame MainFrame;
	
	// Components
	// Labels
	JLabel usernameLabel = new JLabel("Username:");
	JLabel passwordLabel = new JLabel("Password:");
	// JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
	JLabel nameLabel = new JLabel("Your name:");
	JLabel surnameLabel = new JLabel("Your surname:");
	JLabel ageLabel = new JLabel("Your age:");
	JLabel emailLabel = new JLabel("Your email:");
	
	// Text fields
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	// JTextField confirmPassword = new JTextField();
	JTextField name = new JTextField();
	JTextField surname = new JTextField();
	JTextField age = new JTextField();
	JTextField email = new JTextField();
	
	// Buttons
	JButton goBackButton = new JButton("Back");
	JButton RegisterNow = new JButton("Register");
	
	//Status Label
	JLabel statusLabel = new JLabel();
	
	GridBagConstraints gbc = new GridBagConstraints();
	
	RegistrationPanel0(){
		System.out.println("Started Registration Pane");
		this.setBackground(COLOR);
		this.setForeground(COLOR);
		this.setPreferredSize(new Dimension(SIZE_X, SIZE_Y));
		setLayout(new GridBagLayout());
		
		// Labels 
		gbc.gridx = 0;  gbc.fill = GridBagConstraints.HORIZONTAL;  gbc.insets = new Insets(0, 0, 0, 0);
		
		usernameLabel.setForeground(Color.LIGHT_GRAY);
		usernameLabel.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridy = 0;
		this.add(usernameLabel, gbc);
		
		passwordLabel.setForeground(Color.LIGHT_GRAY);
		passwordLabel.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridy = 1;
		this.add(passwordLabel, gbc);
		
//		confirmPasswordLabel.setForeground(Color.LIGHT_GRAY);
//		confirmPasswordLabel.setHorizontalAlignment(JLabel.RIGHT);
//		gbc.gridy = 2;
//		this.add(confirmPasswordLabel, gbc);
		
		nameLabel.setForeground(Color.LIGHT_GRAY);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridy = 3;
		this.add(nameLabel, gbc);
		
		surnameLabel.setForeground(Color.LIGHT_GRAY);
		surnameLabel.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridy = 4;
		this.add(surnameLabel, gbc);
		
		ageLabel.setForeground(Color.LIGHT_GRAY);
		ageLabel.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridy = 5;
		this.add(ageLabel, gbc);
		
		emailLabel.setForeground(Color.LIGHT_GRAY);
		emailLabel.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridy = 6;
		this.add(emailLabel, gbc);
		
		// Text Fields
		gbc.gridx = 1; gbc.fill = GridBagConstraints.BOTH;
		
		username.setPreferredSize(new Dimension(140, 8));
		gbc.gridy = 0; gbc.ipady =3;
		this.add(username, gbc);
		
		gbc.gridy = 1;  gbc.insets = new Insets(5, 0, 0, 0);
		this.add(password, gbc);
		
//		gbc.gridy = 2;
//		this.add(confirmPassword, gbc);
		
		gbc.gridy = 3;
		this.add(name, gbc);
		
		gbc.gridy = 4;
		this.add(surname, gbc);
		
		gbc.gridy = 5;
		this.add(age, gbc);

		gbc.gridy = 6;
		this.add(email, gbc);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
