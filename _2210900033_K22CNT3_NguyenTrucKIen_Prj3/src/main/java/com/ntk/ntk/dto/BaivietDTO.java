package com.ntk.ntk.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
@Getter
@Setter
@Data
public class BaivietDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    @NotNull
    @Size(max = 255)
    private String tieuDe;

    @NotNull
    private String noiDung;

    private Integer maUser; // Assuming User ID for simplicity

    private Instant ngayXuatBan;

    @Size(max = 100)
    private String theLoai;
}