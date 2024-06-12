package springbook.user;

import springbook.user.dao.DUserDao1;
import springbook.user.dao.NUserDao1;
import springbook.user.dao.UserDao3;
import springbook.user.domain.User;

import java.sql.SQLException;

public class Test3 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        UserDao3 dDao = new DUserDao1();
        UserDao3 nDao = new NUserDao1();

        dDao.clearTable();

        User user1 = new User();
        user1.setId("1");
        user1.setName("one");
        user1.setPassword("first");
        dDao.add(user1);

        User user2 = new User();
        user2.setId("2");
        user2.setName("two");
        user2.setPassword("second");
        nDao.add(user2);

        System.out.println("user1 name : " + dDao.get(user1.getId()).getName());
        System.out.println("user2 name : " + nDao.get(user2.getId()).getName());
    }
}
