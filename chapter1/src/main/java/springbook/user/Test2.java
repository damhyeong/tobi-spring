package springbook.user;

import springbook.user.dao.UserDao2;
import springbook.user.domain.User;

import java.sql.SQLException;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao2 userDao2 = new UserDao2();

        userDao2.clearTable();

        User user = new User();
        user.setId("1");
        user.setName("jason");
        user.setPassword("1234");

        userDao2.add(user);

        User user2 = userDao2.get(user.getId());

        System.out.println(user2.getId() + user2.getName() + user2.getPassword());

        System.out.println(userDao2.exists(user2.getId()));
    }
}
