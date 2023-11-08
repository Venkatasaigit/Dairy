package project.repository;

import java.util.List;

import project.entity.User;



public interface UserService {
	
	public  User saveUser(User user);
	public User updateUser (Long id,User user);
	public void deleteUser(Long id,User user);
	public User findById(Long id);
	public List<User> findAll();
	

}
