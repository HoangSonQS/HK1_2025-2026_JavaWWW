package iuh.fit.se.lab08_springwebmvc_bai02.services;



import iuh.fit.se.lab08_springwebmvc_bai02.models.NhaCungCap;

import java.util.List;
import java.util.Optional;

public interface NhaCungCapService {
    List<NhaCungCap> findAll();
    Optional<NhaCungCap> findById(long id);
    NhaCungCap save(NhaCungCap nhaCungCap);
    void deleteById(long id);
    List<NhaCungCap> search(String keyword);
}