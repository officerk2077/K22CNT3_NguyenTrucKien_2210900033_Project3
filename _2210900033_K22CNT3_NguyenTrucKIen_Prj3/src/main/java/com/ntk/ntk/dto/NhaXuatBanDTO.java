package com.ntk.ntk.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NhaXuatBanDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String tenNhaXuatBan;
    private String diaChi;
}