
package QLNoiThat;

import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {

    public Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLNoiThatHoaPhat;useUnicode=true&characterEncoding=utf8";
            String user = "sa";
            String pwd = "123";
            conn = DriverManager.getConnection(url,user,pwd);
            if(conn != null)
                System.out.println("Kết nối thành công!");
        }catch(SQLException e){
            System.out.println(e.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
