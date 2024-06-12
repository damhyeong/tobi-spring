package springbook;

import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao1;

import java.sql.SQLException;

public class UserDaoTest1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao1 dao = new DaoFactory().userDao1();

        System.out.println("Successful!!");
    }
}
