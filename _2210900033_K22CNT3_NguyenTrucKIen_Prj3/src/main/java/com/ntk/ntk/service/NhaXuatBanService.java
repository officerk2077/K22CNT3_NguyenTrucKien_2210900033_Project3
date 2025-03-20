package com.ntk.ntk.service;

import com.ntk.ntk.dto.NhaXuatBanDTO;
import com.ntk.ntk.model.Nhaxuatban;
import com.ntk.ntk.repository.NhaXuatBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaXuatBanService {

    @Autowired
    private NhaXuatBanRepository nhaXuatBanRepository;

    public long countTotalPublisher() {
        return nhaXuatBanRepository.count();
    }

    // Read: Lấy danh sách tất cả nhà xuất bản
    public List<Nhaxuatban> getNhaXuatBanList() {
        return nhaXuatBanRepository.findAll();
    }

    // Read: Lấy nhà xuất bản theo ID
    public Optional<Nhaxuatban> getNhaXuatBanById(Integer id) {
        return nhaXuatBanRepository.findById(id);
    }

    // Create/Update: Lưu nhà xuất bản
    public Nhaxuatban saveNhaXuatBan(Nhaxuatban nhaXuatBan) {
        return nhaXuatBanRepository.save(nhaXuatBan);
    }

    // Delete: Xóa nhà xuất bản
    public void deleteNhaXuatBan(Integer id) {
        nhaXuatBanRepository.deleteById(id);
    }

    // Chuyển đổi từ DTO sang Entity
    public Nhaxuatban convertToEntity(NhaXuatBanDTO dto) {
        Nhaxuatban nhaXuatBan = new Nhaxuatban();
        nhaXuatBan.setId(dto.getId());
        nhaXuatBan.setTenNhaXuatBan(dto.getTenNhaXuatBan());
        nhaXuatBan.setDiaChi(dto.getDiaChi());
        return nhaXuatBan;
    }
}