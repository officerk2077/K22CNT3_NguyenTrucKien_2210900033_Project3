package com.ntk.ntk.controller;

import com.ntk.ntk.dto.SachDTO;
import com.ntk.ntk.model.Sach;
import com.ntk.ntk.service.SachService;
import com.ntk.ntk.service.TacgiaService;
import com.ntk.ntk.service.NhaXuatBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/admin/sach")
public class SachController {

    @Autowired
    private SachService sachService;

    @Autowired
    private TacgiaService tacgiaService;

    @Autowired
    private NhaXuatBanService nhaXuatBanService;

    // Read: Danh sách sách
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list_sach", sachService.getSachList());
        return "admin/sach/index";
    }

    // Create: Hiển thị form thêm mới
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("sachDTO", new SachDTO());
        model.addAttribute("listTacgia", tacgiaService.getTacgiaList());
       model.addAttribute("listNhaXuatBan", nhaXuatBanService.getNhaXuatBanList());
        return "admin/sach/create";
    }

    // Create/Update: Lưu sách
    @PostMapping("/save")
    public String save(@ModelAttribute("sachDTO") SachDTO sachDTO) {
        Sach sach = sachService.convertToEntity(sachDTO);
        sachService.saveSach(sach);
        return "redirect:/admin/sach";
    }

    // Read: Hiển thị chi tiết sách
    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Sach sach = sachService.getSachById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Sach ID: " + id));
        model.addAttribute("sach", sach);
        return "admin/sach/show";
    }

    // Update: Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Sach sach = sachService.getSachById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Sach ID: " + id));
        SachDTO sachDTO = new SachDTO();
        sachDTO.setId(sach.getId());
        sachDTO.setTieuDe(sach.getTieuDe());
        sachDTO.setNamXuatBan(sach.getNamXuatBan());
        sachDTO.setSoTrang(sach.getSoTrang());
        sachDTO.setMoTa(sach.getMoTa());
        sachDTO.setMaTacGia(sach.getMaTacGia() != null ? sach.getMaTacGia().getId() : null);
        sachDTO.setMaNhaXuatBan(sach.getMaNhaXuatBan() != null ? sach.getMaNhaXuatBan().getId() : null);

        model.addAttribute("sachDTO", sachDTO);
        model.addAttribute("listTacgia", tacgiaService.getTacgiaList());
        model.addAttribute("listNhaXuatBan", nhaXuatBanService.getNhaXuatBanList());
        return "admin/sach/edit";
    }

    // Delete: Xóa sách
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        sachService.deleteSach(id);
        return "redirect:/admin/sach";
    }
}