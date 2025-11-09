package iuh.fit.se.tuan08_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dienthoais")
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dt")
    private long maDT;

    @Column(name = "ten_dt")
    private String tenDT;

    @Column(name = "nam_san_xuat")
    private int namSanXuat;

    @Column(name = "cau_hinh")
    private String cauHinh;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_ncc")
    private NhaCungCap nhaCungCap;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    public long getMaDT() {
        return maDT;
    }

    public void setMaDT(long maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }



    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "DienThoai{" +
                "maDT=" + maDT +
                ", tenDT='" + tenDT + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", cauHinh='" + cauHinh + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                '}';
    }
}
