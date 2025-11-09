package iuh.fit.se.tuan08_backend.services.impl;

import iuh.fit.se.tuan08_backend.models.DienThoai;
import iuh.fit.se.tuan08_backend.repositories.DienThoaiRepository;
import iuh.fit.se.tuan08_backend.services.DienThoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DienThoaiServiceImpl implements DienThoaiService {

    private final DienThoaiRepository dienThoaiRepository;

    @Autowired
    public DienThoaiServiceImpl(DienThoaiRepository dienThoaiRepository) {
        this.dienThoaiRepository = dienThoaiRepository;
    }

    @Override
    @Transactional
    public DienThoai save(DienThoai dienThoai) {
        return dienThoaiRepository.save(dienThoai);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        dienThoaiRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DienThoai> findById(long id) {
        return dienThoaiRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DienThoai> findAll() {
        return dienThoaiRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DienThoai> findByNhaCungCapId(long maNcc) {
        return dienThoaiRepository.findByNhaCungCapMaNCC(maNcc);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public List<DienThoai> search(String keyword) {
//        return dienThoaiRepository.searchByTenOrCauHinh(keyword);;
//    }
}
