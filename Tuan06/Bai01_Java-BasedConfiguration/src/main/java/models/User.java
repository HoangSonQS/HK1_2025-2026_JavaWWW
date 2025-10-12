package models;

public class User {
    private String userName;
    private Group group;

    public User() {
    }

    public User(String userName, Group group) {
        this.userName = userName;
        this.group = group;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", group=" + group +
                '}';
    }
}
