package api;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.swing.ImageIcon;

import gui.ContentPanel;

public class User {
	static Set<User> users = new HashSet<User>();
	//Must have fields
	final String nickname; // nickname is unique to every user.
	String password;
	String name;
	String surname;
	int age;
	String email;
	String dateOfBirth;
	ImageIcon profilePhoto;
	
	//Other fields
	Set<User> UsersWhoFollowThis = new HashSet<User>(); // users who follow the instance
	Set<User> UsersWhoThisFollows = new HashSet<User>(); // 
	Set<Group> groupsJoined = new HashSet<Group>();
	ArrayList<Content> contentCreated = new ArrayList<Content>();
	Boolean isPremium = false;
	Set<Group> groupsCreated = new HashSet<Group>(); // If the user is premium
	
	
	//Image profilePhoto; if not default it
	/*
	 * Users can search other users and groups, follow other users, unfollow users, join groups,
		leave groups, post content to group pages or their personal page.
		They can search posts by title inside a group page, and a user page they follow.
		They can delete the posts that they created. They can change their personal information
		with the exception of their nickname. They can delete their account and they can ask the
		app to suggest friends and groups.
		Users can either be Standard or Premium. In addition to standard, premium users can
		create groups, delete groups they created, and remove users from groups they created.
	 */
	
	public User(String nickname, String password, String name, String surname, String email, int age, ImageIcon profilePhoto){
		this.nickname		= nickname;
		this.password		= password;
		this.name			= name;
		this.surname		= surname;
		this.email			= email;
		this.age			= age;
		
		// Default the photo if the input it null
		if (profilePhoto == null) {
			this.profilePhoto = new ImageIcon(ContentPanel.class.getResource("/gui/images/defaultUserProfilePicture.png"));
		}
		else {
			this.profilePhoto = profilePhoto;
		}


		if (User.users.contains(this)) { // If the users list already has the user with the same nickname do not add the user to the list
			// .contains() method uses .equals() on the objects and the .equals() method of User class is solely dependent on the nickname
			// therefore this set does not accept any Users with the same nickname.
			System.out.printf("This Username is Already taken %s", this.getNickname());
			
		}
		else {
			User.users.add(this); // Add the created user to the users list
		}
	} // End of constructor
	
	public boolean createContent(String title, String text, ImageIcon image) {
		Content content = new Content(this, title, text, image);
		if (content.IsValid()) {
			contentCreated.add(content);
			return true;

		}
		else {
			// Title has already been taken
			return true;
		}

	}
	
	
	public static User Login(String nickname, String password) {
		if (User.match(nickname) == true) {
		    for(User user : User.getUsers()) {
		    	//System.out.printf("%s: %b, %b\n",user.getNickname(), user.getNickname() == nickname,user.getPassword() == password);
		    	if(user.getNickname().equals(nickname) && user.getPassword().equals(password)) {
		    		return user;
		    	}
		    }
		}
		return null;
	}
	public static ArrayList<User> search(String nickname) {
		ArrayList<User> usersFound = new ArrayList<User>();
	    for(User user : User.getUsers()) {
	    	if(user.getNickname().contains(nickname) || nickname.contains(user.getNickname())) {
	    		usersFound.add(user);
	    	}
	    }
	    return usersFound;
	}
	
	public static Boolean match(String nickname) {
	    for(User user : User.getUsers()) {
	    	if(user.getNickname().equals(nickname)) {
	    		return true;
	    	}
	    }
	    	return false;
	}
	
	public Boolean follow(User other) {
		if(this.getUsersWhoThisFollows().contains(other)) {
			return false;
		}
		else {
			this.getUsersWhoThisFollows().add(other);
			return true;
		}
	}
	
	public Boolean unfollow(User other) {
		if(this.getUsersWhoThisFollows().contains(other)) {
			this.getUsersWhoThisFollows().remove(other);
			return true;
		}
		else {
			return false;
		}
	}


	// Used references for hashCode() and equals():
	// https://www.sitepoint.com/implement-javas-equals-method-correctly/
	// https://stackoverflow.com/questions/27581/what-issues-should-be-considered-when-overriding-equals-and-hashcode-in-java
	// Generated with eclipse
	@Override
	public int hashCode() {
		return Objects.hash(nickname);
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
		User other = (User) obj;
		return Objects.equals(nickname, other.nickname);
	}


	@Override
	public String toString() {
		return "User [nickname=" + nickname + "]";
	}


	/**
	 * @return the users
	 */
	public static Set<User> getUsers() {
		return users;
	}


	/**
	 * @param users the users to set
	 */
	public static void setUsers(Set<User> users) {
		User.users = users;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}


	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the isPremium
	 */
	public Boolean getIsPremium() {
		return isPremium;
	}


	/**
	 * @param isPremium the isPremium to set
	 */
	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}


	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}


	/**
	 * @return the Users who follow this instance
	 */
	public Set<User> getUsersWhoFollowThis() {
		return UsersWhoFollowThis;
	}


	/**
	 * @return the Users which are being followed by this instance
	 */
	public Set<User> getUsersWhoThisFollows() {
		return UsersWhoThisFollows;
	}


	/**
	 * @return the groupsJoined
	 */
	public Set<Group> getGroupsJoined() {
		return groupsJoined;
	}


	/**
	 * @return the postsCreated
	 */
	public ArrayList<Content> getContentCreated() {
		return contentCreated;
	}


	/**
	 * @return the profilePhoto
	 */
	public ImageIcon getProfilePhoto() {
		return profilePhoto;
	}

	/**
	 * @param profilePhoto the profilePhoto to set
	 */
	public void setProfilePhoto(ImageIcon profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	/**
	 * @return the groupsCreated
	 */
	public Set<Group> getGroupsCreated() {
		return groupsCreated;
	}


	

//	public static void writeToFile(File path, Set<User> data)
//	{
//		
//	    try(ObjectOutputStream write= new ObjectOutputStream (new FileOutputStream(path)))
//	    {
//	        write.writeObject(data);
//	    }
//	    catch(IOException eio)
//	    {
//	        //do something
//	    }
//	}
//	public static Set<User> readFromFile(File path)
//	{
//		Set<User> data = null;
//
//	    try(ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(path)))
//	    {
//	        data = (Set<User>) inFile.readObject();
//	        return data;
//	    }
//	    catch(ClassNotFoundException cnfe)
//	    {
//	        //do something
//	    }
//	    catch(FileNotFoundException fnfe)
//	    {
//	        System.out.println("File Not Found!");
//	    }
//	}
}
