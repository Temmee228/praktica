package com.example.demo.repository;

import com.example.demo.model.TournamentModel;
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
    List<UserModel> findByNameContaining(@Param("name") String name);

    List<UserModel> findByGrade(String grade);

    List<UserModel> findByCity(String city);

    @Query("SELECT p FROM UserModel p WHERE p.name LIKE %:name% AND p.surname LIKE %:surname% AND p.patronymic LIKE %:patronymic%")
    List<UserModel> findByName(@Param("name") String name,@Param("surname") String surname,@Param("patronymic") String patronymic);

    @Query("SELECT p FROM UserModel p WHERE p.name LIKE %:name% AND p.surname LIKE %:surname%")
    List<UserModel> findByName2(@Param("name") String name,@Param("surname") String surname);

    @Modifying
    @Query("UPDATE UserModel u SET u.banned = true, u.banReason = :banReason WHERE u.username = :username")
    void banUser(@Param("username") String username, @Param("banReason") String banReason);
}
