package br.caro.part2;






import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBCP2Connection {

    private static BasicDataSource dataSource = null;

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/empdb?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        dataSource.setMinIdle(1);
        dataSource.setMaxIdle(5);
        dataSource.setMaxTotal(7);

    }

    public static BasicDataSource getInstance() {
        if (dataSource == null) {
            synchronized (BasicDataSource.class) {
                if (dataSource == null) {
                    dataSource = new BasicDataSource();
                }
            }
        }
        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }



}
