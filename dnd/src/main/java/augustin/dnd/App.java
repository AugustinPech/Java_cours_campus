package augustin.dnd;

import java.sql.SQLException;
import java.util.List;
import augustin.dnd.interfaces.WarriorDAOImplementation;

public class App 
{

    public static void main( String[] args ) throws SQLException
    {
        WarriorDAOImplementation warriorDAO
            = new WarriorDAOImplementation();
        Warrior war = warriorDAO.get(4);
        System.out.println(war.getName());
        war.setName("toto le poulpe");
        warriorDAO.update(war);
        war = warriorDAO.get(5);
        System.out.println(war.getName());
        warriorDAO.add(war);
        warriorDAO.delete(war);
    }
}
