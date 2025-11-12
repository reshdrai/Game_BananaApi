package com.resh.gamebananaapi.Repository;

import com.resh.gamebananaapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
