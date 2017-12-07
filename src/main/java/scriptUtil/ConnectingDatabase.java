package scriptUtil;

import org.junit.BeforeClass;

import java.sql.*;
import java.util.ArrayList;

public class ConnectingDatabase {
    public static Statement stat;
    public static Connection conn;
    public static String connectDB(){
    System.out.println("Setting Up Database Connection");
    try {
        Class.forName("org.h2.Driver");
    }
    catch(ClassNotFoundException e){
        System.out.println("Error in Database Driver");
        return "failed";
    }
        try{ conn = DriverManager.getConnection("jdbc:h2:~/test");
             stat = conn.createStatement();
            stat.execute("CREATE TABLE if not Exists TEST AS SELECT * FROM CSVREAD('D:\\Selenium\\TestProject\\src\\main\\resources\\TestData.csv');");

        }
        catch (SQLException e) {
           System.out.println("Issue in SQL Query");
            return "Failed";
        }

        return "Pass";
    }



}





