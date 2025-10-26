package iuh.fit.se.lab08_springwebmvc_bai02.services;

import iuh.fit.se.lab08_springwebmvc_bai02.models.DienThoai;

import java.util.List;
import java.util.Optional;

public interface DienThoaiService {
    DienThoai save(DienThoai dienThoai);
    void deleteById(long id);
    Optional<DienThoai> findById(long id);
    List<DienThoai> findAll();
    List<DienThoai> findByNhaCungCapId(long maNcc);
    // List<DienThoai> search(String keyword);
}
