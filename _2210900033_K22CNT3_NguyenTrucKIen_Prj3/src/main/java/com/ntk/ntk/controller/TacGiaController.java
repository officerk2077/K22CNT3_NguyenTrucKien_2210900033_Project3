package com.ntk.ntk.controller;

import com.ntk.ntk.dto.TacGiaDTO;
import com.ntk.ntk.model.Tacgia;
import com.ntk.ntk.service.TacgiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/admin/tacgia")
public class TacGiaController {

    @Autowired
    private TacgiaService tacgiaService;

    // Read: Danh sách tác giả
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list_tacgia", tacgiaService.getTacgiaList());
        return "admin/tacgia/index";
    }

    // Create: Hiển thị form thêm mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("tacGiaDTO", new TacGiaDTO());
        return "admin/tacgia/create";
    }

    // Create/Update: Lưu tác giả
    @PostMapping("/save")
    public String save(@ModelAttribute("tacGiaDTO") TacGiaDTO tacGiaDTO) {
        Tacgia tacgia = tacgiaService.convertToEntity(tacGiaDTO);
        tacgiaService.saveTacgia(tacgia);
        return "redirect:/admin/tacgia";
    }

    // Read: Hiển thị chi tiết tác giả
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Tacgia tacgia = tacgiaService.getTacgiaById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Tacgia ID: " + id));
        model.addAttribute("tacgia", tacgia);
        return "admin/tacgia/show";
    }

    // Update: Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Tacgia tacgia = tacgiaService.getTacgiaById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Tacgia ID: " + id));
        TacGiaDTO tacGiaDTO = new TacGiaDTO();
        tacGiaDTO.setId(tacgia.getId());
        tacGiaDTO.setTenTacGia(tacgia.getTenTacGia());
        tacGiaDTO.setThongTinLienHe(tacgia.getThongTinLienHe());
        tacGiaDTO.setTrangThai(tacgia.getTrangThai());
        model.addAttribute("tacGiaDTO", tacGiaDTO);
        return "admin/tacgia/edit";
    }

    // Delete: Xóa tác giả
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        tacgiaService.deleteTacgia(id);
        return "redirect:/admin/tacgia";
    }
}