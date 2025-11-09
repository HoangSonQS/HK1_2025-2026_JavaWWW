package iuh.fit.se.tuan08_backend.services;

import iuh.fit.se.tuan08_backend.models.NhaCungCap;

import java.util.List;
import java.util.Optional;

public interface NhaCungCapService {
    List<NhaCungCap> findAll();
    Optional<NhaCungCap> findById(long id);
    NhaCungCap save(NhaCungCap nhaCungCap);
    void deleteById(long id);
    List<NhaCungCap> search(String keyword);
}