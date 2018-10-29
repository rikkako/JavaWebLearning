package service;

import model.User;

public interface UserService {

	public boolean register();
	public User findUser(int id);
	public boolean login();
	public boolean changePassword();
}
