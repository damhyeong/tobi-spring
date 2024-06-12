package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker1 {
    public Connection makeConnection() throws SQLException, ClassNotFoundException;
}
