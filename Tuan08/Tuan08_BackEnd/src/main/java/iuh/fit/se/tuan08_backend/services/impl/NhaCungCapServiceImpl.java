package iuh.fit.se.tuan08_backend.services.impl;

import iuh.fit.se.tuan08_backend.models.NhaCungCap;
import iuh.fit.se.tuan08_backend.repositories.NhaCungCapRepository;
import iuh.fit.se.tuan08_backend.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;

    @Override
    public List<NhaCungCap> findAll() {
        return nhaCungCapRepository.findAll();
    }

    @Override
    public Optional<NhaCungCap> findById(long id) {
        return nhaCungCapRepository.findById(id);
    }

    @Override
    public NhaCungCap save(NhaCungCap nhaCungCap) {
        return nhaCungCapRepository.save(nhaCungCap);
    }

    @Override
    public void deleteById(long id) {
        nhaCungCapRepository.deleteById(id);
    }

    @Override
    public List<NhaCungCap> search(String keyword) {
        return nhaCungCapRepository.searchByKeyword(keyword);
    }
}