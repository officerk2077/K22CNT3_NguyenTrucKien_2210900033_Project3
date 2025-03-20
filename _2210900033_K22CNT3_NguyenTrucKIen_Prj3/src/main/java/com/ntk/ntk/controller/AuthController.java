package com.ntk.ntk.controller;

import com.ntk.ntk.model.User;
import com.ntk.ntk.model.VaiTro;
import com.ntk.ntk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "home/login";
    }

    @PostMapping("/doLogin")
    public String login(@RequestParam("email") String email,
                        @RequestParam("matkhau") String matkhau,
                        Model model) {
        // Find user by email
        User user = userService.getUserByEmail(email)
                .orElse(null);

        // Check if user exists and password matches
        if (user == null || !userService.getPasswordEncoder().matches(matkhau, user.getMatKhau())) {
            model.addAttribute("error", "Email hoặc mật khẩu không đúng!");
            return "home/login";
        }

        // Create authentication token
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user,
                null,
                user.getAuthorities()
        );

        // Set authentication in SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Redirect based on role
        if (user.getVaiTro() == VaiTro.ADMIN) {
            return "redirect:/admin";
        } else {
            return "redirect:/home";
        }
    }

    @GetMapping("/signup")
    public String registerPage() {
        return "home/signup";
    }

    @PostMapping("/register")
    public String register(@RequestParam("tennguoidung") String tennguoidung,
                           @RequestParam("email") String email,
                           @RequestParam("matkhau") String matkhau,
                           Model model) {
        // Kiểm tra xem email đã tồn tại chưa
        if (userService.getUserByEmail(email).isPresent()) {
            model.addAttribute("error", "Email đã tồn tại!");
            return "home/signup";
        }

        // Kiểm tra xem tennguoidung đã tồn tại chưa
        if (userService.getUserByTenNguoiDung(tennguoidung).isPresent()) {
            model.addAttribute("error", "Tên người dùng đã tồn tại!");
            return "home/signup";
        }

        // Tạo người dùng mới
        User user = new User();
        user.setTenNguoiDung(tennguoidung);
        user.setEmail(email);
        user.setMatKhau(matkhau); // Password will be encoded in UserService
        user.setVaiTro(VaiTro.USER); // Mặc định là User

        // Lưu vào database
        userService.saveUser(user);

        // Đăng nhập tự động
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user,
                null,
                user.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Chuyển hướng dựa trên vai trò
        if (user.getVaiTro() == VaiTro.ADMIN) {
            return "redirect:/admin";
        } else {
            return "redirect:/home";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Clear the security context
        SecurityContextHolder.getContext().setAuthentication(null);
        // Invalidate the session
        request.getSession().invalidate();
        return "redirect:/login?logout";
    }
}