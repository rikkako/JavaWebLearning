package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.User;

public class UserDaoImpl implements UserDao {

	PreparedStatement statement = null;
	DBconn db = new DBconn();
	Connection connection = db.getConn();
	
	@Override
	public boolean register() {
		
		return false;
	}

	@Override
	public User findUserName(int id) {
		
		return null;
	}

	@Override
	public boolean login() {
		
		
		User user = new User();
		return false;
	}

	@Override
	public boolean changePassword() {
		
		return false;
	}

}
