package com.ntk.ntk.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TacGiaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String tenTacGia;
    private String thongTinLienHe;
    private String trangThai;
}