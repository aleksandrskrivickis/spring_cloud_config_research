package configcl.util;
import java.sql.*;

public class MySqlConnMan {
    public static Connection establishConnection(String host, String port, String usr, String pwd) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + port + "/generatedata", usr, pwd);
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException cne) {
            System.out.println("ClassNotFoundException: " + cne.getMessage());
        }
        return con;
    }

    public static String selectData(Connection con) {
        String returnable = "";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from gd_cities");
            while (rs.next()){
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
                returnable += rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "\n";
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return returnable;
    }
}
