package iuh.fit.se.bai3.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="danhmucs")
public class DanhMuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dm", nullable = false)
    private long maDM;
    @Column(name = "ten_danh_muc", nullable = false)
    private String tenDanhMuc;
    @Column(name = "nguoi_quan_ly", nullable = false)
    private String nguoiQuanLy;
    @Column(name = "ghi_chu", nullable = false)
    private String ghiChu;
    @OneToMany(mappedBy = "danhMuc", cascade = CascadeType.ALL)
    private List<TinTuc> tinTucs;

    public DanhMuc(String ghiChu, String nguoiQuanLy, String tenDanhMuc, long maDM) {
        this.ghiChu = ghiChu;
        this.nguoiQuanLy = nguoiQuanLy;
        this.tenDanhMuc = tenDanhMuc;
        this.maDM = maDM;
    }

    public DanhMuc(String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
        this.tenDanhMuc = tenDanhMuc;
        this.nguoiQuanLy = nguoiQuanLy;
        this.ghiChu = ghiChu;
    }

    public DanhMuc() {
    }

    public long getMaDM() {
        return maDM;
    }

    public void setMaDM(long maDM) {
        this.maDM = maDM;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getNguoiQuanLy() {
        return nguoiQuanLy;
    }

    public void setNguoiQuanLy(String nguoiQuanLy) {
        this.nguoiQuanLy = nguoiQuanLy;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
