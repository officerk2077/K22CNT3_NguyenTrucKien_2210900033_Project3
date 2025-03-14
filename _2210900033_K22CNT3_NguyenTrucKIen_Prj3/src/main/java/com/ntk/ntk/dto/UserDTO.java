package com.ntk.ntk.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String tenNguoiDung;
    private String email;
    private String matKhau;
}