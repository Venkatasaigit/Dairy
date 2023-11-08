package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.entity.Memory;
import project.entity.User;
import project.service.EntryServiceImpl;
import project.service.UserServiceImpl;


@RestController
public class HomeController {
	@Autowired
	private EntryServiceImpl noteservice;
	
	@PostMapping("/note")
	public Memory saveEntry(@RequestBody Memory memory) {
		return noteservice.saveEntry(memory);
	}
	
	@PutMapping("/note/{id}")
	Memory updateEntry(@PathVariable("id")Long id,@RequestBody Memory memory) {
		return noteservice.updateEntry(id, memory);
	}
	
	@DeleteMapping("/note/{id}")
	public void deleteEntry(@PathVariable("id")Long id) {
		noteservice.deleteEntry(id);
	}
	
	@PostMapping("/adduser/{id}/{id}")
	public String assignUserToNotes(@PathVariable("id")Long uid,@PathVariable("id") Long fid) {
		return noteservice.assignUserToNotes(uid, fid);
	}
	
	@GetMapping("/notes")
	public List<Memory>findAll(){
		return noteservice.findAll();
	}
	
	@GetMapping("/notes/{id}")
	public Memory findById(@PathVariable("id")long id) {
		return noteservice.findById(id);
	}


	//=====user
	@Autowired
	private UserServiceImpl userservice;
	
	@PostMapping("/user")
	public  User saveUser(@RequestBody User user) {
		return userservice.saveUser(user);	
	}
	
	@PutMapping("/User/{id}")
	public User updateUser (@PathVariable("id")Long id,@RequestBody User user) {
		return userservice.updateUser(id, user);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable("id")Long id,User user) {
		 userservice.deleteUser(id, user);
	}
	
	@GetMapping("/user/{id}")
	public User findByuserId(@PathVariable("id")Long id) {
		return userservice.findById(id);
	}
	
	@GetMapping("/Allusers")
	public List<User> findAlluser(){
		return userservice.findAll();
	}
	
}
