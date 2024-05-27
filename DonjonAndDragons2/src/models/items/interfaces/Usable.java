package DonjonAndDragons2.src.models.items.interfaces;

import java.util.ArrayList;

import DonjonAndDragons2.src.models.Caracters.Caracter;

public interface Usable {
        public abstract ArrayList<Caracter> use(ArrayList<Caracter> caracter, int roll);

}
