package service;

import model.User;

public interface UserService {

	public boolean register();
	public User findUser(int id);
	public String findName(String userid);
	public int login(User user);
	public boolean changePassword();
}
