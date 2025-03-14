package com.ntk.ntk.controller;

import com.ntk.ntk.dto.UserDTO;
import com.ntk.ntk.model.User;
import com.ntk.ntk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Read: Danh sách người dùng
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list_user", userService.getUserList());
        return "admin/user/index";
    }

    // Create: Hiển thị form thêm mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "admin/user/create";
    }

    // Create/Update: Lưu người dùng
    @PostMapping("/save")
    public String save(@ModelAttribute("userDTO") UserDTO userDTO) {
        User user = userService.convertToEntity(userDTO);
        userService.saveUser(user);
        return "redirect:/admin/user";
    }

    // Read: Hiển thị chi tiết người dùng
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID: " + id));
        model.addAttribute("user", user);
        return "admin/user/show";
    }

    // Update: Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User ID: " + id));
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setTenNguoiDung(user.getTenNguoiDung());
        userDTO.setEmail(user.getEmail());
        userDTO.setMatKhau(user.getMatKhau());

        model.addAttribute("userDTO", userDTO);
        return "admin/user/edit";
    }

    // Delete: Xóa người dùng
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin/user";
    }
}