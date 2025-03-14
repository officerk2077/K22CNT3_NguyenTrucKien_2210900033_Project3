package com.ntk.ntk.service;

import com.ntk.ntk.dto.UserDTO;
import com.ntk.ntk.model.User;
import com.ntk.ntk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Read: Lấy danh sách tất cả người dùng
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    // Read: Lấy người dùng theo ID
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Create/Update: Lưu người dùng
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Delete: Xóa người dùng
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // Chuyển đổi từ DTO sang Entity
    public User convertToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setTenNguoiDung(dto.getTenNguoiDung());
        user.setEmail(dto.getEmail());
        user.setMatKhau(dto.getMatKhau());
        return user;
    }
}