package iuh.fit.se.tuan08_backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhacungcaps")
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ncc")
    private long maNCC;

    @Column(name = "ten_nha_cc")
    private String tenNhaCC;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @JsonIgnore
    @OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DienThoai> dsDienThoai;

    public long getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(long maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNhaCC() {
        return tenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        this.tenNhaCC = tenNhaCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<DienThoai> getDsDienThoai() {
        return dsDienThoai;
    }

    public void setDsDienThoai(List<DienThoai> dsDienThoai) {
        this.dsDienThoai = dsDienThoai;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "maNCC=" + maNCC +
                ", tenNhaCC='" + tenNhaCC + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
