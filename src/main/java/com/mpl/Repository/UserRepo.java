package com.mpl.Repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpl.Model.User;

public interface UserRepo extends JpaRepository<User, Serializable>{

	 Optional<User> findByUsername(String username);
}
