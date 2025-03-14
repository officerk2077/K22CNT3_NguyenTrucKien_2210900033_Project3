package com.ntk.ntk.controller;

import com.ntk.ntk.dto.NhaXuatBanDTO;
import com.ntk.ntk.model.Nhaxuatban;
import com.ntk.ntk.service.NhaXuatBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/admin/nhaxuatban")
public class NhaXuatBanController {

    @Autowired
    private NhaXuatBanService nhaXuatBanService;

    // Read: Danh sách nhà xuất bản
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list_nhaxuatban", nhaXuatBanService.getNhaXuatBanList());
        return "admin/nhaxuatban/index";
    }

    // Create: Hiển thị form thêm mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("nhaXuatBanDTO", new NhaXuatBanDTO());
        return "admin/nhaxuatban/create";
    }

    // Create/Update: Lưu nhà xuất bản
    @PostMapping("/save")
    public String save(@ModelAttribute("nhaXuatBanDTO") NhaXuatBanDTO nhaXuatBanDTO) {
        Nhaxuatban nhaXuatBan = nhaXuatBanService.convertToEntity(nhaXuatBanDTO);
        nhaXuatBanService.saveNhaXuatBan(nhaXuatBan);
        return "redirect:/admin/nhaxuatban";
    }

    // Read: Hiển thị chi tiết nhà xuất bản
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Nhaxuatban nhaXuatBan = nhaXuatBanService.getNhaXuatBanById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Nhaxuatban ID: " + id));
        model.addAttribute("nhaXuatBan", nhaXuatBan);
        return "admin/nhaxuatban/show";
    }

    // Update: Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Nhaxuatban nhaXuatBan = nhaXuatBanService.getNhaXuatBanById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Nhaxuatban ID: " + id));
        NhaXuatBanDTO nhaXuatBanDTO = new NhaXuatBanDTO();
        nhaXuatBanDTO.setId(nhaXuatBan.getId());
        nhaXuatBanDTO.setTenNhaXuatBan(nhaXuatBan.getTenNhaXuatBan());
        nhaXuatBanDTO.setDiaChi(nhaXuatBan.getDiaChi());

        model.addAttribute("nhaXuatBanDTO", nhaXuatBanDTO);
        return "admin/nhaxuatban/edit";
    }

    // Delete: Xóa nhà xuất bản
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        nhaXuatBanService.deleteNhaXuatBan(id);
        return "redirect:/admin/nhaxuatban";
    }
}