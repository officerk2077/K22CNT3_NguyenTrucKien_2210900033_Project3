package com.ntk.ntk.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SachDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String tieuDe;
    private Integer namXuatBan;
    private Integer maTacGia;
    private Integer maNhaXuatBan;
    private Integer soTrang;
    private String moTa;
}