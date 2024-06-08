package springbook.user;

import springbook.user.dao.DUserDao1;
import springbook.user.dao.NUserDao1;
import springbook.user.dao.UserDao3;

public class Test3 {
    public static void main(String[] args){
        UserDao3 DDao = new DUserDao1();
        UserDao3 NDao = new NUserDao1();


    }
}
