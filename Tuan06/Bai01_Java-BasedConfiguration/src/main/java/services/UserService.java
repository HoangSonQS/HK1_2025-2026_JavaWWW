package services;

import models.User;

public class UserService {
    private User user;

    public UserService(User user) {
        this.user = user;
    }

    public void displayUserInfo() {
        System.out.println("--- Thông tin được hiển thị qua UserService ---");
        System.out.println("Tên người dùng: " + user.getUserName());
        System.out.println("Thuộc nhóm: " + user.getGroup().getGroupName());
    }
}