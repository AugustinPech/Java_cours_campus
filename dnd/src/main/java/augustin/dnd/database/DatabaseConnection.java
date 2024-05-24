package augustin.dnd.database;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DatabaseConnection {
 
    private static Connection con = null;
 
    static
    {
        String url = "jdbc:mysql://localhost:3306/DnD";
        String user = "AugustinPech";
        String pass = "25111991";
        try {
            Class.forName("augustin.dnd.Warrior");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}