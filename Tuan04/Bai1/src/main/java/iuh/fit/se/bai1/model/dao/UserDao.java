package iuh.fit.se.bai1.model.dao;

import iuh.fit.se.bai1.model.entity.User;

import java.util.List;

public interface UserDao {
    public User save(User user);
    public User update(User user);
    public boolean delete(String userId);
    public User findById(String userId);
    public List<User> findAll();
}
