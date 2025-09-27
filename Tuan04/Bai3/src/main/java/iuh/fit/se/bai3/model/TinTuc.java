package iuh.fit.se.bai3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tintucs")
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_tt", nullable = false)
    private long maTT;
    @Column(name = "tieu_de", nullable = false)
    private String tieuDe;
    @Column(name = "noi_dung_tt", nullable = false)
    private String noiDungTT;
    @Column(name = "lien_ket", nullable = false)
    private String lienKet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ma_dm", nullable = false)
    private DanhMuc danhMuc;

    public TinTuc(long maTT, String tieuDe, String noiDungTT, String lienKet, DanhMuc danhMuc) {
        this.maTT = maTT;
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
        this.danhMuc = danhMuc;
    }

    public TinTuc(String tieuDe, String noiDungTT, String lienKet, DanhMuc danhMuc) {
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.lienKet = lienKet;
        this.danhMuc = danhMuc;
    }

    public TinTuc() {
    }

    public long getMaTT() {
        return maTT;
    }

    public void setMaTT(long maTT) {
        this.maTT = maTT;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDungTT() {
        return noiDungTT;
    }

    public void setNoiDungTT(String noiDungTT) {
        this.noiDungTT = noiDungTT;
    }

    public String getLienKet() {
        return lienKet;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
