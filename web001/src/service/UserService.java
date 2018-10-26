package service;

import model.User;

public interface UserService {

	public boolean register();
	public User findUserName(int id);
	public boolean login();
	public boolean changePassword();
}
