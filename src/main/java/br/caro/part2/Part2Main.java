package br.caro.part2;

import javax.sql.DataSource;
import java.sql.*;



public class Part2Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            DBCP2Connection.getInstance();
            DBCP2Connection db = new DBCP2Connection();
            connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from tblemployee");
            while (resultSet.next()) {
                System.out.println("empId:" + resultSet.getInt("empId"));
                System.out.println("empName:" + resultSet.getString("empName"));
                System.out.println("birth:" + resultSet.getDate("dob"));
                System.out.println("designation:" + resultSet.getString("designation"));
            }
        } finally {

            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}
