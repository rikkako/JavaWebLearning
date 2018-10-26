package dao;

import model.User;

public interface UserDao {

	public boolean register();
	public User findUserName(int id);
	public boolean login();
	public boolean changePassword();
}
