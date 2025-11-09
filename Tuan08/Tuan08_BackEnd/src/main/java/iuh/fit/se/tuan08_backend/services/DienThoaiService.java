package iuh.fit.se.tuan08_backend.services;


import iuh.fit.se.tuan08_backend.models.DienThoai;

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
