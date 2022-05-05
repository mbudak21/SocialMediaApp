package api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.File;  // Import the File class
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class User {
	static public Set<User> users;
	//Must have fields
	final String nickname; // nickname is unique to every user.
	String password;
	String name;
	String surname;
	int age;
	String email;
	
	//Other fields
	Set<User> followers;
	Set<User> following;
	Set<Group> groupsJoined;
	Set<Content> posts;
	Boolean isPremium = false;
	Set<Group> groupsCreated; // If the user is premium
	
	
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
	
	User(String nickname, String password, String name, String surname, int age, String email){
		try {
			User.users.add(this); // Add the created user to the users list
		}
		catch(IOException eio)
	    {
	        //do something
	    }
		this.nickname 	= nickname;
		this.password 	= password;
		this.name 		= name;
		this.surname	= surname;
		this.age 		= age;
		this.email 		= email;

	}
	public static void writeToFile(File path, Set<User> data)
	{
		
	    try(ObjectOutputStream write= new ObjectOutputStream (new FileOutputStream(path)))
	    {
	        write.writeObject(data);
	    }
	    catch(IOException eio)
	    {
	        //do something
	    }
	}


	public static Set<User> readFromFile(File path)
	{
		Set<User> data = null;

	    try(ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(path)))
	    {
	        data = (Set<User>) inFile.readObject();
	        return data;
	    }
	    catch(ClassNotFoundException cnfe)
	    {
	        //do something
	    }
	    catch(FileNotFoundException fnfe)
	    {
	        System.out.println("File Not Found!");
	    }
	
	
}
