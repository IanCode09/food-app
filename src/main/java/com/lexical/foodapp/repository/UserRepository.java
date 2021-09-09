package com.lexical.foodapp.repository;

import com.lexical.foodapp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query(value = "SELECT * FROM tab_user WHERE email = ?", nativeQuery = true)
    List<UserModel> findByEmail(String email);
}
