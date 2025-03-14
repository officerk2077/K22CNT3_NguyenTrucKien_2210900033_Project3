package com.ntk.ntk.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class BaiVietDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String tieuDe;
    private String noiDung;
    private Integer maUser; // Chỉ lưu ID của User
    private Instant ngayXuatBan;
    private String theLoai;
}