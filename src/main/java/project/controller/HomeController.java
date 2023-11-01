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

import project.entity.Feeds;
import project.entity.User;
import project.service.EntryServiceImpl;
import project.service.UserServiceImpl;


@RestController
public class HomeController {
	@Autowired
	private EntryServiceImpl noteservice;
	
	@PostMapping("/note")
	public Feeds saveEntry(@RequestBody Feeds feeds) {
		return noteservice.saveEntry(feeds);
	}
	
	@PutMapping("/note/{id}")
	Feeds updateEntry(@PathVariable("id")long id,@RequestBody Feeds feeds) {
		return noteservice.updateEntry(id, feeds);
	}
	
	@DeleteMapping("/note/{id}")
	public void deleteEntry(@PathVariable("id")long id) {
		noteservice.deleteEntry(id);
	}
	
	@PostMapping("/adduser/{id}/{id}")
	public String assignUserToNotes(@PathVariable("id")long uid,@PathVariable("id") long fid) {
		return noteservice.assignUserToNotes(uid, fid);
	}
	
	@GetMapping("/notes")
	public List<Feeds>findAll(){
		return noteservice.findAll();
	}
	
	@GetMapping("/notes/{id}")
	public Feeds findById(@PathVariable("id")long id) {
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
	public User updateUser (@PathVariable("id")long id,@RequestBody User user) {
		return userservice.updateUser(id, user);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public void deleteUser(@PathVariable("id")long id,User user) {
		 userservice.deleteUser(id, user);
	}
	
	@GetMapping("/user/{id}")
	public User findByuserId(@PathVariable("id")long id) {
		return userservice.findById(id);
	}
	
	@GetMapping("/Allusers")
	public List<User> findAlluser(){
		return userservice.findAll();
	}
	
}
