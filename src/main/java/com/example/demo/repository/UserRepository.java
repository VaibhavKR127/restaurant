package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("from User where uemail=?1")
	public User findByEmail(String uemail);

	@Query("from User where uname like %?%1")
	public List<User> findByUsername(String username);

//	public List<Booking> findByUserId(Long userId);
}
