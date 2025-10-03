package iuh.fit.se.baitonghop.daos;

import iuh.fit.se.baitonghop.models.NhaCungCap;

import java.util.List;

public interface NhaCungCapDao {
    public NhaCungCap timTheoMa(long maNcc);

    public List<NhaCungCap> timTheoThongTin(String thongTin);

    public List<NhaCungCap> layTatCa();

    public boolean them(NhaCungCap ncc);

    public boolean capNhat(NhaCungCap ncc);

    public boolean xoa(long maNcc);
}
