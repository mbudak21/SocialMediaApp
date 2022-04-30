package api;

import java.io.File;  // Import the File class
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
	static public List<?> users;
	final String nickname; // nickname is unique to every user.
	// final String ID;	
	String password;
	String name;
	String surname;
	int age;
	String email;
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
		this.nickname 	= nickname;
		this.password 	= password;
		this.name 		= name;
		this.surname	= surname;
		this.age 		= age;
		this.email 		= email;
		
		
		
	}
	
}
