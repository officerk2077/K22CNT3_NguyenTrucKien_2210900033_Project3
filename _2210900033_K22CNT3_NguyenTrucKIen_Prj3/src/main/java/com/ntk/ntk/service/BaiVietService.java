package com.ntk.ntk.service;

import com.ntk.ntk.dto.BaiVietDTO;
import com.ntk.ntk.model.Baiviet;
import com.ntk.ntk.model.User;
import com.ntk.ntk.repository.BaiVietRepository;
import com.ntk.ntk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class BaiVietService {

    @Autowired
    private BaiVietRepository baiVietRepository;

    @Autowired
    private UserRepository userRepository;

    // Read: Lấy danh sách tất cả bài viết
    public List<Baiviet> getBaiVietList() {
        return baiVietRepository.findAll();
    }

    // Read: Lấy bài viết theo ID
    public Optional<Baiviet> getBaiVietById(Integer id) {
        return baiVietRepository.findById(id);
    }

    // Create/Update: Lưu bài viết
    public Baiviet saveBaiViet(Baiviet baiViet) {
        if (baiViet.getNgayXuatBan() == null) {
            baiViet.setNgayXuatBan(Instant.now()); // Gán mặc định nếu không có ngày xuất bản
        }
        return baiVietRepository.save(baiViet);
    }

    // Delete: Xóa bài viết
    public void deleteBaiViet(Integer id) {
        baiVietRepository.deleteById(id);
    }

    // Chuyển đổi từ DTO sang Entity
    public Baiviet convertToEntity(BaiVietDTO dto) {
        Baiviet baiViet = new Baiviet();
        baiViet.setId(dto.getId());
        baiViet.setTieuDe(dto.getTieuDe());
        baiViet.setNoiDung(dto.getNoiDung());
        baiViet.setNgayXuatBan(dto.getNgayXuatBan());
        baiViet.setTheLoai(dto.getTheLoai());

        if (dto.getMaUser() != null) {
            User user = userRepository.findById(dto.getMaUser())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid User ID"));
            baiViet.setMaUser(user);
        }

        return baiViet;
    }
}