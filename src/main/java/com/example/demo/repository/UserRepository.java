package com.example.demo.repository;

import com.example.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    List<UserModel> findByNameContaining(String name);

    List<UserModel> findByGrade(String grade);

    List<UserModel> findByCity(String city);


    @Modifying
    @Query("UPDATE UserModel u SET u.banned = true, u.banReason = :banReason WHERE u.username = :username")
    void banUser(@Param("username") String username, @Param("banReason") String banReason);
}
