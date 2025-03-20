package com.ntk.ntk.repository;

import com.ntk.ntk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    // Find user by tenNguoiDung (username)
    Optional<User> findByTenNguoiDung(String tenNguoiDung);

    // Find user by email (used for login and registration checks)
    Optional<User> findByEmail(String email);
}