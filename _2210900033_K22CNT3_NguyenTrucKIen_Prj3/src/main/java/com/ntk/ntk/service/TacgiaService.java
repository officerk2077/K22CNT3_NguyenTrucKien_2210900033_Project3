package com.ntk.ntk.service;

import com.ntk.ntk.dto.TacGiaDTO;
import com.ntk.ntk.model.Tacgia;
import com.ntk.ntk.repository.TacGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TacgiaService {

    @Autowired
    private TacGiaRepository tacGiaRepository;

    // Read: Lấy danh sách tất cả tác giả
    public List<Tacgia> getTacgiaList() {
        return tacGiaRepository.findAll();
    }

    // Read: Lấy tác giả theo ID
    public Optional<Tacgia> getTacgiaById(Integer id) {
        return tacGiaRepository.findById(id);
    }

    // Create/Update: Lưu tác giả
    public Tacgia saveTacgia(Tacgia tacgia) {
        return tacGiaRepository.save(tacgia);
    }

    // Delete: Xóa tác giả
    public void deleteTacgia(Integer id) {
        tacGiaRepository.deleteById(id);
    }

    // Chuyển đổi từ DTO sang Entity
    public Tacgia convertToEntity(TacGiaDTO dto) {
        Tacgia tacgia = new Tacgia();
        tacgia.setId(dto.getId());
        tacgia.setTenTacGia(dto.getTenTacGia());
        tacgia.setThongTinLienHe(dto.getThongTinLienHe());
        tacgia.setTrangThai(dto.getTrangThai());
        return tacgia;
    }
}