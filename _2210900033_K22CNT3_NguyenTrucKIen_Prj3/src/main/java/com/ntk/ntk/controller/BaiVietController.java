package com.ntk.ntk.controller;

import com.ntk.ntk.dto.BaivietDTO;
import com.ntk.ntk.model.Baiviet;
import com.ntk.ntk.model.User;
import com.ntk.ntk.service.BaiVietService;
import com.ntk.ntk.service.UserService; // Thêm import cho UserService
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/admin/baiviet")
public class BaiVietController {

    @Autowired
    private BaiVietService baivietService;

    @Autowired
    private UserService userService; // Tiêm UserService

    // Read: List all articles
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list_baiviet", baivietService.getBaivietList());
        return "admin/baiviet/index";
    }

    // Create: Show create form
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("baivietDTO", new BaivietDTO());
        return "admin/baiviet/create";
    }

    // Create/Update: Save article
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("baivietDTO") BaivietDTO baivietDTO) {
        Baiviet baiviet = baivietService.convertToEntity(baivietDTO);
        baivietService.saveBaiviet(baiviet);
        return "redirect:/admin/baiviet";
    }

    // Read: Show article details
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Baiviet baiviet = baivietService.getBaivietById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Baiviet ID: " + id));
        model.addAttribute("baiviet", baiviet);
        return "admin/baiviet/show";
    }

    // Update: Show edit form
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        // Lấy bài viết cần chỉnh sửa
        Baiviet baiviet = baivietService.getBaivietById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Baiviet ID: " + id));

        // Chuyển đổi sang DTO
        BaivietDTO baivietDTO = new BaivietDTO();
        baivietDTO.setId(baiviet.getId());
        baivietDTO.setTieuDe(baiviet.getTieuDe());
        baivietDTO.setNoiDung(baiviet.getNoiDung());
        baivietDTO.setMaUser(baiviet.getMaUser());
        baivietDTO.setNgayXuatBan(baiviet.getNgayXuatBan());
        baivietDTO.setTheLoai(baiviet.getTheLoai());

        // Lấy danh sách người dùng
        List<User> listUser = userService.findAll();

        // Thêm vào model
        model.addAttribute("baivietDTO", baivietDTO);
        model.addAttribute("listUser", listUser); // Truyền danh sách người dùng vào model

        return "admin/baiviet/edit";
    }

    // Delete: Delete article
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        baivietService.deleteBaiviet(id);
        return "redirect:/admin/baiviet";
    }
}