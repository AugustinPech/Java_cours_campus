package augustin.dnd.interfaces;

import java.sql.SQLException;
import java.util.List;

import augustin.dnd.Warrior;

public interface WarriorDAO {
    public int add (Warrior warrior) throws SQLException;
    public int update (Warrior warrior) throws SQLException;
    public int delete (Warrior warrior) throws SQLException;
    public Warrior get (int id) throws SQLException;

}
