package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import api.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;

@SuppressWarnings("serial")
public class settingsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					settingsFrame frame = new settingsFrame(null);
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
	public settingsFrame(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(30, 33, 68, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(99, 30, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 55, 150, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(99, 80, 150, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_1.setBounds(30, 58, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_2.setBounds(30, 83, 68, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(99, 104, 150, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Username:");
		lblNewLabel_2_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_2_1.setBounds(30, 107, 68, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(99, 128, 150, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_2_2 = new JLabel("Username:");
		lblNewLabel_2_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel_2_2.setBounds(30, 131, 68, 14);
		contentPane.add(lblNewLabel_2_2);
	}
}
