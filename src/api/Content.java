package api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.ImageIcon;

public class Content {
	static ArrayList<Content> contentList = new ArrayList<Content>();
	User author;
	String title;
	String text;
	ImageIcon image;
	LocalDateTime dateObj;
	Boolean isValid;
	
	
	public Content(User author, String title, String text, ImageIcon image){
		this.author = author;
		this.title = title.strip();
		this.text = text;
		this.image = image;
		LocalDateTime dateObj = LocalDateTime.now();
		this.dateObj = dateObj;
		
		if (Content.contentList.contains(this)) { // If the users list already has the user with the same nickname do not add the user to the list
			// .contains() method uses .equals() on the objects and the .equals() method of User class is solely dependent on the nickname
			// therefore this set does not accept any Users with the same nickname.
			System.out.printf("This Content isAlready created %s\n", this.getTitle());
			isValid = false;
		}
		else {
			Content.contentList.add(this); // Add the created user to the users list
			isValid = true;
		}
	}
	
	public String DateToString() {
		DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return this.dateObj.format(Formatter);
	}
	
	/**
	 * @return the contentList
	 */
	public static ArrayList<Content> getcontentList() {
		return contentList;
	}

	/**
	 * @param contentList the contentList to set
	 */
	public static void setcontentList(ArrayList<Content> contentList) {
		Content.contentList = contentList;
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
	 * @return the dateObj
	 */
	public LocalDateTime getDateObj() {
		return dateObj;
	}

	/**
	 * @param dateObj the dateObj to set
	 */
	public void setDateObj(LocalDateTime dateObj) {
		this.dateObj = dateObj;
	}

	/**
	 * @return the isValid
	 */
	public Boolean IsValid() {
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	// Used references for hashCode() and equals():
	// https://www.sitepoint.com/implement-javas-equals-method-correctly/
	// https://stackoverflow.com/questions/27581/what-issues-should-be-considered-when-overriding-equals-and-hashcode-in-java
	// Generated with eclipse
	@Override
	public int hashCode() {
		return Objects.hash(title);
	}
	
	// Generated with eclipse
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { // Check if both pointers are pointing to the same memory location, implements reflexivity
			return true;
		}
		if (obj == null) { // Return false if compared with null
			return false;
		}
		if (getClass() != obj.getClass()) { // Return false if the classes are different
			return false;
		}
		Content other = (Content) obj;
		return Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "Content [author=" + author + ", title=" + title + ", text=" + text + ", date=" + this.DateToString() + "]";
	}
}
	
