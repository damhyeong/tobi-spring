package springbook.user;

import springbook.user.dao.UserDao1;
import springbook.user.domain.User;

import java.sql.SQLException;

public class Test1Application {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao1 userDao1 = new UserDao1();

        userDao1.clearTable();

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        userDao1.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = new User();
        user2 = userDao1.get(user.getId());

        System.out.println(user2.getName());
        System.out.println(user2.getPassword());
        System.out.println(user2.getId() + " 조회 성공");

    }
}
