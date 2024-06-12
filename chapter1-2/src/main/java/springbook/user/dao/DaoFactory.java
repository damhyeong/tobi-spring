package springbook.user.dao;

public class DaoFactory {
    public UserDao1 userDao1(){
        ConnectionMaker1 connectionMaker= new DConnectionMaker1();
        UserDao1 userDao = new UserDao1(connectionMaker);
        return userDao;
    }
}
