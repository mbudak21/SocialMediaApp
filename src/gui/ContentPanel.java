package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import api.Content;
import api.User;

@SuppressWarnings("serial")
public class ContentPanel extends JPanel implements ActionListener{
	//Constants
	int SIZE_X = 600;
	JPanel parentPanel; // Parent Panel

	//Components
	JButton btnNewButton;
	JEditorPane contentTextArea;
	Boolean editable;
	JButton addImageButton;
	JButton saveButton;
	JButton deleteButton;
	JLabel imageLabel;
	
	//Variables
	Content rawContent;
	String title;
	String text;
	ImageIcon image;
	User author;
	
	JTextField titleTextArea;
	
	public ContentPanel(JPanel parentPanel, Content rawContent, Boolean editable) {
		this.parentPanel = parentPanel;
		this.rawContent = rawContent;
		this.editable = editable;
		this.title = rawContent.getTitle();
		this.text = rawContent.getText();
		this.image = rawContent.getImage();
		this.author = rawContent.getAuthor();

		
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(null);
		this.setForeground(Color.black);
		this.setBackground(Color.GRAY);

		
		JPanel upperPanel = new JPanel();
		upperPanel.setBackground(Color.LIGHT_GRAY);
		upperPanel.setLayout(null);
		upperPanel.setLocation(0, 0);
		upperPanel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		upperPanel.setSize(new Dimension(SIZE_X, 61));
		add(upperPanel);
		

		JLabel nameSurnameLabel = new JLabel((this.author.getName()) + " " + this.author.getSurname());
		nameSurnameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameSurnameLabel.setBounds(71, 11, 225, 14);
		upperPanel.add(nameSurnameLabel);
		nameSurnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel usernameLabel = new JLabel(this.author.getNickname());
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setBounds(71, 29, 225, 14);
		upperPanel.add(usernameLabel);
		usernameLabel.setForeground(Color.DARK_GRAY);

		JLabel datetimeLabel = new JLabel(rawContent.DateToString());
		datetimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		datetimeLabel.setBounds(454, 29, 136, 14);
		upperPanel.add(datetimeLabel);
		datetimeLabel.setForeground(Color.DARK_GRAY);
		
		JLabel userProfilePictureLabel = new JLabel();
		userProfilePictureLabel.setBounds(0, 0, 61, 61);
		upperPanel.add(userProfilePictureLabel);
		userProfilePictureLabel.setVerticalAlignment(SwingConstants.TOP);
		userProfilePictureLabel.setVerticalTextPosition(SwingConstants.TOP);
		userProfilePictureLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		userProfilePictureLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userProfilePictureLabel.setIconTextGap(0);
		userProfilePictureLabel.setBorder(new MatteBorder(0, 0, 1, 1, new Color(0, 0, 0)));
		userProfilePictureLabel.setBackground(Color.LIGHT_GRAY);
		userProfilePictureLabel.setIcon(this.author.getProfilePhoto());
		
		//Display the image
		displayImage();

		
		addImageButton = new JButton();
		addImageButton.setFocusable(false);
		addImageButton.addActionListener(this);
		addImageButton.setIcon(new ImageIcon(ContentPanel.class.getResource("/gui/images/icons8-pictures-folder-20.png")));
		addImageButton.setBounds(525, 5, 20, 20);
		upperPanel.add(addImageButton);
		
		saveButton = new JButton();
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		saveButton.setIcon(new ImageIcon(ContentPanel.class.getResource("/gui/images/icons8-save-20.png")));
		saveButton.setBounds(550, 5, 20, 20);
		upperPanel.add(saveButton);
		
		deleteButton = new JButton();
		deleteButton.setFocusable(false);
		deleteButton.addActionListener(this);
		deleteButton.setIcon(new ImageIcon(ContentPanel.class.getResource("/gui/images/icons8-cross-mark-button-20.png")));
		deleteButton.setBounds(575, 5, 20, 20);
		upperPanel.add(deleteButton);
		
		
		addImageButton.setVisible(editable);
		saveButton.setVisible(editable);
		deleteButton.setVisible(editable);


		setVisible(true);
		setLocation(0, 0);
		
		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		titleLabel.setBounds(10, 72, 49, 14);
		add(titleLabel);
		
		titleTextArea = new JTextField(this.getTitle());
		titleTextArea.setHorizontalAlignment(SwingConstants.LEFT);
		titleTextArea.setBorder(null);
		titleTextArea.setOpaque(false);
		titleTextArea.setBounds(69, 69, 521, 20);
		add(titleTextArea);
		titleTextArea.setColumns(10);
		


		//JEditorPane textArea
		contentTextArea = new JEditorPane();
		contentTextArea.setEditable(editable);
		contentTextArea.setContentType("text/html");
		contentTextArea.setText(this.getText());
		contentTextArea.setOpaque(editable);
		if (editable) {
			contentTextArea.setForeground(Color.LIGHT_GRAY);
			contentTextArea.setBackground(Color.LIGHT_GRAY);
		}
		add(contentTextArea);
		contentTextArea.setBounds(10, 90, 580, getContentHeight(this.getText()));
	}
	
