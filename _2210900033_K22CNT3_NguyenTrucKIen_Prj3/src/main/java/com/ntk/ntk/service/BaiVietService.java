package com.ntk.ntk.service;

import com.ntk.ntk.dto.BaivietDTO;
import com.ntk.ntk.model.Baiviet;
import com.ntk.ntk.model.User;
import com.ntk.ntk.repository.BaiVietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class BaiVietService {

    @Autowired
    private BaiVietRepository baivietRepository;

    @Autowired
    private UserService userService; // Assuming you have a UserService

    public long countTotalPosts() {
        return baivietRepository.count();
    }

    // Read: Get all articles
    public List<Baiviet> getBaivietList() {
        return baivietRepository.findAll();
    }

    // Read: Get article by ID
    public Optional<Baiviet> getBaivietById(Integer id) {
        return baivietRepository.findById(id);
    }

    // Create/Update: Save article
    public Baiviet saveBaiviet(Baiviet baiviet) {
        if (baiviet.getNgayXuatBan() == null) {
            baiviet.setNgayXuatBan(Instant.now());
        }
        return baivietRepository.save(baiviet);
    }

    // Delete: Delete article
    public void deleteBaiviet(Integer id) {
        baivietRepository.deleteById(id);
    }

    // Convert DTO to Entity
    public Baiviet convertToEntity(BaivietDTO dto) {
        Baiviet baiviet = new Baiviet();
        baiviet.setId(dto.getId());
        baiviet.setTieuDe(dto.getTieuDe());
        baiviet.setNoiDung(dto.getNoiDung());
        baiviet.setNgayXuatBan(dto.getNgayXuatBan() != null ? dto.getNgayXuatBan() : Instant.now());
        baiviet.setTheLoai(dto.getTheLoai());
        baiviet.setMaUser(dto.getMaUser());
        return baiviet;
    }
}