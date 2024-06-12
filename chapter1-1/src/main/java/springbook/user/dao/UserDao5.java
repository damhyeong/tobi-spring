package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

public class UserDao5 {
    private ConnectionMaker1 connectionMaker;

    public UserDao5(){
        this.connectionMaker = new DConnectionMaker();
    }

    public void add(User user) throws SQLException, ClassNotFoundException{
        Connection conn = connectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)"
        );

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws SQLException, ClassNotFoundException {
        Connection conn = connectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement(
                "select * from users where id = ?"
        );

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        conn.close();

        return user;
    }

    public void clearTable() throws SQLException, ClassNotFoundException {
        Connection conn = connectionMaker.makeConnection();

        Statement stmt = conn.createStatement();

        stmt.execute(
                "DELETE FROM users"
        );

        stmt.close();
        conn.close();
    }

    public boolean exists(String id) throws SQLException, ClassNotFoundException {
        Connection conn = connectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement(
                "select exists(select 1 from users where id = ?) AS isExists"
        );

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        boolean isExists = rs.getBoolean("isExists");

        rs.close();
        ps.close();
        conn.close();

        return isExists;
    }
}
