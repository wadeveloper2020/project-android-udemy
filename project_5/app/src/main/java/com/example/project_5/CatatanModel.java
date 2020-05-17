package com.example.project_5;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class CatatanModel extends RealmObject {
    @PrimaryKey
    private int id;
    private String judul;
    private String jumlah_hutang;
    private String tanggal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJumlah_hutang() {
        return jumlah_hutang;
    }

    public void setJumlah_hutang(String jumlah_hutang) {
        this.jumlah_hutang = jumlah_hutang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
