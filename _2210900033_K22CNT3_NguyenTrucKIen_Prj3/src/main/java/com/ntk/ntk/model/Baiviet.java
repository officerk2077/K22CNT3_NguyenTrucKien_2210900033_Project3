package com.ntk.ntk.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "baiviet", schema = "ntk_qlbq", indexes = {
        @Index(name = "MaUser", columnList = "MaUser")
})
public class Baiviet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBaiViet", nullable = false)
    private Integer id;

    @Column(name = "TieuDe", nullable = false)
    private String tieuDe;

    @Lob
    @Column(name = "NoiDung", nullable = false)
    private String noiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "MaUser")
    private User maUser;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "NgayXuatBan", nullable = false)
    private Instant ngayXuatBan;

    @Column(name = "TheLoai", length = 100)
    private String theLoai;

}