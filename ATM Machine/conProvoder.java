package ASSIGNMENT;

import java.sql.Connection;
import java.sql.DriverManager;

public class conProvoder {
    private  static Connection con;
        public static Connection getCon() {
            try {
                if(con==null) {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/vikas";
                    String username = "root";
                    String passward = "root";
                    con = DriverManager.getConnection(url, username, passward);
                }
            }
            catch (Exception e) {
                    e.printStackTrace();
            }
            return  con;
        }
}
