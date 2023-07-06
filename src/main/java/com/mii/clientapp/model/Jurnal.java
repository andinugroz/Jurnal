package com.mii.clientapp.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jurnal {
    private Long id;

    private String judul;
    private Date tanggal;
    private String jurusan;
    private String penulis;
    private String prodi;
    private String universitas;
    private String status;
    private String abstrak;
    private String data;
}
