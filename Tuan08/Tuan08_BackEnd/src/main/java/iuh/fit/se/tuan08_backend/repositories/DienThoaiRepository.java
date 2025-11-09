package iuh.fit.se.tuan08_backend.repositories;

import iuh.fit.se.tuan08_backend.models.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai, Long> {

    List<DienThoai> findByNhaCungCapMaNCC(long maNcc);

}