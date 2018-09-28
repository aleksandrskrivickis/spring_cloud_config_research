package org.gradle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMySql {
    public static void main (String [] args ) throws ClassNotFoundException, SQLException{
//        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8&user=root&password=root";
        Connection conn = DriverManager.getConnection(connectionUrl);
        ResultSet rs = conn.prepareStatement("show tables").executeQuery();

        while(rs.next()){
            String s = rs.getString(1);
            System.out.println(s);
        }
    }
}