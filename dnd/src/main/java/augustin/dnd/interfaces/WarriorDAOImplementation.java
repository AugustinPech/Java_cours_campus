package augustin.dnd.interfaces;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import augustin.dnd.Warrior;
import augustin.dnd.database.DatabaseConnection;


public class WarriorDAOImplementation implements WarriorDAO {
        static Connection con = DatabaseConnection.getConnection();
        @Override
    public int add (Warrior warrior) throws SQLException{
        String query =
        "insert into caracters (sprite, name, className, position, level, stats_id) values (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, ":-)");
        ps.setString(2, warrior.getName());
        ps.setString(3, "Warrior");
        ps.setInt(4, 0);
        ps.setInt(5, 1);
        ps.setInt(6, 1);
        int n = ps.executeUpdate();
        return n;
    };
        @Override
    public int update (Warrior warrior) throws SQLException {
        String query = "update caracters set name=? where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, warrior.getName());
        ps.setInt(2, warrior.getId());
        int n = ps.executeUpdate();
        return n;
    };
        @Override
    public int delete (Warrior warrior) throws SQLException {
        String query = "delete from caracters where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, warrior.getId());
        int n = ps.executeUpdate();
        return n;
    };
        @Override
    public Warrior get (int id) throws SQLException {
        String query = "select * from caracters where id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Warrior warrior = new Warrior();
        while (rs.next()) {
            warrior.setName(rs.getString("name"));
            warrior.setId(rs.getInt("id"));

        }
        return warrior;
    };
}
