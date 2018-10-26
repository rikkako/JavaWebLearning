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
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public User findUserName(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public boolean login() {
		// TODO 自动生成的方法存根
		
		User user = new User();
		return false;
	}

	@Override
	public boolean changePassword() {
		// TODO 自动生成的方法存根
		return false;
	}

}
