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
		// TODO �Զ����ɵķ������
		return false;
	}

	@Override
	public User findUserName(int id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public boolean login() {
		// TODO �Զ����ɵķ������
		
		User user = new User();
		return false;
	}

	@Override
	public boolean changePassword() {
		// TODO �Զ����ɵķ������
		return false;
	}

}
