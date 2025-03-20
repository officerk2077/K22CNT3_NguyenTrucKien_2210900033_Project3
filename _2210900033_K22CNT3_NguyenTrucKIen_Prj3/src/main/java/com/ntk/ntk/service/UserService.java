package com.ntk.ntk.service;

import com.ntk.ntk.dto.UserDTO;
import com.ntk.ntk.model.User;
import com.ntk.ntk.model.VaiTro;
import com.ntk.ntk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Getter for PasswordEncoder
    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    // Read: Get all users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Count: Get total number of users
    public long countTotalUsers() {
        return userRepository.count();
    }

    // Read: Get user by ID
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Read: Get user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Read: Get user by username
    public Optional<User> getUserByTenNguoiDung(String tenNguoiDung) {
        return userRepository.findByTenNguoiDung(tenNguoiDung);
    }

    // Create/Update: Save a user
    public User saveUser(User user) {
        // Encode the password if it's not already encoded
        if (user.getMatKhau() != null && !user.getMatKhau().startsWith("$2a$")) {
            user.setMatKhau(passwordEncoder.encode(user.getMatKhau()));
        }
        // Ensure vaiTro is set (default to USER if not specified)
        if (user.getVaiTro() == null) {
            user.setVaiTro(VaiTro.USER);
        }
        return userRepository.save(user);
    }

    // Create/Update: Save a user from DTO
    public User saveUserFromDTO(UserDTO dto) {
        User user = convertToEntity(dto);
        return saveUser(user);
    }

    // Delete: Delete a user by ID
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Convert DTO to Entity
    public User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setTenNguoiDung(dto.getTenNguoiDung());
        user.setEmail(dto.getEmail());
        user.setMatKhau(dto.getMatKhau());
        user.setVaiTro(dto.getVaiTro());
        return user;
    }

    // Convert Entity to DTO
    public UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setTenNguoiDung(user.getTenNguoiDung());
        dto.setEmail(user.getEmail());
        dto.setMatKhau(user.getMatKhau());
        dto.setVaiTro(user.getVaiTro());
        return dto;
    }
}