package br.caro.part2;

import br.caro.part2.bef.ConnPool;
import org.apache.commons.dbcp2.*;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBCP2Connection {
  //  private static volatile DBCP2Connection dataSource;

    private static BasicDataSource dataSource = null;

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/empdb?useSSL=false");
        dataSource.setUsername(System.getenv(ENV_USER));
        dataSource.setPassword(System.getenv(ENV_PASSWORD));

        dataSource.setMinIdle(1);
        dataSource.setMaxIdle(5);
        dataSource.setMaxTotal(7);

    }

    public static BasicDataSource getInstance() {
        if (dataSource == null) {
            synchronized (ConnPool.class) {
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
