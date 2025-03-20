package com.ntk.ntk.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Data
@Table(name = "baiviet")
public class Baiviet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaBaiViet", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "TieuDe", nullable = false)
    private String tieuDe;

    @NotNull
    @Lob
    @Column(name = "NoiDung", nullable = false)
    private String noiDung;

    @NotNull
    @Column(name = "MaUser", nullable = false)
    private Integer maUser;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "NgayXuatBan", nullable = false)
    private Instant ngayXuatBan;

    @Size(max = 100)
    @Column(name = "TheLoai", length = 100)
    private String theLoai;

}