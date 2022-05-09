package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import api.User;

@SuppressWarnings("serial")
public class RegistrationPanel extends JPanel implements ActionListener {
	
	// Panel Constants
	int SIZE_X = 400;
	int SIZE_Y = 300;
	Color BGCOLOR =  new Color(153, 180, 209);
	//Color BGCOLOR = Color.DARK_GRAY;
	
	JFrame MainFrame; // Parent Frame
	JPanel loginPanel; // Login Panel
	
	JLabel labelSignUp;
	JButton buttonBack;
	
	JTextFieldCustom txtFirstName;
	JTextFieldCustom txtSurname;
	JTextFieldCustom txtUsername;
	JPasswordField passwordField;
	JTextFieldCustom txtEmail;
	
	JLabel labelDateOfBirth;
	JSpinner spinnerDay;
	JSpinner spinnerMonth;
	JSpinner spinnerYear;
	JLabel labelDay;
	JLabel labelMonth;
	JLabel labelYear;
	JButton buttonRegister;
	
	JLabel labelStatus;


	public RegistrationPanel(JPanel loginPanel) {
		
		// Panel
		System.out.println("RegistrationPanel started");
		setBackground(BGCOLOR);
		setPreferredSize(new Dimension(SIZE_X, SIZE_Y));
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(null);
		MainFrame = (JFrame) SwingUtilities.getWindowAncestor(this); // Parent Frame
		this.loginPanel = loginPanel; // Login Panel
		
		// Label: labelSignUp
		labelSignUp = new JLabel("Sign Up");
		labelSignUp.setFont(new Font("Book Antiqua", Font.BOLD, 19));
		labelSignUp.setBounds(10, 11, 108, 51);
		add(labelSignUp);
		
		// Button: buttonBack
		buttonBack = new JButton();
		buttonBack.addActionListener(this);
		buttonBack.setBounds(370, 11, 20, 20);
		buttonBack.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonBack.setIcon(new ImageIcon("backArrow.png"));
		add(buttonBack);
		
		// TextField: txtFirstName
		txtFirstName = new JTextFieldCustom("First Name");
		txtFirstName.setBounds(52, 55, 130, 35);
		add(txtFirstName);
		txtFirstName.setColumns(10);
		
		// TextField: txtSurname
		txtSurname = new JTextFieldCustom("Surname");
		txtSurname.setColumns(10);
		txtSurname.setBounds(221, 55, 130, 35);
		add(txtSurname);
		
		// TextField: txtUsername
		txtUsername = new JTextFieldCustom("New Username");
		txtUsername.setColumns(10);
		txtUsername.setBounds(52, 105, 299, 35);
		add(txtUsername);
		
		// PasswordField: passwordField
		passwordField = new JPasswordField("New Password");
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(52, 151, 299, 35);
		passwordField.setBorder(new EmptyBorder(1, 1, 1, 1));
	//	System.out.println(passwordField.getEchoChar());
		passwordField.setEchoChar((char) 0);
		String passString = new String(passwordField.getPassword());
		passwordField.addFocusListener(new FocusListener() {

		    @Override
		    public void focusGained(FocusEvent e) {
		    	System.out.println(passwordField.getPassword());
		    		System.out.println();
			        if (new String(passwordField.getPassword()).equals(passString)) { // If the fields text equals "New Password"
			        	passwordField.setText("");
			        	passwordField.setForeground(Color.BLACK);
			        	passwordField.setEchoChar('•');
			        }

		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		    		if (new String(passwordField.getPassword()).equals("")) { // If the fields text equals "New Password"
			        	passwordField.setText("New Password");
			        	passwordField.setForeground(Color.GRAY);
			        	passwordField.setEchoChar((char) 0);
			        }
		    }
		}); // End of FocusListener
		add(passwordField);
		
		// TextField: txtEmail
		
		txtEmail = new JTextFieldCustom("email adress");
		//JTextField txtEmail = new JTextField("email adress");
		txtEmail.setColumns(10);
		txtEmail.setBounds(52, 197, 299, 35);
		add(txtEmail);
		
		// Label: labelDateOfBirth
		labelDateOfBirth = new JLabel("Date Of Birth");
		labelDateOfBirth.setBounds(52, 238, 108, 14);
		add(labelDateOfBirth);
		
		
		// Spinner: spinnerDay
		spinnerDay = new JSpinner();
		spinnerDay.setModel(new SpinnerNumberModel(1, 0, 31, 1));
		spinnerDay.setBounds(63, 255, 42, 20);
		add(spinnerDay);
		
		// Spinner: spinnerMonth
		spinnerMonth = new JSpinner();
		spinnerMonth.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMonth.setBounds(123, 255, 42, 20);
		add(spinnerMonth);
		
		// Spinner: spinnerYear
		spinnerYear = new JSpinner();
		spinnerYear.setModel(new SpinnerNumberModel(2000, 1900, 2020, 1));
		spinnerYear.setBounds(180, 255, 55, 20);
		add(spinnerYear);
		
		// Label: labelDay
		labelDay = new JLabel("D:");
		labelDay.setBounds(52, 258, 46, 14);
		add(labelDay);
		
		// Label: labelMonth
		labelMonth = new JLabel("M:");
		labelMonth.setBounds(110, 258, 46, 14);
		add(labelMonth);
		
		// Label: labelYear
		labelYear = new JLabel("Y:");
		labelYear.setBounds(170, 258, 46, 14);
		add(labelYear);
		
		
		// Button: buttonSignUp
		buttonRegister = new JButton("Register");
		buttonRegister.setBounds(262, 254, 89, 23);
		buttonRegister.addActionListener(this);
		add(buttonRegister);
		
		labelStatus = new JLabel("");
		labelStatus.setHorizontalAlignment(SwingConstants.CENTER);
		labelStatus.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		labelStatus.setForeground(Color.RED);
		labelStatus.setBounds(10, 280, 380, 14);
		add(labelStatus);


	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("------------------------------------");
//		System.out.println(buttonBack);
//		System.out.println(e.getSource());
//		System.out.println("------------------------------------");
		if (e.getSource() == buttonBack) {
			System.out.println("buttonBack pressed");
			this.setVisible(false);
			this.loginPanel.setVisible(true);
			
		}
		if (e.getSource() == buttonRegister) {
			System.out.println("buttonSignUp pressed");
			
			// Checks if the user has inputed right parameters for registration
			// Check if any of the textFields are empty
			/*
	JTextFieldCustom txtFirstName;
	JTextFieldCustom txtSurname;
	JTextFieldCustom txtUsername;
	JPasswordField passwordField;
	JTextFieldCustom txtEmail;
			 */
			// get the current usernames of users
			System.out.println(User.getUsers().contains("mbudak21")); 
			
			if(txtFirstName.getText().equals("") || txtFirstName.getText().contains(" ")) {
				labelStatus.setText("Invalid First Name");
				
			}
			else if(txtSurname.getText().equals("Surname") || txtSurname.getText().contains(" ")) {
				labelStatus.setText("Invalid Surname");
				
			}
			else if(txtUsername.getText().equals("New Username") || txtUsername.getText().contains(" ")) {
				labelStatus.setText("Invalid Username");
				
			}
			else if(txtUsername.getText().equals("New Username")) {
				labelStatus.setText("This Username is aready taken, try another one");
				
			}
			else if(new String(passwordField.getPassword()).equals("New Password") || new String(passwordField.getPassword()).contains(" ")) {
				labelStatus.setText("Invalid Password");
				
			}
			else if (new String(passwordField.getPassword()).length() < 8) {
				labelStatus.setText("Password must be longer than 8 characters");
			}
			else if(txtEmail.getText().equals("email adress") || txtEmail.getText().contains(" ")) {
				labelStatus.setText("Invalid email");
				
			}
			else{ // Login parameters are good for registrations
				// Register the user
				labelStatus.setText("");
				//User(String nickname, String password, String name, String surname, int age, String email)
				new User(txtUsername.getText(), new String(passwordField.getPassword()), txtFirstName.getText(), txtSurname.getText(), txtEmail.getText(), 0);
			}
			
		}
		
	}
}
