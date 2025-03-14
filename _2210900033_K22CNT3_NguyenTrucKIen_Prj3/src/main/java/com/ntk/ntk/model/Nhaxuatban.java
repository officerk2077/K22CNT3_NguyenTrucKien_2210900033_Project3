package com.ntk.ntk.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "nhaxuatban", schema = "ntk_qlbq")
public class Nhaxuatban {
    @Id
    @Column(name = "MaNhaXuatBan", nullable = false)
    private Integer id;

    @Column(name = "TenNhaXuatBan", nullable = false, length = 100)
    private String tenNhaXuatBan;

    @Lob
    @Column(name = "DiaChi")
    private String diaChi;

}