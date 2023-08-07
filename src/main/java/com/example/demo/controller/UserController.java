package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.ServiceImplementations;

@RestController
@RequestMapping("user")
public class UserController {
	
	private ServiceImplementations serimp;
	
	@Autowired
	public UserController(ServiceImplementations serimp) {
		this.serimp = serimp;
	}

	@GetMapping("/list")
	public List<User> displayAllUser(){
		List<User> restList = serimp.getAllUser();
 		
		return restList;
	}

	@GetMapping("list/{id}")
	public User displayById(@PathVariable("id") int id) {
		User user = serimp.getUserById(id);
		if(user==null) {
			throw new RuntimeException("User not found with this Id");
		}
		return user;
	}


	@PostMapping("/list")
	public void insertUser(@RequestBody User rest) {
		serimp.addUser(rest);
	}

	@DeleteMapping("/list/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		serimp.deleteUser(id);
	}
	
	@PutMapping("/list")
	public void updateUser(@RequestBody User user) {
		serimp.updateUser(user);
	}
	
	@GetMapping("/list1/{email}")
	public boolean userExists(@PathVariable("email") String email) {
	     return serimp.userExists(email);
	  }
	
	@GetMapping("/list2/{email}")
	public User userByEmail(@PathVariable("email") String email) {
	     return serimp.getByemail(email);
	  }
	  
	
	@GetMapping("/list3/{uname}")
	public List<User> userByUsername(@PathVariable("uname") String uname) {
	     return serimp.findByUsername(uname);
	  }
	
	@GetMapping("list4/{uemail}/{upass}")
	public User enUser(@PathVariable("uemail") String uemail,@PathVariable("upass") String pass) {
		return serimp.enuser(uemail,pass);
	}
//	public List<User> getAllUser();
//	public User getUserById(int uid);
//	public User addUser(User user);
//	public User updateUser(User user);
//	public void deleteUser(int bid);
//	 
}
