package com.ntk.ntk.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "tacgia", schema = "ntk_qlbq")
public class Tacgia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTacGia", nullable = false)
    private Integer id;

    @Column(name = "TenTacGia", nullable = false)
    private String tenTacGia;

    @Lob
    @Column(name = "ThongTinLienHe")
    private String thongTinLienHe;

    @Lob
    @Column(name = "TrangThai", nullable = false)
    private String trangThai;

}