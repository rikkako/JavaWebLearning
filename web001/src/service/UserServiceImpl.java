package service;

import org.apache.ibatis.session.SqlSession;

import mapper.SqlSessionFactoryUtils;
import mapper.UserMapper;
import model.User;

public class UserServiceImpl implements UserService {

	private SqlSession sqlSession = null; 
	UserMapper uMapper;
	public boolean register() {
		
		return false;
	}

	public User findUser(int id) {
		
		
		return null;
	}

	public int login(User user) {
		
		User u = new User();
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			uMapper = sqlSession.getMapper(UserMapper.class);
			u = uMapper.Login(user);
			sqlSession.commit();
			
        } catch (Exception e) {
            e.printStackTrace();
        } finally {            
        	if (sqlSession != null) {
                sqlSession.close();
            }
        }

		if(u!=null){
			return u.getUserType();
		}
		return 0;
		
		
	}

	public boolean changePassword() {

		return false;
	}

	@Override
	public String findName(String userid) {
		// TODO 自动生成的方法存根
		String name = "";
		try {
			sqlSession = SqlSessionFactoryUtils.openSqlSession();
			uMapper = sqlSession.getMapper(UserMapper.class);
			name = uMapper.findName(userid);
			sqlSession.commit();
			
        } catch (Exception e) {
            e.printStackTrace();
        } finally {            
        	if (sqlSession != null) {
                sqlSession.close();
            }
        }

		if(name!=null){
			return name;
		}
		
		return null;
	}

}
