package com.example9.repository;

import com.example9.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User getUserByUsername(String username);
}
