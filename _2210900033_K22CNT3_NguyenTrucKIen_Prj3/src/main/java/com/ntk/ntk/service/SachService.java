package com.ntk.ntk.service;

import com.ntk.ntk.dto.SachDTO;
import com.ntk.ntk.model.Sach;
import com.ntk.ntk.model.Tacgia;
import com.ntk.ntk.model.Nhaxuatban;
import com.ntk.ntk.repository.SachRepository;
import com.ntk.ntk.repository.TacGiaRepository;
import com.ntk.ntk.repository.NhaXuatBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SachService {

    @Autowired
    private SachRepository sachRepository;

    @Autowired
    private TacGiaRepository tacGiaRepository;

    @Autowired
    private NhaXuatBanRepository nhaXuatBanRepository;

    // Phương thức đếm tổng số sách
    public long countTotalBooks() {
        return sachRepository.count();
    }

    // Read: Lấy danh sách tất cả sách
    public List<Sach> getSachList() {
        return sachRepository.findAll();
    }

    // Read: Lấy sách theo ID
    public Optional<Sach> getSachById(Integer id) {
        return sachRepository.findById(id);
    }

    // Create/Update: Lưu sách
    public Sach saveSach(Sach sach) {
        return sachRepository.save(sach);
    }

    // Delete: Xóa sách
    public void deleteSach(Integer id) {
        sachRepository.deleteById(id);
    }

    // Chuyển đổi từ DTO sang Entity
    public Sach convertToEntity(SachDTO dto) {
        Sach sach = new Sach();
        sach.setId(dto.getId());
        sach.setTieuDe(dto.getTieuDe());
        sach.setNamXuatBan(dto.getNamXuatBan());
        sach.setSoTrang(dto.getSoTrang());
        sach.setMoTa(dto.getMoTa());

        if (dto.getMaTacGia() != null) {
            Tacgia tacgia = tacGiaRepository.findById(dto.getMaTacGia())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Tacgia ID"));
            sach.setMaTacGia(tacgia);
        }

        if (dto.getMaNhaXuatBan() != null) {
            Nhaxuatban nxb = nhaXuatBanRepository.findById(dto.getMaNhaXuatBan())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Nhaxuatban ID"));
            sach.setMaNhaXuatBan(nxb);
        }

        return sach;
    }
}