package mapper;

import model.User;

public interface UserMapper {
	public User Login(User user);
	public String findName(String id);
}
