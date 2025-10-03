package iuh.fit.se.baitonghop.daos;

import iuh.fit.se.baitonghop.models.DienThoai;

import java.util.List;

public interface DienThoaiDao {
    public DienThoai timTheoMa(String maDt);

    public List<DienThoai> layTheoNhaCungCap(long maNcc);

    public List<DienThoai> timKiem(String tuKhoa);

    public boolean them(DienThoai dt);

    public boolean xoa(String maDt);

    public boolean capNhat(DienThoai dt);
}
