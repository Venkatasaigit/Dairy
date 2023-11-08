package project.repository;

import java.util.List;

import project.entity.User;



public interface UserService {
	
	public  User saveUser(User user);
	public User updateUser (long id,User user);
	public void deleteUser(long id,User user);
	public User findById(long id);
	public List<User> findAll();
	

}
