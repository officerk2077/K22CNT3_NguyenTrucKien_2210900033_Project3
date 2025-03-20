package com.ntk.ntk.controller;

import com.ntk.ntk.model.Baiviet;
import com.ntk.ntk.model.Sach;
import com.ntk.ntk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private TacgiaService tacgiaService;

    @Autowired
    private SachService sachService;

    @Autowired
    private BaiVietService baiVietService;

    @Autowired
    private UserService userService;

    @Autowired
    private NhaXuatBanService nhaXuatBanService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("totalAuthors", tacgiaService.countTotalAuthors());
        model.addAttribute("totalBooks", sachService.countTotalBooks());
        model.addAttribute("totalPosts", baiVietService.countTotalPosts());
        model.addAttribute("totalUsers", userService.countTotalUsers());
        model.addAttribute("totalPublisher", nhaXuatBanService.countTotalPublisher());

        List<Sach> sachList = sachService.getSachList();
        model.addAttribute("sachList", sachList);

        List<Baiviet> baiVietList = baiVietService.getBaivietList();
        model.addAttribute("baiVietList", baiVietList);

        return "admin/index";
    }
}