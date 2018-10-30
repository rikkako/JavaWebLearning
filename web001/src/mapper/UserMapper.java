package mapper;

import model.User;

public interface UserMapper {
	User Login(User user);
	String findName(String id);
}
