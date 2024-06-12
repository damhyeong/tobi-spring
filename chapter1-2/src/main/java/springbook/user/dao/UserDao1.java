package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

public class UserDao1 {
    private ConnectionMaker1 connectionMaker;

    public UserDao1(ConnectionMaker1 connectionMaker){
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = connectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO users(id, name, password) VALUES (?, ?, ?)"
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
                "SELECT * FROM users WHERE id = ?"
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

    public boolean exists(String id) throws SQLException, ClassNotFoundException {
        Connection conn = connectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement(
                "SELECT EXISTS(SELECT 1 FROM users WHERE id = ?) AS isExist"
        );

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        boolean isExists = rs.getBoolean("isExist");

        rs.close();
        ps.close();
        conn.close();

        return isExists;
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
}
