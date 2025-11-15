package iuh.fit.se.tuan08_frontend.model;

public class DienThoai {
    private long maDT;
    private String tenDT;
    private int namSanXuat;
    private String cauHinh;
    private NhaCungCap nhaCungCap;
    private String hinhAnh;

    public DienThoai() {
    }

    public DienThoai(long maDT, String tenDT, int namSanXuat, String cauHinh, NhaCungCap nhaCungCap, String hinhAnh) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSanXuat = namSanXuat;
        this.cauHinh = cauHinh;
        this.nhaCungCap = nhaCungCap;
        this.hinhAnh = hinhAnh;
    }

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
}

