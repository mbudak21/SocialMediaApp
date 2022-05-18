package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import api.Content;
import api.User;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ContentCreator extends JPanel implements ActionListener {

	User user;
	
	int SIZE_X = 600;
	
	JTextPane contentTextField;
	//JTextField ;
	JLabel pathLabel;
	JButton postButton;
	JButton addImageButton;
	JLabel titleLabel;
	JTextField titleTextField;
	ImageIcon image;


	
	public ContentCreator(User user) {
		
		this.user = user;
		this.image = null;
		
		System.out.println("Content Creator started");
		setPreferredSize(new Dimension(600, 188));
		setLayout(null);
		
		contentTextField = new JTextPane();
		contentTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentTextField.setBounds(10, 40, 580, 109);
		add(contentTextField);
		
		postButton = new JButton("Post");
		postButton.addActionListener(this);
		postButton.setBounds(490, 160, 100, 23);
		add(postButton);
		
		addImageButton = new JButton("Add Image");
		addImageButton.addActionListener(this);
		addImageButton.setBounds(380, 160, 100, 23);
		add(addImageButton);
		
		titleLabel = new JLabel("Title:");
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		titleLabel.setBounds(10, 15, 28, 14);
		add(titleLabel);
		
		titleTextField = new JTextField();
		titleTextField.setBounds(48, 12, 542, 20);
		add(titleTextField);
		titleTextField.setColumns(10);
		
		pathLabel = new JLabel("");
		pathLabel.setBounds(10, 160, 382, 14);
		add(pathLabel);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == postButton) {
			user.createContent(titleTextField.getText(), contentTextField.getText(), image);
		}
		if(e.getSource() == addImageButton) {
			JFileChooser file = new JFileChooser();
			file.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
			file.addChoosableFileFilter(filter);
			int result = file.showSaveDialog(null);
			
			if(result == 0){
				File selectedFile = file.getSelectedFile();
				String path = selectedFile.getAbsolutePath();
				pathLabel.setText(path);
				
				image = new ImageIcon(path);
			}
			else if(result == JFileChooser.CANCEL_OPTION){
				System.out.println("No File Selected");
				this.image = null;
				pathLabel.setText("");
			}
			
		}
		
		
	}
}
