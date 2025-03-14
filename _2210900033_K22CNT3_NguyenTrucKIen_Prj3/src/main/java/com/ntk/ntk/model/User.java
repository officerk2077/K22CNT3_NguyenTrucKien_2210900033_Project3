package com.ntk.ntk.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "ntk_qlbq", uniqueConstraints = {
        @UniqueConstraint(name = "Email", columnNames = {"Email"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaUser", nullable = false)
    private Integer id;

    @Column(name = "TenNguoiDung", nullable = false, length = 100)
    private String tenNguoiDung;

    @Column(name = "Email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;
}
