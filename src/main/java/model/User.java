package model;

import java.util.ArrayList;

public class User {

	private String name;
	private String login;
	private String password;
	private int role;
	private ArrayList<Integer> group = new ArrayList<Integer>();

	public User(String name, String login, String password, int role, String groups) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.role = role;

		int delimCount = groups.length() % 4;

		if (role == 0 & delimCount == 0)
			group.add(Integer.getInteger(groups));

		int startIdx = 0;
		int endIdx = 4;

		for (int i = 0; i <= delimCount; i++) {
			group.add(Integer.parseInt(groups.substring(startIdx, endIdx)));
			startIdx += 5;
			endIdx += 5;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}