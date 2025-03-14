package com.ntk.ntk.controller;

import com.ntk.ntk.dto.BaiVietDTO;
import com.ntk.ntk.model.Baiviet;
import com.ntk.ntk.service.BaiVietService;
import com.ntk.ntk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/admin/baiviet")
public class BaiVietController {

    @Autowired
    private BaiVietService baiVietService;

    @Autowired
    private UserService userService;

    // Read: Danh sách bài viết
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list_baiviet", baiVietService.getBaiVietList());
        return "admin/baiviet/index";
    }

    // Create: Hiển thị form thêm mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("baiVietDTO", new BaiVietDTO());
        model.addAttribute("listUser", userService
                .getUserList());
        return "admin/baiviet/create";
    }

    // Create/Update: Lưu bài viết
    @PostMapping("/save")
    public String save(@ModelAttribute("baiVietDTO") BaiVietDTO baiVietDTO) {
        Baiviet baiViet = baiVietService.convertToEntity(baiVietDTO);
        baiVietService.saveBaiViet(baiViet);
        return "redirect:/admin/baiviet";
    }

    // Read: Hiển thị chi tiết bài viết
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Baiviet baiViet = baiVietService.getBaiVietById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid BaiViet ID: " + id));
        model.addAttribute("baiViet", baiViet);
        return "admin/baiviet/show";
    }

    // Update: Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Baiviet baiViet = baiVietService.getBaiVietById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid BaiViet ID: " + id));
        BaiVietDTO baiVietDTO = new BaiVietDTO();
        baiVietDTO.setId(baiViet.getId());
        baiVietDTO.setTieuDe(baiViet.getTieuDe());
        baiVietDTO.setNoiDung(baiViet.getNoiDung());
        baiVietDTO.setMaUser(baiViet.getMaUser() != null ? baiViet.getMaUser().getId() : null);
        baiVietDTO.setNgayXuatBan(baiViet.getNgayXuatBan());
        baiVietDTO.setTheLoai(baiViet.getTheLoai());

        model.addAttribute("baiVietDTO", baiVietDTO);
        model.addAttribute("listUser", userService.getUserList());
        return "admin/baiviet/edit";
    }

    // Delete: Xóa bài viết
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        baiVietService.deleteBaiViet(id);
        return "redirect:/admin/baiviet";
    }
}