package com.example.MedicalStoreAPP.repository;


import com.example.MedicalStoreAPP.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
                User findByEmail(String Email);
                User findByUserName(String username);
}
