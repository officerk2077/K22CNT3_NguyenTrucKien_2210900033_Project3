package com.ntk.ntk.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class ChiTietBaiVietDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer maQuanTriVien;
    private String tenQuanTriVien;
    private String eMail;
    private String matKhau;
}
