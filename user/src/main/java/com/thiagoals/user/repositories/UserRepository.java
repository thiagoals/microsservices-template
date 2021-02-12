package com.thiagoals.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagoals.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
