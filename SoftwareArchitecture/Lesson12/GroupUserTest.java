package SoftwareArchitecture.Lesson12;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupUserTest {

    @org.junit.jupiter.api.Test
    void getUserList() {
        User user = new User("TestName");
        User user2 = new User("TestName 2");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        GroupUser groupUser = new GroupUser(list);
        assertEquals(list, groupUser.getUserList());
    }

    @org.junit.jupiter.api.Test
    void findUser() {
        User user = new User("TestName");
        User user2 = new User("TestName 2");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        GroupUser groupUser = new GroupUser(list);
        assertEquals("TestName", groupUser.findUser("TestName").getName());
    }

    @org.junit.jupiter.api.Test
    void addUser() {
        User user = new User("TestName");
        User user2 = new User("TestName 2");
        User user3 = new User("TestName 3");

        List<User> list = new ArrayList<>();
        List<User> list2 = new ArrayList<>();
        list.add(user);
        list2.add(user);
        list.add(user2);
        list2.add(user2);

        GroupUser groupUser = new GroupUser(list);
        groupUser.addUser(user3);
        list2.add(user3);
        assertEquals(list2, groupUser.getUserList());
    }
}