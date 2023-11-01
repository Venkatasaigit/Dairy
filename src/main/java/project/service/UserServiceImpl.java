package project.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import project.entity.Feeds;
import project.entity.User;
import project.jparepository.UserRepository;
import project.repository.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userdao;
	
	@Override
	public User saveUser(User user) {
		userdao.save(user);
		return user; 
	}

	@Override
	public User updateUser(long id,User user) {
		try {
			User note=userdao.findById(id).get();
			if(note.getUsername()!=null)
			{
				note.setUsername(user.getUsername());;
			}
			userdao.save(user);
			return user;
			}
			catch(Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
	}

	@Override
	public void deleteUser(long id,User user) {
		try{
			userdao.deleteById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public User findById(long id) {
		User note=userdao.findById(id).get();
		return note;
		
	}

	@Override
	public List<User> findAll() {
		List<User> notes= userdao.findAll();
		return notes;
		
	}



}
