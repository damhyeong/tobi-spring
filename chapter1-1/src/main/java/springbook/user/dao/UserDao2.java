package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

public class UserDao2 {
    public void add(User user) throws SQLException, ClassNotFoundException{
        Connection c = getConnection();

        PreparedStatement ptst = c.prepareStatement("insert into users values(?, ?, ?)");

        ptst.setString(1, user.getId());
        ptst.setString(2, user.getName());
        ptst.setString(3, user.getPassword());

        ptst.executeUpdate();

        ptst.close();
        c.close();
    }

    public User get(String id) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();

        PreparedStatement ptst = c.prepareStatement("Select * from users where id = ?");

        ptst.setString(1, id);

        ResultSet rs = ptst.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ptst.close();
        c.close();

        return user;
    }

    public boolean exists(String id) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();

        PreparedStatement ptst = c.prepareStatement(
                "select id from users where id = ?"
        );

        ptst.setString(1, id);

        ResultSet rs = ptst.executeQuery();
        rs.next();

        String result = rs.getString("id");

        rs.close();
        ptst.close();
        c.close();

        return result != null;
    }

    public void clearTable() throws SQLException, ClassNotFoundException {
        Connection c = getConnection();

        Statement st = c.createStatement();

        st.execute("DELETE FROM users");

        st.close();
        c.close();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/springbook", "spring", "book"
        );
        return c;
    }
}
