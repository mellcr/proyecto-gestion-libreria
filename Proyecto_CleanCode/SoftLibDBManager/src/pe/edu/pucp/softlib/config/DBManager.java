
package pe.edu.pucp.softlib.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private static DBManager dbManager;
    private String url = "jdbc:mysql://" +
                        "localhost" + 
    //                    "db-prog3-clases.c8izfhuif1lk.us-east-1.rds.amazonaws.com" + 
            ":3306/" + "prog3";
    private String usuario = "root";
    private String password = "shabita17";
    private Connection con;
    
    public static DBManager getInstance(){
        if(dbManager == null)
            createInstance();
        return dbManager;
    }
    
    private static void createInstance(){
        dbManager = new DBManager();
    }
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection
        (url, usuario, password);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
}

