package com.example.rg.rg_foods_backend.repository;

import com.example.rg.rg_foods_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    // Because it has already methods like inbuild so we can access it...
    User findByEmail(String email);
}
