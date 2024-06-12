package springbook.user;

import springbook.user.dao.ConnectionMaker1;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.UserDao6;
import springbook.user.domain.User;

import java.sql.SQLException;

public class Test6 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        ConnectionMaker1 connectionMaker1 = new DConnectionMaker();

        UserDao6 userDao = new UserDao6(connectionMaker1);

        userDao.clearTable();

        User user = new User();
        user.setId("1");
        user.setName("kong");
        user.setPassword("dam");

        userDao.add(user);

        System.out.println("Successful that insert data into users.");

        System.out.println("Get User id = 1 .. " + userDao.get("1").getName());

        System.out.println("is this id exists? 1 == : " + userDao.isExistId("1"));
    }
}
