package br.caro.mysql_jdbc;


import java.sql.*;



public class MySqlJDBC {

    public static void main(String[] args) throws SQLException{
        String sql= "select * from tblemployee";
        String user = System.getenv("env_user");
        String password = System.getenv("env_password");
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?useSSL=false", user ,password);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("empId:" + resultSet.getInt("empId"));
                System.out.println("empName:" + resultSet.getString("empName"));
                System.out.println("birth:" + resultSet.getDate("dob"));
                System.out.println("designation:" + resultSet.getString("designation"));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}
