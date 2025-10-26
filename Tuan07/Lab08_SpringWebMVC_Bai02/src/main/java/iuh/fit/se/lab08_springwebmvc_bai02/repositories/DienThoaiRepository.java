package iuh.fit.se.lab08_springwebmvc_bai02.repositories;
import iuh.fit.se.lab08_springwebmvc_bai02.models.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai, Long> {

    List<DienThoai> findByNhaCungCapMaNCC(long maNcc);

}