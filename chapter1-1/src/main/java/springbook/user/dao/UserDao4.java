package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

public class UserDao4 {
    private SimpleConnectionMaker1 simpleConnectionMaker;

    public UserDao4(){
        this.simpleConnectionMaker = new SimpleConnectionMaker1();
    }

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = simpleConnectionMaker.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "insert into users(id, name, password) VALUES (?, ?, ?)"
        );

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.execute();
    }

    public User get(String id) throws SQLException, ClassNotFoundException {
        Connection conn = simpleConnectionMaker.getConnection();

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

        return user;
    }

    public boolean exists(String id) throws SQLException, ClassNotFoundException {
        Connection conn = simpleConnectionMaker.getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM users WHERE id = ?"
        );

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getString("id") != null;
    }

    public boolean clearTable() throws SQLException, ClassNotFoundException {
        Connection conn = simpleConnectionMaker.getConnection();

        Statement stmt = conn.createStatement();
        return stmt.execute(
                "DELETE FROM users"
        );
    }
}
