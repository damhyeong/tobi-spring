package springbook.user;

import springbook.user.dao.UserDao4;
import springbook.user.domain.User;

import java.sql.SQLException;

public class Test4 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        UserDao4 userDao4 = new UserDao4();

        userDao4.clearTable();

        User user = new User();
        user.setId("1");
        user.setName("kong");
        user.setPassword("dam");

        userDao4.add(user);

        User checkUser = userDao4.get(user.getId());

        System.out.println("id : " + checkUser.getId() + ", name : " + checkUser.getName() + ", password : " + checkUser.getPassword());


    }
}
