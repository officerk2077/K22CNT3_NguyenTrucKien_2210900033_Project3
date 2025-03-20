package com.ntk.ntk.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Data
@Table(name = "sach", schema = "ntk_qlbq", indexes = {
        @Index(name = "MaTacGia", columnList = "MaTacGia"),
        @Index(name = "MaNhaXuatBan", columnList = "MaNhaXuatBan")
})
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSach", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    @Column(name = "TieuDe", nullable = false)
    private String tieuDe;

    @Column(name = "NamXuatBan", nullable = false)
    private Integer namXuatBan;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "MaTacGia")
    private Tacgia maTacGia;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "MaNhaXuatBan")
    private Nhaxuatban maNhaXuatBan;

    @Column(name = "SoTrang")
    private Integer soTrang;

    @Lob
    @Column(name = "MoTa")
    private String moTa;

    public Tacgia getMaTacGia() {
        return maTacGia;
    }

    public Nhaxuatban getMaNhaXuatBan() {
        return maNhaXuatBan;
    }
}