package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

public abstract class UserDao3 {
    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

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
    public User get(String id) throws SQLException, ClassNotFoundException{
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "select * from users where id = ?"
        );

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
    public boolean exists(String id) throws SQLException, ClassNotFoundException{
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(
                "select id from users where id = ?"
        );
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        String result = rs.getString("id");

        rs.close();
        ps.close();
        conn.close();

        return result != null;
    }
    public void clearTable() throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        Statement stmt = conn.createStatement();

        stmt.execute(
                "DELETE * FROM users"
        );

        stmt.close();
        conn.close();
    }

    public abstract Connection getConnection() throws SQLException, ClassNotFoundException;
}