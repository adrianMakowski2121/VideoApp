package application.model;

import java.util.ArrayList;
import java.util.List;

public class StorageUser{

    List<User> userList = new ArrayList<>();

    public void userAdd(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }
}
