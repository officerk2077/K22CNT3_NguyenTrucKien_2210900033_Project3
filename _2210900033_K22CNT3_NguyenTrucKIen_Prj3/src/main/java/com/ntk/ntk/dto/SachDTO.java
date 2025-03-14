package com.ntk.ntk.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SachDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String tieuDe;
    private Integer namXuatBan;
    private Integer maTacGia; // Chỉ lưu ID thay vì toàn bộ object Tacgia
    private Integer maNhaXuatBan; // Chỉ lưu ID thay vì toàn bộ object Nhaxuatban
    private Integer soTrang;
    private String moTa;
}