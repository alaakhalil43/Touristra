package com.Touristra.repositories;

import com.Touristra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("SELECT u FROM Users u WHERE u.username = :username")
//    Optional<User> findUserByUserName(@Param("username") String username);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
