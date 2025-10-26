package iuh.fit.se.lab08_springwebmvc_bai02.repositories;


import iuh.fit.se.lab08_springwebmvc_bai02.models.NhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Long> {

    // Truy vấn tìm kiếm NCC (tương tự chức năng tìm kiếm cũ)
    @Query("SELECT ncc FROM NhaCungCap ncc WHERE " +
            "LOWER(ncc.tenNhaCC) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(ncc.diaChi) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "ncc.soDienThoai LIKE CONCAT('%', :keyword, '%')")
    List<NhaCungCap> searchByKeyword(@Param("keyword") String keyword);
}