	public void displayImage() {
		if (imageLabel == null) {
			imageLabel = new JLabel();
			imageLabel.setVisible(false);
		}
		if (this.getImage() != null) {
			// The Image exists
			imageLabel.removeAll();
			try {
				imageLabel.setIcon(scaleImageIcon(this.getImage(), 550, 550));
				imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
				imageLabel.setBounds(25, getContentHeight(this.getText())+97, 550, 550);
				add(imageLabel);
				imageLabel.setVisible(true);
				setPreferredSize(new Dimension(SIZE_X, getContentHeight(this.getText())+672));
				System.out.println("IMAGE RENDERED");
			}catch(Exception e) {
				e.printStackTrace();
			}
			this.revalidate();
			parentPanel.revalidate();

		}else {
			setPreferredSize(new Dimension(SIZE_X, getContentHeight(this.getText())+97));
		}

	}
	
	public static int getContentHeight(String content) {
        JEditorPane placeHolder = new JEditorPane();
        placeHolder.setSize(580, Short.MAX_VALUE);
        placeHolder.setContentType("text/html");
        placeHolder.setText(content);
        
        return placeHolder.getPreferredSize().height;
    }
    /**
     * Converts the inputed ImageIcon into an Image and then 
     * applies ImagegetScaledInstance(width, height, Image.SCALE_SMOOTH);
     *
     * If either {@code width}
     * or {@code height} is a negative number then a value is
     * substituted to maintain the aspect ratio of the original image
     * dimensions. If both {@code width} and {@code height}
     * are negative, then the original image dimensions are used.
     * 
     * 
     * @param width the width to which to scale the image.
     * @param height the height to which to scale the image.
     * @return     a scaled version of the image.
     * @exception IllegalArgumentException if {@code width}
     *             or {@code height} is zero.
     * @see        #java.awt.Image.getScaledInstance(int width, int height, int hints)
     */
	public static ImageIcon scaleImageIcon(ImageIcon imageIcon, int width, int height) {
	     Image imageToScale = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	     return new ImageIcon(imageToScale);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addImageButton) {
			System.out.println("addImageButton pressed");
			
			JFileChooser file = new JFileChooser();
			file.setCurrentDirectory(new File(System.getProperty("user.home")));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
			file.addChoosableFileFilter(filter);
			int result = file.showSaveDialog(null);
			
			if(result == 0){
				File selectedFile = file.getSelectedFile();
				String path = selectedFile.getAbsolutePath();
				
				ImageIcon MyImage = new ImageIcon(path);
				setImage(MyImage);
				rawContent.setImage(MyImage);
				displayImage();
				repaint();
				revalidate();
				parentPanel.repaint();
				parentPanel.revalidate();
			}
			else if(result == JFileChooser.CANCEL_OPTION){
				System.out.println("No File Selected");
			}
		}
		if(e.getSource() == saveButton) {
			
			System.out.println("saveButton pressed");
			
			rawContent.setText(contentTextArea.getText());
			setText(contentTextArea.getText());
			
			rawContent.setImage(getImage());
			
			
			
			//his = new ContentPanel(parentPanel, new Content(getAuthor(), getTitle(), contentTextArea.getText(), getImage()), editable);
			
		}
		if(e.getSource() == deleteButton) {
			Content.getcontentList().remove(rawContent);
			rawContent.getAuthor().getContentCreated().remove(rawContent);
			this.removeAll();
			revalidate();
			parentPanel.repaint();
			parentPanel.revalidate();
		}
		
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the image
	 */
	public ImageIcon getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(ImageIcon image) {
		this.image = image;
	}

	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}
}
